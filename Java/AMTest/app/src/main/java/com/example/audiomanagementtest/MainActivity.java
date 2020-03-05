package com.example.audiomanagementtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mode;
    Button ring;
    Button vibrate;
    Button silent;

    private AudioManager mAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mode = findViewById(R.id.modeBtn);
        ring = findViewById(R.id.ringRtn);
        vibrate = findViewById(R.id.vibrateBtn);
        silent = findViewById(R.id.silentBtn);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mode = mAudioManager.getRingerMode();
                if (mode == AudioManager.RINGER_MODE_NORMAL) {
                    Toast.makeText(MainActivity.this, "Ringing Mode",
                            Toast.LENGTH_LONG).show();
                } else if (mode == AudioManager.RINGER_MODE_SILENT) {
                    Toast.makeText(MainActivity.this, "Silent Mode",
                            Toast.LENGTH_LONG).show();
                } else if (mode == AudioManager.RINGER_MODE_VIBRATE) {
                    Toast.makeText(MainActivity.this, "Vibrate Mode",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(MainActivity.this, "Now is Normal Mode",
                        Toast.LENGTH_LONG).show();
            }
        });

        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(MainActivity.this, "Now is Vibrate Mode",
                        Toast.LENGTH_LONG).show();
            }
        });

        silent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(MainActivity.this, "Now is Silent Mode",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
