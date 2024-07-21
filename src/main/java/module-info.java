module personal.finley.algorithmvisualizer {
    requires javafx.controls;
    requires javafx.fxml;

    opens personal.finley.algorithmvisualizer.controller to javafx.fxml;
    exports personal.finley.algorithmvisualizer;
    opens personal.finley.algorithmvisualizer to javafx.fxml;
    exports personal.finley.algorithmvisualizer.controller;
}