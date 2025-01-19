package Sorting;

import java.util.Arrays;
import java.util.Collections;

public class basicSorting {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // time Complexity --> (O(n^2))
    public static void bubbleSort(int arr[]) {

        for (int turn = 0; turn < arr.length - 1; turn++) {
            int swap = 0;
            boolean Swapping = false; // optimised bubble sort
            for (int j = 0; j < arr.length - 1 - turn; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    Swapping = true;
                    swap++;
                }
            }

            if (Swapping == false) {
                break;
            }

            System.out.println("Swapping at turn " + turn + " = " + swap);
        }
        System.out.println();

    }

    public static void selectionSort(int arr[]) {
        // Time Complexity--> O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            int swap = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j; 
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
            swap++;

            System.out.println("Swapping at turn " + i + " = " + swap);
        }

    }

    // Time Complexity--> O(n^2)
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            // finding out the correct position to insert
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            arr[prev + 1] = curr;

        }
    }

    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {

            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;

            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 1, 1, 3, 2, 6, 4, 3, 7 };
        // insertionSort(arr);

        // Arrays.sort(arr , 0 , 3);

        // printArray(arr);

        // Arrays.sort(arr , Collections.reverseOrder());
        // printArray(arr);

        countingSort(arr);
        printArray(arr);

    }
}
