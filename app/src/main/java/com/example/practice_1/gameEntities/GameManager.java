package com.example.practice_1.gameEntities;

import com.example.practice_1.R;

public class GameManager {
    private boolean isTurnX;
    private Marker _playerX;
    private Marker _playerO;
    private int _checkedCount;

    private Cell[][] _field;

    public Cell[][] getField() {
        return _field;
    }

    public GameManager() {
        isTurnX = true;
        _checkedCount = 0;
        _field = new Cell[3][3];
        _playerX = new Marker("X");
        _playerO = new Marker("O");

        for (int i = 0, length = _field.length; i < length; i++) {
            for (int j = 0, length2 = _field[i].length; j < length2; j++) {
                _field[i][j] = new Cell();
                _checkedCount++;
            }
        }
    }

    public String switchTurn(int x, int y) {
        String X = String.valueOf(R.string.X);
        String O = String.valueOf(R.string.O);

        Marker mark = isTurnX ? _playerX : _playerO;
        _field[x][y].setMarker(mark);
        isTurnX = !isTurnX;
        _checkedCount--;
        return mark.getName();
    }

    public boolean haveWinner() {
        Cell[] line = new Cell[3];
        for (int i = 0; i < _field.length; i++) {
            for (int j = 0; j < _field[i].length; j++) {
                line[j] = _field[i][j];
            }

            if (line[0].getMarker() != null && line[1].getMarker() != null && line[2].getMarker() != null &&
                    line[0].getMarker() == line[1].getMarker() && line[1].getMarker() == line[2].getMarker())
                return true;
        }

        for (int i = 0; i < _field.length; i++) {
            for (int j = 0; j < _field[i].length; j++) {
                line[j] = _field[j][i];
            }

            if (line[0].getMarker() != null && line[1].getMarker() != null && line[2].getMarker() != null &&
                    line[0].getMarker() == line[1].getMarker() && line[1].getMarker() == line[2].getMarker())
                return true;
        }

        for (int i = 0; i < _field.length; i++) {
            line[i] = _field[i][i];
        }
        if (line[0].getMarker() != null && line[1].getMarker() != null && line[2].getMarker() != null &&
                line[0].getMarker() == line[1].getMarker() && line[1].getMarker() == line[2].getMarker())
            return true;

        for (int i = 0; i < _field.length; i++) {
            int j = _field[i].length;
            line[i] = _field[i][j - i - 1];
        }
        if (line[0].getMarker() != null && line[1].getMarker() != null && line[2].getMarker() != null &&
                line[0].getMarker() == line[1].getMarker() && line[1].getMarker() == line[2].getMarker())
            return true;

        return _checkedCount == 0;
    }

    public String getWinner() {
        String result = null;
        Cell[] line = new Cell[3];
        for (int i = 0; i < _field.length; i++) {
            for (int j = 0; j < _field[i].length; j++) {
                line[j] = _field[i][j];
            }

            if (line[0].getMarker() != null && line[1].getMarker() != null && line[2].getMarker() != null &&
                    line[0].getMarker() == line[1].getMarker() && line[1].getMarker() == line[2].getMarker())
                result = line[0].getMarker().getName();
        }

        for (int i = 0; i < _field.length; i++) {
            for (int j = 0; j < _field[i].length; j++) {
                line[j] = _field[j][i];
            }

            if (line[0].getMarker() != null && line[1].getMarker() != null && line[2].getMarker() != null &&
                    line[0].getMarker() == line[1].getMarker() && line[1].getMarker() == line[2].getMarker())
                result = line[0].getMarker().getName();
        }

        for (int i = 0; i < _field.length; i++) {
            line[i] = _field[i][i];
        }
        if (line[0].getMarker() != null && line[1].getMarker() != null && line[2].getMarker() != null &&
                line[0].getMarker() == line[1].getMarker() && line[1].getMarker() == line[2].getMarker())
            result = line[0].getMarker().getName();

        for (int i = 0; i < _field.length; i++) {
            int j = _field[i].length;
            line[i] = _field[i][j - i - 1];
        }
        if (line[0].getMarker() != null && line[1].getMarker() != null && line[2].getMarker() != null &&
                line[0].getMarker() == line[1].getMarker() && line[1].getMarker() == line[2].getMarker())
            result = line[0].getMarker().getName();

        if (result != null && _checkedCount == 0)
            result = "draw";

        return result;
    }
}