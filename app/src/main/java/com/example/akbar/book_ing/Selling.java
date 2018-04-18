package com.example.akbar.book_ing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Akbar on 4/13/2018.
 */
public class Selling extends AppCompatActivity {

    EditText bn1,an1,bp1,sn1,cn1,yn1;
    Button sell1;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selling);
        bn1=(EditText)findViewById(R.id.bn1);
        an1=(EditText)findViewById(R.id.an1);
        bp1=(EditText)findViewById(R.id.bp1);
        sn1=(EditText)findViewById(R.id.sn1);
        cn1=(EditText)findViewById(R.id.cn1);
        yn1=(EditText)findViewById(R.id.yn1);
        sell1=(Button)findViewById(R.id.sell1);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("Books");
        sell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bn2=bn1.getText().toString();
                String an2=an1.getText().toString();
                String sn2=sn1.getText().toString();
                String cn2=cn1.getText().toString();
                String yn2=yn1.getText().toString();
                String bp2=bp1.getText().toString();
                Book ob=new Book(bn2,an2,cn2,yn2,sn2,bp2,false);
                databaseReference.push().setValue(ob);
                Intent i=new Intent(getApplicationContext(),Dashboard.class);
                startActivity(i);
            }
        });
    }


}
