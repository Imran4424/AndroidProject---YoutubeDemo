package com.luminous.android.youtubedemo;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class YoutubePlayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public static String youtubeVideoId;
    private YouTubePlayerView youTubePlayerView;
    private final String YOUTUBE_API_KEY = "AIzaSyDz3OFdXblVTWnoihSnnBagF1WCZAw4Hkg";
    private YouTubePlayer globalYouTubePlayer;
    private Button backwardButton;
    private Button forwardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(YOUTUBE_API_KEY, this);
        youTubePlayerView.setClickable(true);


        hideSystemUI();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hideSystemUI();
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        youTubePlayer.setFullscreen(true);
        youTubePlayer.setShowFullscreenButton(false);
        youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);



        if (!wasRestored) {
            youTubePlayer.loadVideo(youtubeVideoId);

//            youTubePlayerView.requestChildFocus(backwardButton, forwardButton);
//            backwardButton.bringToFront();
//            forwardButton.bringToFront();
//            backwardButton.setVisibility(View.VISIBLE);
//            forwardButton.setVisibility(View.VISIBLE);
        }

//        youTubePlayerView.addView(backwardButton);
//        youTubePlayerView.addView(forwardButton);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int pointerId = event.getPointerId(0);
        int pointerIndex = event.findPointerIndex(pointerId);

        float x = event.getX(pointerIndex);
        float y = event.getY(pointerIndex);

        Log.d("X", Float.toString(x));
        Log.d("Y", Float.toString(y));

        return super.onTouchEvent(event);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        final int REQUEST_CODE = 1;

        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show();
        } else {
            String errorMessage = String.format("There was an error initializing the YouTubePlayer (%1$s)", youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    public void backward(View view) {
        globalYouTubePlayer.seekRelativeMillis(-10000);
    }

    public void forward(View view) {
        globalYouTubePlayer.seekRelativeMillis(10000);
    }

}
