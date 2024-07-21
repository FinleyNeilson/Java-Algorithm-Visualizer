package personal.finley.algorithmvisualizer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartPage implements Initializable {
    private final String[] options = {"Bubble Sort","Selection Sort"};
    @FXML
    private ChoiceBox<String> choiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(options);
    }

    public void start(ActionEvent event) throws IOException {
        SortingAlgorithmPage.setAlgorithmType(choiceBox.getValue());
        SceneController.switchScene(event, "sorting-algorithm-view.fxml");
    }
}