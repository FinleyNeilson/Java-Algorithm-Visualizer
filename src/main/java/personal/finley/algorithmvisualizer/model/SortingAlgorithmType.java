package personal.finley.algorithmvisualizer.model;

import java.util.function.Function;

public enum SortingAlgorithmType {
    BUBBLE_SORT(BubbleSort::new),
    SELECTION_SORT(SelectionSort::new);

    private final Function<int[], SortingAlgorithm> factoryMethod;

    SortingAlgorithmType(Function<int[], SortingAlgorithm> factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public SortingAlgorithm createAlgorithm(int[] data) {
        return factoryMethod.apply(data);
    }
}
