package com.example.akbar.book_ing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Akbar on 4/13/2018.
 */
public class Dashboard extends AppCompatActivity {

    TextView buy1,sell1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        buy1=(TextView)findViewById(R.id.buy1);
        sell1=(TextView)findViewById(R.id.sell1);
        buy1.setOnClickListener(buyListener);
        sell1.setOnClickListener(sellListener);
    }

    View.OnClickListener buyListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(getApplicationContext(),Buying.class);
            startActivity(i);
        }
    };
    View.OnClickListener sellListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(getApplicationContext(),Selling.class);
            startActivity(i);
        }
    };
}
