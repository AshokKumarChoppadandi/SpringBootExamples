package com.java.spring.basics.sort;

public class BubbleSort implements Sort{

    @Override
    public int[] sort(int[] numbers) {
        int length1 = numbers.length - 1;
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j < length1 - i; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                }
            }
        }

        return numbers;
    }

    private void swap(int[] numbers2, int index1, int index2) {
        int temp = numbers2[index1];
        numbers2[index1] = numbers2[index2];
        numbers2[index2] = temp;
    }
}
