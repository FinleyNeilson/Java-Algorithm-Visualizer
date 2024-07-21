package personal.finley.algorithmvisualizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import personal.finley.algorithmvisualizer.controller.SceneController;

import java.io.IOException;

public class AlgorithmVisualizer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = SceneController.loadScene("start-page.fxml");
        stage.setTitle("Algorithm Visualizer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
