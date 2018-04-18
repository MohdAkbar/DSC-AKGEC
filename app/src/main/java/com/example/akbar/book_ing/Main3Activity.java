package com.example.akbar.book_ing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends AppCompatActivity {

   EditText usersign,emailsign,phnosign,pass1sign,pass2sign;
    Spinner spinner1sign;
    Button submitsign;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        usersign=(EditText)findViewById(R.id.usersign);
        emailsign=(EditText)findViewById(R.id.emailsign);
        phnosign=(EditText)findViewById(R.id.phnosign);
        pass1sign=(EditText)findViewById(R.id.pass1sign);
        pass2sign=(EditText)findViewById(R.id.pass2sign);
        spinner1sign=(Spinner)findViewById(R.id.spinner1sign);
        submitsign=(Button)findViewById(R.id.submitsign);
        submitsign.setOnClickListener(submitListener);
        firebaseDatabase=FirebaseDatabase.getInstance();
        addItemsInSpinner();
    }

    private void addItemsInSpinner() {
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.field,R.layout.support_simple_spinner_dropdown_item);
        spinner1sign.setAdapter(adapter);
        spinner1sign.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s1=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    View.OnClickListener submitListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String u1=usersign.getText().toString();
            String e1=emailsign.getText().toString();
            String p1=phnosign.getText().toString();
            String ps1=pass1sign.getText().toString();
            String ps2=pass2sign.getText().toString();
            if((!u1.equals(""))&&(!e1.equals(""))&&(!p1.equals(""))&&(!ps1.equals(""))&&(!ps2.equals(""))&&(!s1.equals("")))
            {
                if(ps1.equals(ps2)) {
                    databaseReference=firebaseDatabase.getReference().child(p1);
                    SignUp ob=new SignUp(u1,e1,ps1,s1,p1);
                    databaseReference.push().setValue(ob);
                    Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Both passwords different",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Fill all the details",Toast.LENGTH_LONG).show();
            }
        }
    };
}
