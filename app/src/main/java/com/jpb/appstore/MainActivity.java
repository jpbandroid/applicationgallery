package com.jpb.appstore;

import static android.provider.Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.info) {

            // Going from MainActivity to NotesEditorActivity
            Intent intent = new Intent(getApplicationContext(), DeviceInfo.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intentl = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                if (!Environment.isExternalStorageManager()) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.MANAGE_EXTERNAL_STORAGE}, 1);//permission request code is just an int
                }

                else {
                    }
            intentl = new Intent(ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, Uri.parse("package:" + BuildConfig.APPLICATION_ID));
            final int APP_STORAGE_ACCESS_REQUEST_CODE = 501; // Any value
            startActivityForResult(intentl, APP_STORAGE_ACCESS_REQUEST_CODE);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        CardView app2 = findViewById(R.id.st);
        app2.setOnClickListener((View.OnClickListener) view -> {
            Intent intent = new Intent(getApplicationContext(), STInfo.class);
            startActivity(intent);
        });
        Button update = findViewById(R.id.button);
        update.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), alldev.class);
                startActivity(intent);
            }
        });
    }
}