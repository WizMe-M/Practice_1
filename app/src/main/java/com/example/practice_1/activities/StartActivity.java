package com.example.practice_1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice_1.R;

public class StartActivity extends AppCompatActivity {

    Button btnStartGame;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnStartGame = findViewById(R.id.btnStartGame);
        btnStartGame.setOnClickListener(view ->
                startActivity(new Intent(StartActivity.this, GameActivity.class)));

        btnExit = findViewById(R.id.btnExitGame);
        btnExit.setOnClickListener(view -> System.exit(0));
    }
}