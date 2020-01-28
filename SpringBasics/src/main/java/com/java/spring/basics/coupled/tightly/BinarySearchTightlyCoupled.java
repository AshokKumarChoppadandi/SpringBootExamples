package com.java.spring.basics.coupled.tightly;

import com.java.spring.basics.search.BinarySearch;
import com.java.spring.basics.sort.BubbleSort;
import com.java.spring.basics.sort.QuickSort;

import java.util.Arrays;
import java.util.Date;

public class BinarySearchTightlyCoupled {

    /**
     * Input to a Simple Search is an ARRAY & the ELEMENT to search
     *
     * Steps involved in this Simple Search are :
     * 1. SORTING THE GIVEN ARRAY / LIST
     * 2. SEARCHING THE GIVEN ELEMENT
     * 3. RETURN THE INDEX OF THE ELEMENT IF FOUND.
     */

    public int search(int[] numbers, int numberForSearch) {

        /**
         * Implementing the Sorting
         *         1. Using the array elements using Bubble Sort
         */
        BubbleSort bubbleSort = new BubbleSort();
        int[] sortedNumbers = bubbleSort.sort(numbers);

        /**
         * 2. Using the array elements using Quick Sort
         */
        //QuickSort quickSort = new QuickSort();
        //int[] sortedNumbers2 = quickSort.sort(numbers);

        // Searching the Element using Binary Search
        BinarySearch binarySearch = new BinarySearch();
        return binarySearch.search(sortedNumbers, numberForSearch);
    }
}
