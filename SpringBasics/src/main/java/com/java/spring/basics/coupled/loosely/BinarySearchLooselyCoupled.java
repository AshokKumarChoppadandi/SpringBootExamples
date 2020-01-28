package com.java.spring.basics.coupled.loosely;

import com.java.spring.basics.search.BinarySearch;
import com.java.spring.basics.sort.Sort;

public class BinarySearchLooselyCoupled {

    private Sort sortAlgorithm;

    public BinarySearchLooselyCoupled(Sort sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int search(int[] numbers, int numberForSearch) {

        int[] sortedNumbers = sortAlgorithm.sort(numbers);

        // Searching the Element using Binary Search
        BinarySearch binarySearch = new BinarySearch();
        return binarySearch.search(sortedNumbers, numberForSearch);
    }
}
