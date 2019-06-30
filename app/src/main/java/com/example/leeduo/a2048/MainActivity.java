package com.example.leeduo.a2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.myFrame);
        game = new Game(this);
        game.setCurrentState(new PlayState(game));
        game.initGame();
        game.setOnTouchListener(new GameHandler());
        frameLayout.addView(game);

    }
}
