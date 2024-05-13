package com.example.androidprojectcollection;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Match3Exercise extends AppCompatActivity {

    private GridView gridView;
    private Button restartButton;
    private GameAdapter gameAdapter;
    private TextView scoreTextView;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restartButton = findViewById(R.id.restart_button);
        scoreTextView = findViewById(R.id.score_text_view);

        gameAdapter = new GameAdapter(this, this);
        gridView.setNumColumns(5);
        gridView.setAdapter(gameAdapter);

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameAdapter.restartGame();
                score = 0;
                updateScore(score);
                Toast.makeText(Match3Exercise.this, "Game restarted", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void updateScore(int newScore) {
        score = newScore;
        scoreTextView.setText("Score: " + score);
    }
}
