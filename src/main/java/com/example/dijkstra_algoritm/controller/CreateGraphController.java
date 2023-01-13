package com.example.dijkstra_algoritm.controller;


import com.example.dijkstra_algoritm.constructor.EdgeGraphConstructor;

import com.example.dijkstra_algoritm.constructor.VerticesGraphConstructor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/** Компановка графа */
public class CreateGraphController {

    List<VerticesGraphConstructor> vertList;
    List<EdgeGraphConstructor> edgeList;

    public Group createGraph(int num, int from, int to){

        GraphCalculation graphCal = new GraphCalculation();
        DrawGraph drawGraph = new DrawGraph();

        vertList = graphCal.createVertForGraph(num);
        edgeList = graphCal.createEdgeForGraph(vertList,from,to);

        Group groups = new Group();

        for(EdgeGraphConstructor egc : edgeList){


            List<Node> nodes = drawGraph.drawEdge(egc);

            for (Node node : nodes
            ) {
                groups.getChildren().add(node);
            }
        }

        for (VerticesGraphConstructor vgc : vertList) {

            List<Node> nodes = drawGraph.drawVert(vgc);
            for (Node node : nodes
            ) {
                groups.getChildren().add(node);
            }

        }
        calc();

        return groups;

    }

    public void calc(){


        List<VerticesGraphConstructor> vertList = this.vertList;
        List<EdgeGraphConstructor> edgeList = this.edgeList;



        for (VerticesGraphConstructor vgc : vertList) {

            for (EdgeGraphConstructor egc : edgeList) {
                List<Integer> listInt = new ArrayList<>();

                if (egc.getVertA().getNumber() == 1 && egc.getVertA().getValue() == -1 ){
                    egc.getVertA().setValue(0);
                } else if(egc.getVertB().getNumber() == 1 && egc.getVertB().getValue() == -1){
                    egc.getVertB().setValue(0);
                }
                if(vgc.getNumber() == egc.getVertA().getNumber() ){
                    if (egc.getVertB().getValue() > egc.getMass() + egc.getVertA().getValue() || egc.getVertB().getValue() == -1) {
                        egc.getVertB().setValue(egc.getMass() + egc.getVertA().getValue());
                        if (egc.getVertB().getWay() == null) {
                            listInt.add(egc.getVertB().getNumber());
                            egc.getVertB().setWay(listInt);
                        } else egc.getVertB().getWay().add(egc.getVertA().getNumber());
                    }
                } else if (vgc.getNumber() == egc.getVertB().getNumber()){
                    if (egc.getVertA().getValue() > egc.getMass() + egc.getVertB().getValue() || egc.getVertA().getValue() == -1) {
                        egc.getVertA().setValue(egc.getMass() + egc.getVertB().getValue());
                        if (egc.getVertA().getWay() == null) {
                            listInt.add(egc.getVertB().getNumber());
                            egc.getVertA().setWay(listInt);
                        } else egc.getVertA().getWay().add(egc.getVertB().getNumber());
                    }
                }
            }
        }

        for (VerticesGraphConstructor vgc:vertList) {

            System.out.println(vgc.getValue() + " | " + vgc.getNumber() + " | " + vgc.getWay());
        }

    }

}
