package com.jpb.appstore;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.jpb.appstore.databinding.ActivityUpdaterNewBinding;

import org.json.JSONException;
import org.json.JSONObject;

import p32929.updaterlib.AppUpdater;
import p32929.updaterlib.UpdateListener;
import p32929.updaterlib.UpdateModel;

public class NewUpdaterActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this;

        com.jpb.appstore.databinding.ActivityUpdaterNewBinding binding = ActivityUpdaterNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Tap, Tap, Tap!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button update = binding.button13;
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AppUpdater(NewUpdaterActivity.this, "https://occoam.com/jpb/wp-content/uploads/appggaljson.json", new UpdateListener() {
                    @Override
                    public void onJsonDataReceived(final UpdateModel updateModel, JSONObject jsonObject) {
                        if (AppUpdater.getCurrentVersionCode(NewUpdaterActivity.this) < updateModel.getVersionCode()) {
                            new MaterialAlertDialogBuilder(NewUpdaterActivity.this)
                                    .setTitle("Update available")
                                    .setCancelable(updateModel.isCancellable())
                                    .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            DownloadManager downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                            Uri uri = Uri.parse("https://occoam.com/jpb/wp-content/uploads/https://occoam.com/jpb/wp-content/uploads/ApplicationGallery.apk");

                                            DownloadManager.Request request = new DownloadManager.Request(uri);
                                            try {
                                                request.setTitle("ApplicationGallery " + jsonObject.getJSONObject("versionName"));
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                            request.setDescription("Downloading");
                                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "ApplicationGalleryUpdate.apk");
                                            downloadmanager.enqueue(request);
                                        }
                                    })
                                    .show();
                        }
                    }

                    @Override
                    public void onError(String error) {
                        // Do something

                    }
                }).execute();
            }
        });
    }
}