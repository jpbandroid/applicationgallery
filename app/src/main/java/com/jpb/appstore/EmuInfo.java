package com.jpb.appstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EmuInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emulatorinfo);
        this.setTitle("About AVD");
    }
}