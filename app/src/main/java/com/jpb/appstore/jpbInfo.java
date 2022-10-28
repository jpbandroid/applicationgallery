package com.jpb.appstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class jpbInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpb_info);
        this.setTitle("Apps by jpb");
        CardView stcard = findViewById(R.id.stcard);
        stcard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), STInfo.class);
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
        CardView jpbmusiccard = findViewById(R.id.jpbmusiccard);
        jpbmusiccard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), jpbMusicInfo.class);
                startActivity(intent);
            }
        });
        CardView uspcard = findViewById(R.id.uspcard);
        uspcard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), UspInfo.class);
                startActivity(intent);
            }
        });
    }
}