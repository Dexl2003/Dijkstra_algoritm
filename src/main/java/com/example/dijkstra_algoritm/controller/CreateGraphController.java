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
        for (VerticesGraphConstructor vgc:vertList) {

            System.out.println(vgc.getValue() + " | " + vgc.getNumber());
        }


        for (VerticesGraphConstructor verticesGraphConstructor : vertList) {

            for (int j = edgeList.size() - 1; j >= 0; j--) {

                if (verticesGraphConstructor.getNumber() == edgeList.get(j).getVertA().getNumber() && edgeList.get(j).getVertA().getBGcolor() != Color.RED && edgeList.get(j).getVertB().getBGcolor() != Color.RED) {
                    if (edgeList.get(j).getVertB().getValue() >= edgeList.get(j).getVertA().getValue() + edgeList.get(j).getMass()) {
                        edgeList.get(j).getVertB().setValue(edgeList.get(j).getVertA().getValue() + edgeList.get(j).getMass());
                        System.out.println(edgeList.get(j).getVertB().getValue() + " | " + edgeList.get(j).getVertB().getNumber() + " ---------<1");
                    } else if (edgeList.get(j).getVertB().getValue() == -1) {
                        edgeList.get(j).getVertB().setValue(edgeList.get(j).getMass());
                        System.out.println(edgeList.get(j).getVertB().getValue() + " | " + edgeList.get(j).getVertB().getNumber() + " ---------<11");
                    }
                } else if (verticesGraphConstructor.getNumber() == edgeList.get(j).getVertB().getNumber() && edgeList.get(j).getVertA().getBGcolor() != Color.RED && edgeList.get(j).getVertB().getBGcolor() != Color.RED) {
                    if (edgeList.get(j).getVertA().getValue() >= edgeList.get(j).getVertB().getValue() + edgeList.get(j).getMass()) {
                        edgeList.get(j).getVertA().setValue(edgeList.get(j).getVertB().getValue() + edgeList.get(j).getMass());
                        System.out.println(edgeList.get(j).getVertA().getValue() + " | " + edgeList.get(j).getVertA().getNumber() + " ---------<2");
                    } else if (edgeList.get(j).getVertA().getValue() == -1) {
                        edgeList.get(j).getVertA().setValue(edgeList.get(j).getMass());
                        System.out.println(edgeList.get(j).getVertA().getValue() + " | " + edgeList.get(j).getVertA().getNumber() + " ---------<21");
                    }
                }

            }
            verticesGraphConstructor.setBGcolor(Color.RED);
        }

        for (VerticesGraphConstructor vgc:vertList) {

            System.out.println(vgc.getValue() + " | " + vgc.getNumber());
        }

    }

}
