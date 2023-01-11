module com.example.dijkstra_algoritm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.dijkstra_algoritm to javafx.fxml;
    exports com.example.dijkstra_algoritm;
    exports com.example.dijkstra_algoritm.constructor;
    opens com.example.dijkstra_algoritm.constructor to javafx.fxml;
    exports com.example.dijkstra_algoritm.controller;
    opens com.example.dijkstra_algoritm.controller to javafx.fxml;
}