package com.jpb.appstore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SAIInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saiinfo);
        this.setTitle("SAI");
        String versionRelease = Build.VERSION.RELEASE;
        TextView textView = findViewById(R.id.textView17);
        textView.setText("Your device is running Android " + versionRelease);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            // Do something for lollipop and above versions
            TextView textViewI = findViewById(R.id.textView18);
            textViewI.setText("Your device is compatible with this app");
        } else{
            // do something for phones running an SDK before lollipop
            TextView textViewI = findViewById(R.id.textView18);
            textViewI.setText("Your device is incompatible with this app");
        }
        TextView jpb = findViewById(R.id.textView5);
        jpb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), OtherDevInfo.class);
                startActivity(intent);
            }
        });
        Button down = findViewById(R.id.button2);
        down.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DownloadManager downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://occoam.com/jpb/wp-content/uploads/saiapk.apk");

                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setTitle("SAI (Split APKs Installer)");
                request.setDescription("Downloading");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "SAI.apk");
                downloadmanager.enqueue(request);
            };
        });
    }
}