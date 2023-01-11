package com.example.dijkstra_algoritm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FirstWindowView.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, 600, 700);


        root.getChildren().add(fxmlLoader.load());


        stage.setResizable(false);
        stage.setTitle("Алгоритм Дейкстры");
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch();
    }
}