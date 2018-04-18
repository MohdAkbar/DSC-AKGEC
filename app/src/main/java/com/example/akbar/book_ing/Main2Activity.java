package com.example.akbar.book_ing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {

    EditText username,password;
    Button login,signup;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
        login.setOnClickListener(loginListener);
        signup.setOnClickListener(signUpListener);
        firebaseDatabase=FirebaseDatabase.getInstance();
    }
    View.OnClickListener signUpListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(getApplicationContext(),Main3Activity.class);
            startActivity(i);
        }
    };
    View.OnClickListener loginListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String u2=username.getText().toString();
            final String ps2=password.getText().toString();
            if((!u2.equals(""))&&(!ps2.equals("")))
            {
                databaseReference=firebaseDatabase.getReference().child(u2);
                databaseReference.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        String ps22=dataSnapshot.getValue(SignUp.class).getPassword();
                        if(ps22.equals(ps2))
                        {
                            Toast.makeText(getApplicationContext(),"Dashboard entered",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getApplicationContext(),Dashboard.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Wrong Password or Username",Toast.LENGTH_LONG).show();
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
                        Toast.makeText(getApplicationContext(),"Dashboard error",Toast.LENGTH_LONG).show();
                    }
                });

            }
            else
            {
                Toast.makeText(getApplicationContext(),"Enter username & Password",Toast.LENGTH_LONG).show();
            }
        }
    };
}
