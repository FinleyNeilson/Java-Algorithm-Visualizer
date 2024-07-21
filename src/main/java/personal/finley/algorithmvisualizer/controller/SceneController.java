package personal.finley.algorithmvisualizer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import personal.finley.algorithmvisualizer.AlgorithmVisualizer;

import java.io.IOException;

public class SceneController {

    public static void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Scene scene = loadScene(fxmlFile);
        // Get the current stage from the ActionEvent
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public static Scene loadScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AlgorithmVisualizer.class.getResource(fxmlFile));
        return new Scene(fxmlLoader.load());
    }
}
