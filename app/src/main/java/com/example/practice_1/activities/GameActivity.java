package com.example.practice_1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.practice_1.R;
import com.example.practice_1.gameEntities.Cell;
import com.example.practice_1.gameEntities.GameManager;

public class GameActivity extends AppCompatActivity {

    TableLayout _tlGameField;
    Button _btnReset;
    GameManager _game;
    private Button[][] buttons = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        _game = new GameManager();
        _tlGameField = findViewById(R.id.tlField);
        _btnReset = findViewById(R.id.btnReset);
        _btnReset.setOnClickListener(view ->
                startActivity(new Intent(GameActivity.this, GameActivity.class)));
        createCellsOnField();
    }

    private void createCellsOnField() {
        Cell[][] field = _game.getField();

        //заполняем программно таблицу, потому что в xml очень много писатб
        for (int i = 0; i < field.length; i++) {
            TableRow row = new TableRow(this);

            for (int j = 0; j < field[i].length; j++) {

                Button button = new Button(this);
                button.setBackgroundColor(Color.CYAN);
                button.setWidth(100);
                button.setHeight(100);
                button.setEnabled(true);
                int finalI = i;
                int finalJ = j;
                button.setOnClickListener(view -> makeTurn(finalI, finalJ));
                buttons[i][j] = button;

                row.addView(button, new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
            }
            _tlGameField.addView(row, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    private void makeTurn(int x, int y) {
        String text = _game.switchTurn(x, y);
        buttons[x][y].setText(text);
        buttons[x][y].setEnabled(false);

        if (_game.haveWinner()) {
            String winner;
            switch (_game.getWinner())
            {
                case "X":
                    winner = "Победил игрок \"X\"!";
                    break;
                case "O":
                    winner = "Победил игрок \"O\"!";
                    break;
                default:
                    winner = "Ничья!";
            }

            Intent intent = new Intent(GameActivity.this, ResultActivity.class);
            intent.putExtra("result", winner);
            startActivity(intent);
        }
    }
}