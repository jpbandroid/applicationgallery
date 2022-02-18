package com.jpb.appstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class STInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stinfo);
        this.setTitle("ScratchTappy");
        String versionRelease = Build.VERSION.RELEASE;
        TextView textView = findViewById(R.id.textView17);
        textView.setText("Your device is running Android " + versionRelease);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH){
            // Do something for lollipop and above versions
            TextView textViewI = findViewById(R.id.textView18);
            textView.setText("Your device is compatible with this app");
        } else{
            // do something for phones running an SDK before lollipop
            TextView textViewI = findViewById(R.id.textView18);
            textView.setText("Your device is incompatible with this app");
        }
        TextView jpb = findViewById(R.id.textView5);
        jpb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), jpbInfo.class);
                startActivity(intent);
            }
        });
    }
}