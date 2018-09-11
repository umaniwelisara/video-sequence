package com.umaniwelisara.videotest2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    VideoView videovw;
    Button stopbtn;
    MediaController mediac;
Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videovw = (VideoView) findViewById(R.id.videovw);
        stopbtn = (Button) findViewById(R.id.stopbtn);
        mediac = new MediaController(this);

        mediac.setVisibility(View.GONE);
       // mediac.setAnchorView(videovw);


        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playVideo();
                repeatVideo();

            }
        });
    }

    public void playVideo(){

        final String[] array = {"book", "angry"};
        for (int i = 0; i < array.length; i++) {

          //  videovw.setMediaController(new MediaController(MainActivity.this));

            videovw.setMediaController(mediac);
            mediac.setAnchorView(videovw);
           videovw.requestFocus();


            Log.i("message #########", "for loop start");
            if (array[i].equals("angry")) {//hand action
                // listA.add("angry.mp4");
                uri =Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.angry);
                videovw.setVideoURI(uri);
                videovw.start();
                //
                //    videovw.stopPlayback();
                //
              //  videovw.canPause();
              //  videovw.canSeekBackward();
              //  videovw.canSeekForward();
                //
                Log.i("message #########", "angry");

            }
            if (array[i].equals("book")) {//book action
                //  listA.add("book.mp4");
                uri=Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.book);
                videovw.setVideoURI(uri);
                videovw.start();

                //
                //  videovw.stopPlayback();
                //
               // videovw.canPause();
               // videovw.canSeekBackward();
              //  videovw.canSeekForward();
                //
                Log.i("message #########", "book");
            }
            //  else {
            //     Log.i("message #########", "error");
            // }
            Log.i("message #########", "for loop end");
        }

    }

    public void repeatVideo(){
        videovw.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(false);
            }
        });
    }
}



