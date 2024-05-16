package com.example.myapplication7;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService2 extends Service {
    private static final String TAG = "MusicService";
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();

        // Инициализация медиаплеера
        mediaPlayer = MediaPlayer.create(this, R.raw.zvonok2);
        mediaPlayer.setLooping(true); // Зацикливание воспроизведения
        mediaPlayer.setVolume(100, 100);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                Log.d(TAG, "Музыка начала играть");
            }
            throw new RuntimeException(e);
        }
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            Log.d(TAG, "Музыка остановлена и ресурсы освобождены");
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null; // Для сервисов без привязки возвращаем null
    }
}