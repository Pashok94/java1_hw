package java_hw.hw2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //task1
        int[] arr1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0){
                arr1[i] = 1;
            }
            else
                arr1[i] = 0;
        }

        //task2
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }

        //task3
        int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6)
                arr3[i] *=2;
        }

        //task4
        int[][] arr4 = new int[9][9];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (i == j || i + j == arr4.length - 1)
                    arr4[i][j] = 1;
            }
        }

        //task5
        int[] arr5 = {1, 2, 5, 667, -1, 45, 2000, -100500, 6};
        printMinAndMaxArrValue(arr5);
//        printMinAndMaxArrValueWithSort(arr5);

        //task6
        int[] arr6 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(arr6));

        //task7
        int[] arr7 = {1, 2, 3, 4, 5};
        displaceArrayValues(arr7, -7);
    }

    //for task5
    private static void printMinAndMaxArrValue(int[] arr){
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        System.out.println("min value is: " + min + ", max value is: " + max);
    }

    //еще вариант с сортировкой
    private static void printMinAndMaxArrValueWithSort(int[] arr){
        Arrays.sort(arr);
        System.out.println("min value is: " + arr[0] + ", max value is: " + arr[arr.length - 1]);
    }

    //for task6
    private static boolean checkBalance(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if (compareSumOfArrays(Arrays.copyOfRange(arr, 0, i), Arrays.copyOfRange(arr, i, arr.length)))
                return true;
        }
        return false;
    }

    private static boolean compareSumOfArrays(int[] part1, int[] part2){
        int sumOfPart1 = 0;
        int sumOfPart2 = 0;

        for (int j : part1) {
            sumOfPart1 += j;
        }

        for (int j : part2) {
            sumOfPart2 += j;
        }

        return sumOfPart1 == sumOfPart2;
    }

    //for task7
    private static int[] displaceArrayValues(int[] arr, int amountOfRotate){
        amountOfRotate %= arr.length;               //сократил лишние ротации
        System.out.println(amountOfRotate);
        if (amountOfRotate > 0){
            for (int i = 0; i < amountOfRotate; i++) {
                positiveRotate(arr);
            }
        }else if (amountOfRotate < 0){
            for (int i = 0; i > amountOfRotate; i--) {
                negativeRotate(arr);
            }
        }
        return arr;
    }

    private static void positiveRotate(int[] arr){
        int temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    private static void negativeRotate(int[] arr){
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }
}
