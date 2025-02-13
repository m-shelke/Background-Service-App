package com.example.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MusicServic extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        mediaPlayer.setLooping(true);

        mediaPlayer.start();

        return START_STICKY;

       // return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        mediaPlayer.stop();
        super.onDestroy();
    }
}
