package com.jpb.appstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class alldev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldev);
        this.setTitle("All Developers");
        Button jpb = findViewById(R.id.button3);
        jpb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), jpbInfo.class);
                startActivity(intent);
            }
        });
        Button otherdev = findViewById(R.id.button12);
        otherdev.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), OtherDevInfo.class);
                startActivity(intent);
            }
        });
    }
}