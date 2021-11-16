package com.example.practice_1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.practice_1.R;

public class ResultActivity extends AppCompatActivity {

    Button _btnRestart;
    TextView _txtGameResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        _txtGameResult = findViewById(R.id.txtGameResult);
        Intent intent = getIntent();
        _txtGameResult.setText(intent.getStringExtra("result"));

        _btnRestart = findViewById(R.id.btnRestart);
        _btnRestart.setOnClickListener(view ->
                startActivity(new Intent(ResultActivity.this, GameActivity.class)));
    }
}