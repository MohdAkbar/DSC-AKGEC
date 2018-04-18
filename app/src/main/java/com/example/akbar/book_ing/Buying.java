package com.example.akbar.book_ing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akbar on 4/13/2018.
 */
public class Buying extends AppCompatActivity {

    EditText course1,year1,subject1;
    Button search1;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView tv5;
    List<Book> book;
    MyAdapter adapter;
    ListView lView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buying);
        course1=(EditText)findViewById(R.id.course1);
        year1=(EditText)findViewById(R.id.year1);
        subject1=(EditText)findViewById(R.id.subject1);
        search1=(Button)findViewById(R.id.search1);
        lView=(ListView)findViewById(R.id.lView);
        search1.setOnClickListener(search1Listener);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("Books");
        book=new ArrayList<>();
        adapter=new MyAdapter(this,R.layout.row_layout,book);
        lView.setAdapter(adapter);
        lView.setOnItemClickListener(lViewListener);
    }

    View.OnClickListener search1Listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String c=course1.getText().toString();
            String y=year1.getText().toString();
            String s=subject1.getText().toString();
            if(!c.equals("")&&(!y.equals(""))&&(!s.equals(""))) {
                c=c.trim();
                y=y.trim();
                s=s.trim();
                findBooks(c, y, s);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Fill all fields to get Books",Toast.LENGTH_LONG).show();
            }
        }
    };

    private void findBooks(final String c,String a, final String str) {
        databaseReference.orderByChild("authorName").equalTo(a).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Book ob=dataSnapshot.getValue(Book.class);
                ob.setBookKey(dataSnapshot.getKey());
                if((ob.getCourseName().equalsIgnoreCase(c))&&(ob.getSubjectName().equalsIgnoreCase(str)))
                {
                    if(!ob.isSold())
                    {
                        adapter.add(ob);
                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    AdapterView.OnItemClickListener lViewListener= new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Book ob= (Book) adapterView.getItemAtPosition(i);
            Toast.makeText(getApplicationContext(),"You selected "+ob.getBookName(),Toast.LENGTH_LONG).show();
            
        }
    };

}
