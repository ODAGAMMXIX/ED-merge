package br.com.fatec.sort.merge;

import br.com.fatec.sort.utils.Utils;

public class MergeSort {


    public static void main(String[] args) {
        int arr[] = {64,25,12,22,11};
        System.out.println("Unsorted array:");
        Utils.printArray(arr);
        sort(arr, 0, arr.length);
        System.out.println("Sorted array:");
        Utils.printArray(arr);
    }

    private static void sort(int[] arr, int start, int end) {
        if (end - start > 1) {
            int middle = (start + end) / 2;
            sort(arr, start, middle);
            sort(arr, middle, end);
            merge(arr, start, middle, end);
        }
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        int[] leftSide = new int[middle - start];
        int[] rightSide = new int[end - middle];

        for (int i = 0; i < leftSide.length; i++) {
            leftSide[i] = arr[start + i];
        }

        for (int i = 0; i < rightSide.length; i++) {
            rightSide[i] = arr[middle + i];
        }

        int topLeft = 0;
        int topRight = 0;

        for (int i = start; i < end ; i++) {
            if (topLeft >= leftSide.length) {
                arr[i] = rightSide[topRight];
                topRight++;
            }
            else if (topRight >= rightSide.length) {
                arr[i] = leftSide[topLeft];
                topLeft++;
            }
            else if (leftSide[topLeft] < rightSide[topRight]) {
                arr[i] = leftSide[topLeft];
                topLeft++;
            } else  {
                arr[i] = rightSide[topRight];
                topRight++;
            }
        }

    }
}
