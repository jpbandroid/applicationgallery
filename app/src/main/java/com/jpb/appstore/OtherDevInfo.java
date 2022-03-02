package com.jpb.appstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OtherDevInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_dev_info);
        this.setTitle("Apps by other devs");
        CardView stcard = findViewById(R.id.saicard);
        stcard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), SAIInfo.class);
                startActivity(intent);
            }
        });
        CardView stmd3card = findViewById(R.id.stmd3card);
        stmd3card.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), STmd3Info.class);
                startActivity(intent);
            }
        });
        CardView notecard = findViewById(R.id.notescard);
        notecard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), NotesInfo.class);
                startActivity(intent);
            }
        });
        CardView accard = findViewById(R.id.aclcard);
        accard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ACLaunchInfo.class);
                startActivity(intent);
            }
        });
    }
}