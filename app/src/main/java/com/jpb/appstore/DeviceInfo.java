package com.jpb.appstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jpb.appstore.oss.license.OSSLicense;

public class DeviceInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);
        this.setTitle("About Device");
        String deviceName = android.os.Build.MODEL;
        String versionRelease = Build.VERSION.RELEASE;
        String manufacturer = Build.MANUFACTURER;
//to add to textview
        TextView textView = findViewById(R.id.textView28);
        textView.setText(deviceName);
        TextView vextView = findViewById(R.id.textView30);
        vextView.setText(versionRelease);
        TextView sextView = findViewById(R.id.textView32);
        sextView.setText(manufacturer);
        TextView textViewAVD  = findViewById(R.id.textView7);
        CardView update = findViewById(R.id.update);
        textViewAVD.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), EmuInfo.class);
                startActivity(intent);
            }
        });
        update.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), NewUpdaterActivity.class);
                startActivity(intent);
            }
        });
        TextView textViewOSS  = findViewById(R.id.textView33);
        textViewOSS.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), OSSLicense.class);
                startActivity(intent);
            }
        });
    }
}