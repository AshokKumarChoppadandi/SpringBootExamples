package com.java.spring.basics.coupled.loosely.withannotations;

import com.java.spring.basics.sort.Sort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Primary
/**
 * @Primary Annotation is used because there are two sort algorithms of same type Sort
 *      1. BubbleSortBean
 *      2. QuickSortBean
 */
public class QuickSortBean implements Sort {

    @Override
    public int[] sort(int[] numbers) {
        sort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    private void sort(int[] numbers, int lowerBoundary, int higherBoundary) {
        if(lowerBoundary < higherBoundary + 1) {
            int p = partition(numbers, lowerBoundary, higherBoundary);
            sort(numbers, lowerBoundary, p - 1);
            sort(numbers, p + 1, higherBoundary);
        }
    }

    private void swap(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    private int getPivot(int lower, int higher) {
        Random random = new Random();
        return random.nextInt((higher - lower) + 1) + lower;
    }

    private int partition(int[] numbers, int lowerBoundary, int higherBoundary) {
        swap(numbers, lowerBoundary, getPivot(lowerBoundary, higherBoundary));
        int boundary = lowerBoundary + 1;

        for (int i = boundary; i <= higherBoundary; i++) {
            if(numbers[i] < numbers[lowerBoundary]) {
                swap(numbers, i, boundary++);
            }
        }

        swap(numbers, lowerBoundary, boundary - 1);
        return boundary - 1;
    }
}