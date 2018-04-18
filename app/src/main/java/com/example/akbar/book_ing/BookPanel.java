package com.example.akbar.book_ing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Akbar on 4/15/2018.
 */
public class BookPanel extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Book book;
    TextView bn3,an3,bp3,sn3,cn3,yn3;
    Button buy3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_panel);
        Intent i=getIntent();
        final String key=i.getStringExtra("key");
        bn3=(TextView)findViewById(R.id.bn3);
        an3=(TextView)findViewById(R.id.an3);
        bp3=(TextView)findViewById(R.id.bp3);
        sn3=(TextView)findViewById(R.id.sn3);
        cn3=(TextView)findViewById(R.id.cn3);
        yn3=(TextView)findViewById(R.id.yn3);
        buy3=(Button)findViewById(R.id.buy3);
        an3.setText(key);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("Books");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.getKey().equals(key)) {
                    book = dataSnapshot.getValue(Book.class);
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

        bn3.setText(book.getBookName());
        an3.setText(book.getAuthorName());
        bp3.setText(book.getBookPrice());
        sn3.setText(book.getSubjectName());
        yn3.setText(book.getYear());
        buy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book.setSold(true);
                Toast.makeText(getApplicationContext(),"we did it",Toast.LENGTH_LONG).show();
            }
        });
    }
}
