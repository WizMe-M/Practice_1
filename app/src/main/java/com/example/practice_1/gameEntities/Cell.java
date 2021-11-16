package com.example.practice_1.gameEntities;

public class Cell {
    private Marker _marker = null;
    public Marker getMarker(){ return _marker; }
    public void setMarker(Marker marker){
        _marker = marker;
    }
}
