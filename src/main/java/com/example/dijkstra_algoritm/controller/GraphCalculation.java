package com.example.dijkstra_algoritm.controller;

import com.example.dijkstra_algoritm.constructor.EdgeGraphConstructor;
import com.example.dijkstra_algoritm.constructor.VerticesGraphConstructor;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GraphCalculation {



    public List<VerticesGraphConstructor> createVertForGraph(int quantityVert){
        List<VerticesGraphConstructor> listVert = new ArrayList<>();
        int [][] coord = generateRandomCoordForVert(quantityVert);
        for (int i = 0; i < quantityVert ; i++){
            listVert.add(new VerticesGraphConstructor(coord[i][0],coord[i][1],i+1,-1,20, Color.WHITE));
        }
        return listVert;
    }

    private int[][] generateRandomCoordForVert(int quantityVert){

        int[][] coord = new int[quantityVert][2];
        for(int i = 0; i < quantityVert; i++){
            coord[i][0] = ThreadLocalRandom.current().nextInt(30, 470);
            coord[i][1] = ThreadLocalRandom.current().nextInt(30, 470);
        }

        return coord;

    }

    public List<EdgeGraphConstructor> createEdgeForGraph(List<VerticesGraphConstructor> listVert, int from, int to){
        List<EdgeGraphConstructor> listEdge = new ArrayList<>();

        for(int i = 0; i < listVert.size();i++){

            for(int j = i - 1; j >= 0;j--) {
                if (j != i) {
                    int mass = ThreadLocalRandom.current().nextInt(from, to);
                    listEdge.add(new EdgeGraphConstructor(listVert.get(i), listVert.get(j), mass));
                }
            }
        }
        return listEdge;
    }



}
