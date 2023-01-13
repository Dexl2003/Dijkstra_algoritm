package com.example.dijkstra_algoritm.controller;


import com.example.dijkstra_algoritm.controller.CreateGraphController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;


public class HelloController {

    @FXML
    private TextField numberOfVertices;

    @FXML
    private TextField weightGrafMax;

    @FXML
    private TextField weightGrafMin;

    @FXML
    private AnchorPane graphPanel;

    @FXML
    void onСalculateButtonClick(ActionEvent event){

        // Принимаемые значения: Максимальное значение диапазона весов, Минимальное значение диапазона весов, Количество вершин графа.
        var GrMin = Integer.valueOf(weightGrafMax.getText());
        var GrMax = Integer.valueOf(weightGrafMin.getText());
        var numOfVert = Integer.valueOf(numberOfVertices.getText());

        CreateGraphController cgc = new CreateGraphController();

        // Очистка панели графа.
        graphPanel.getChildren().clear();

        // Сознание нового графа
        Group root = new Group();
        root.getChildren().add(cgc.createGraph(numOfVert,GrMin,GrMax));

        graphPanel.getChildren().add(root);


    }


    public void onBgEdit(ActionEvent actionEvent) {

    }
}