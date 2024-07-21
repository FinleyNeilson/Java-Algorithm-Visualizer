package personal.finley.algorithmvisualizer.model;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort implements SortingAlgorithm{
    private final List<int[]> steps = new ArrayList<>();
    private final List<int[]> highlightedElements = new ArrayList<>();

    public SelectionSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
                // This is where each frame is added
                steps.add(data.clone());
                // Highlight current element and minIndex
                highlightedElements.add(new int[]{j, 1000});
            }
            // Swap the found minimum element with the first element
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
            // Add step after swap
            steps.add(data.clone());
            highlightedElements.add(new int[]{i, 1000});
        }
    }

    public List<int[]> getSteps() {
        return steps;
    }

    public List<int[]> getHighlightedElements() {
        return highlightedElements;
    }
}