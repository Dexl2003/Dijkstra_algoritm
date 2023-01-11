package com.example.dijkstra_algoritm.constructor;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/** Класс конструктор вершин графа **/
public class VerticesGraphConstructor {

    private int x;
    private int y;
    private int number;
    private int value;
    private int radius;

    private Paint BGcolor;


    public VerticesGraphConstructor() {}

    public VerticesGraphConstructor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public VerticesGraphConstructor(int number, int value, int radius, Paint BGcolor) {
        this.number = number;
        this.value = value;
        this.radius = radius;
        this.BGcolor = BGcolor;
    }

    public VerticesGraphConstructor(int x, int y, int number, int value, int radius, Paint BGcolor) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.value = value;
        this.radius = radius;
        this.BGcolor = BGcolor;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Paint getBGcolor() {
        return BGcolor;
    }

    public void setBGcolor(Paint BGcolor) {
        this.BGcolor = BGcolor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }



}
