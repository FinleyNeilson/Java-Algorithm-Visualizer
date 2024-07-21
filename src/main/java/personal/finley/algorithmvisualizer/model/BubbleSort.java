package personal.finley.algorithmvisualizer.model;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements SortingAlgorithm{
    private final List<int[]> steps = new ArrayList<>();
    private final List<int[]> highlightedElements = new ArrayList<>();

    public BubbleSort(int[] data) {
        int n = data.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (data[i] < data[i - 1]) {
                    int temp = data[i];
                    data[i] = data[i - 1];
                    data[i - 1] = temp;
                    swapped = true;
                }
                // This is where each frame is added
                steps.add(data.clone());
                // Include what i we are currently changing and, n, how much has already been sorted
                highlightedElements.add(new int[]{i, n});
            }
            n = n - 1;
        } while (swapped); // Continue while swaps are occurring
    }

    public List<int[]> getSteps() {
        return steps;
    }

    public List<int[]> getHighlightedElements() {
        return highlightedElements;
    }
}