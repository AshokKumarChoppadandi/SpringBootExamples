package com.java.spring.basics.search;

public class BinarySearch {

    private int foundIndex = -1;

    public int search(int[] numbers, int searchElement) {
        int lowerIndex = 0;
        int higherIndex = numbers.length - 1;
        return checkSearchElement(numbers, lowerIndex, higherIndex, searchElement);
    }

    private int getMiddleElement(int lowerIndex, int higherIndex) {
        return (lowerIndex + ( higherIndex )) / 2;
    }

    private int checkSearchElement(int[] numbers, int lowerIndex, int higherIndex, int searchElement) {
        int middleIndex = getMiddleElement(lowerIndex, higherIndex);
        if (numbers[middleIndex] == searchElement)
            foundIndex = middleIndex;
        else if (numbers[middleIndex] < searchElement)
            checkSearchElement(numbers, middleIndex + 1, higherIndex, searchElement);
        else
            checkSearchElement(numbers, lowerIndex, middleIndex - 1, searchElement);

        return foundIndex;
    }
}
