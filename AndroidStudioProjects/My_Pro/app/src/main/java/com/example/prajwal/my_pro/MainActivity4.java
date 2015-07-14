package com.example.prajwal.my_pro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;
import java.net.URL;


public class MainActivity4 extends Activity {

    private VideoView myVideoView;

    private int position = 0;

    private ProgressDialog progressDialog;

    private MediaController mediaControls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        //set the media controller buttons

        if (mediaControls == null) {

            mediaControls = new MediaController(this);

        }
        //initialize the VideoView
        myVideoView = (VideoView) findViewById(R.id.video);

        // create a progress bar while the video file is loading
        progressDialog = new ProgressDialog(this);

        // set a title for the progress bar
        progressDialog.setTitle("Example video");

        // set a message for the progress bar
        progressDialog.setMessage("Loading...");

        //set the progress bar not cancelable on users' touch
        progressDialog.setCancelable(false);

        // show the progress bar
        progressDialog.show();

        try {

            //set the media controller in the VideoView

            myVideoView.setMediaController(mediaControls);

            //set the uri of the video to be played
            Uri uri =  Uri.parse( " https://www.youtube.com/watch?v=gQn-QHLqNvI" );
            myVideoView.setVideoURI(uri);
            //myVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kitkat));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        myVideoView.requestFocus();
        myVideoView.start();
        //we also set an setOnPreparedListener in order to know when the video file is ready for playback
        myVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {
                // close the progress bar and play the video

                progressDialog.dismiss();

                //if we have a position on savedInstanceState, the video playback should start from here

                myVideoView.seekTo(position);

                if (position == 0) {

                    myVideoView.start();

                } else {

                    //if we come from a resumed activity, video playback will be paused

                    myVideoView.pause();
                }
            }

        });
    }



}
