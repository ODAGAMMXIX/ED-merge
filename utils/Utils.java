package br.com.fatec.sort.utils;

public class Utils {
    public static void printArray(int arr[]){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ ",");
        }
        System.out.println("]");
    }
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
