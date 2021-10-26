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
        Utils.printArray(arr);
        System.out.println("Start:"+start);
        System.out.println("End:"+end);

        if (end - start > 1) {             System.out.println("If End ("+end + ")- Start ("+start+") >1, then:");

            int middle = (start + end) / 2;             System.out.println("Middle:"+middle+"="+start+"-"+end+"/2");

                                        System.out.println("Sort LEFT-HAND-SIDE SIDE OF THE ARRAY!");
            sort(arr, start, middle);
            
                                        System.out.println("Sort right-hand-side OF THE ARRAY!");
            sort(arr, middle, end);

                                        System.out.println("merge both sides OF THE ARRAY!");
            merge(arr, start, middle, end);
        }
    }

    private static void merge(int[] arr, int start, int middle, int end) {         System.out.println("Start="+start+"; Middle="+middle+"; End="+end);
        
        int[] leftSide = new int[middle - start]; System.out.println("leftSide=");
        
        Utils.printArray(leftSide); System.out.println("= Middle="+middle+"- End="+end);
        int[] rightSide = new int[end - middle];
        System.out.println("rightSide=");
        //System.out.println(Arrays.toString(rightSide));
        Utils.printArray(rightSide);
        System.out.println("= End="+end+"- Middle="+middle);

        //System.out.println("For i = 0; i < "+leftSide.lenght+"; i++");
        for (int i = 0; i < leftSide.length; i++) {
            System.out.println("i = "+i);
            System.out.println("leftSide.length "+leftSide.length);
            
            leftSide[i] = arr[start + i];
            
            System.out.println("i = "+i);
        }

        for (int i = 0; i < rightSide.length; i++) {
            rightSide[i] = arr[middle + i];
        }

        int topLeft = 0;
        int topRight = 0;

        for (int i = start; i < end ; i++) {
            System.out.println("i:"+i);
                System.out.println("Array[i]:"+arr[i]+", Length:"+leftSide.length+
                                    ", leftSide:"+leftSide+
                                    ", topLeft:"+topLeft);

            if (topLeft >= leftSide.length) {
                arr[i] = rightSide[topRight];
                topRight++;
                System.out.println("i:"+i+", Array[i]: "+arr[i]+", Length:"+rightSide.length+
                ", leftSide:"+leftSide+
                ", topLeft:"+topLeft);
        
            }
            else if (topRight >= rightSide.length) {
                arr[i] = leftSide[topLeft];
                topLeft++;
                System.out.println("i:"+i);
                System.out.println("Array[i]:"+arr[i]+", Length:"+leftSide.length+
                                    ", leftSide:"+leftSide+
                                    ", topLeft:"+topLeft);
            }
            else if (leftSide[topLeft] < rightSide[topRight]) {
                arr[i] = leftSide[topLeft];
                topLeft++;
                System.out.println("i:"+i);
                System.out.println("Array[i]:"+arr[i]);
                System.out.println(", Length:"+leftSide.length);
                System.out.println(", leftSide:"+leftSide);
                System.out.println(", topLeft:"+topLeft);
            } else  {
                arr[i] = rightSide[topRight];
                topRight++;
                System.out.println("i:"+i);
                System.out.println("Array[i]:"+arr[i]);
                System.out.println(", Length:"+leftSide.length);
                System.out.println(", leftSide:"+leftSide);
                System.out.println(", topLeft:"+topLeft);
            }
        }

    }
}
