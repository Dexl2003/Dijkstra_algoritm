package com.example.dijkstra_algoritm.constructor;

/** Класс коструктор ребер графа. */
public class EdgeGraphConstructor {

    private VerticesGraphConstructor vertA;
    private VerticesGraphConstructor vertB;

    private int mass;


    public EdgeGraphConstructor(VerticesGraphConstructor _vertA, VerticesGraphConstructor _vertB, int mass) {
        this.vertA = _vertA;
        this.vertB = _vertB;
        this.mass = mass;
    }

    public EdgeGraphConstructor(VerticesGraphConstructor vertA, VerticesGraphConstructor vertB) {
        this.vertA = vertA;
        this.vertB = vertB;
    }

    public EdgeGraphConstructor() {
    }

    public VerticesGraphConstructor getVertA() {
        return vertA;
    }

    public void setVertA(VerticesGraphConstructor vertA) {
        this.vertA = vertA;
    }

    public VerticesGraphConstructor getVertB() {
        return vertB;
    }

    public void setVertB(VerticesGraphConstructor vertB) {
        this.vertB = vertB;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }




}
