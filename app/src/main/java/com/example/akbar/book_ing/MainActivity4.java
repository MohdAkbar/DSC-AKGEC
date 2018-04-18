package com.example.akbar.book_ing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity4 extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    TextView tv1;
    Button bt1,bt2;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        ed3=(EditText)findViewById(R.id.ed3);
        tv1=(TextView)findViewById(R.id.tv1);
        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        bt1.setOnClickListener(bt1Listener);
        bt2.setOnClickListener(bt2Listener);
    }

    View.OnClickListener bt1Listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            firebaseDatabase=FirebaseDatabase.getInstance();
            String ed1d=ed1.getText().toString();
            String ed2d=ed2.getText().toString();
            databaseReference=firebaseDatabase.getReference().child(ed1d);
            Password pass1=new Password(ed2d);
            databaseReference.push().setValue(pass1);
        }
    };
    View.OnClickListener bt2Listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String ed3d=ed3.getText().toString();
            databaseReference=firebaseDatabase.getReference().child(ed3d);
            databaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String p1=dataSnapshot.getValue().toString();
                    tv1.setText(p1);
                    //try {
                        //JSONObject ob=new JSONObject(p1);
                        //tv1.setText(ob.getString("password"));
                    //} catch (JSONException e) {
                      //  e.printStackTrace();
                    //}
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
    };

    class Password
    {
        String password;
        public Password(String password)
        {
            this.password=password;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


}
