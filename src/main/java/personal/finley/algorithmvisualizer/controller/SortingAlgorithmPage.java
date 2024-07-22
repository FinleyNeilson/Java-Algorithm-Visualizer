package personal.finley.algorithmvisualizer.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import personal.finley.algorithmvisualizer.model.SortingAlgorithm;
import personal.finley.algorithmvisualizer.model.SortingAlgorithmType;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SortingAlgorithmPage implements Initializable {
    @FXML
    private Button start;
    @FXML
    private Text algorithmName;
    @FXML
    private Text speedText;
    @FXML
    private Slider speedSlider;
    @FXML
    private Pane visualizationPane;

    private double paneWidth;
    private double paneHeight;
    private double rectWidth;
    private double scalar;

    private int[] initData;

    private Timeline timeline = new Timeline();
    private boolean running = false;
    private boolean sortingInitialized = false;

    private double animationSpeed = 3.0;

    private static String selectedAlgorithm;

    public static void setAlgorithmType(String s) {
        selectedAlgorithm = Objects.requireNonNullElse(s, "Bubble Sort");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Display algorithm name at the top of the program
        algorithmName.setText(selectedAlgorithm);

        // Initialize the pane width/height
        this.paneWidth = visualizationPane.getPrefWidth();
        this.paneHeight = visualizationPane.getPrefHeight();

        // Initialize some random data
        this.initData = new Random().ints(75, 0, 100 + 1).toArray();

        // Initialize rectangle size
        rectWidth = (paneWidth / initData.length) - 1;
        // Scale all heights in terms of the max item
        this.scalar = paneHeight / (Arrays.stream(initData).max().orElseThrow());

        // Draw the random data with nothing highlighted
        drawRectangles(initData, new int[]{-1, 1000});

        // Add the slider listener
        speedSlider.valueProperty().addListener((observableValue, number, t1) -> {
            animationSpeed = speedSlider.getValue();
            speedText.setText(String.format("%.1f", animationSpeed));
            timeline.setRate(animationSpeed / 10);
        });
    }

    private void drawRectangles(int[] data, int[] highlightedElement) {
        // Clear the pane
        visualizationPane.getChildren().clear();

        // Create empty rectangle array
        Rectangle[] rectangles = new Rectangle[data.length];

        for (int i = 0; i < data.length; i++) {
            // Work out rectangle height for current rectangle
            double rectHeight = data[i] * scalar;
            // Color rectangle based on highlighted element [0] is focus [1] is completed
            if (i == highlightedElement[0]) {
                rectangles[i] = new Rectangle(rectWidth, rectHeight, Color.RED);
            } else if ( i >= highlightedElement[1]) {
                rectangles[i] = new Rectangle(rectWidth, rectHeight, Color.GREEN);
            } else {
                rectangles[i] = new Rectangle(rectWidth, rectHeight, Color.CADETBLUE);
            }
            // Set position for rectangle
            rectangles[i].setX(i * (paneWidth / data.length));
            rectangles[i].setY(paneHeight - rectHeight);
            // Add rectangle to the pane
            visualizationPane.getChildren().add(rectangles[i]);
        }
    }

    private SortingAlgorithm getSortingAlgorithm() {
        // Set as Bubble sort by default
        SortingAlgorithmType algorithmType = SortingAlgorithmType.BUBBLE_SORT;
        // Reformat the string for the enum
        String formattedAlgorithmName = selectedAlgorithm.toUpperCase().replace(" ", "_");

        // Try to get the algorithm type from the algorithm name
        try {
            algorithmType = SortingAlgorithmType.valueOf(formattedAlgorithmName);
        } catch (IllegalArgumentException e) {
            System.out.println("Unknown algorithm: " + algorithmName);
        }

        // Create the algorithm
        return algorithmType.createAlgorithm(this.initData);
    }

    private void initSortingAnimation() {
        SortingAlgorithm algorithm = getSortingAlgorithm();

        List<int[]> steps = algorithm.getSteps();
        List<int[]> highlightedElements = algorithm.getHighlightedElements();
        
        AtomicInteger stepIndex = new AtomicInteger(0);
        this.timeline = new Timeline(new KeyFrame(Duration.millis(5), event -> { // This is different to setRate
            int index = stepIndex.getAndIncrement();
            if (index < steps.size() - 1) {
                drawRectangles(steps.get(index), highlightedElements.get(index));
            } else if (index < steps.size()) {
                // Makes the last frame fully green
                drawRectangles(steps.get(index), new int[]{-1,0});
            }
        }));
        timeline.setCycleCount(steps.size());
        timeline.setRate(animationSpeed / 10);
    }

    public void startButtonMethod() {
        if (running) {
            stopAnimation();
        } else { // Else not running
            if (!sortingInitialized){
                sortingInitialized = true;
                initSortingAnimation();
            }
            startAnimation();
        }
    }

    public void stopAnimation(){
        this.running = false;
        start.setText("Start");
        timeline.stop();
    }

    public void startAnimation(){
        this.running = true;
        start.setText("Stop");
        timeline.play();
    }

    public void backToMenu(ActionEvent event) throws IOException {
        SceneController.switchScene(event, "start-page.fxml");
    }

    public void reset(ActionEvent event) throws IOException {
        SceneController.switchScene(event, "sorting-algorithm-view.fxml");
    }
}
