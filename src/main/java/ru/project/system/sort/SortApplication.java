package ru.project.system.sort;

import java.time.LocalDateTime;
import java.util.Random;

public class SortApplication {
    private static Random random = new Random();

    static int NUMBER = 1000000;

    public static void main(String[] args) {
        int[] arr1 = new int[NUMBER];
        setUpArray(arr1);
        int[] arr2 = new int[NUMBER];
        setUpArray(arr2);

        long st1 = System.currentTimeMillis();
        bubbleSort(arr1);
        long st2 = System.currentTimeMillis();

        long st3 = System.currentTimeMillis();
        insertionSort(arr2);
        long st4 = System.currentTimeMillis();

        System.out.println("сортировка пузырьком заняла " + (st2 - st1) + " наносекунд");
        //printArray(arr1);
        System.out.println("сортировка вставками заняла " + (st4 - st3) + " наносекунд");
        //printArray(arr2);
    }

    static void bubbleSort(int[] array) {
        int n = array.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }

            }
        }

    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while ((j > -1) && (arr[j] > key)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    static void setUpArray(int[] array) {
        for (int i = 0; i < NUMBER; i++) {
            array[i] = random.nextInt(NUMBER);
        }
    }
}