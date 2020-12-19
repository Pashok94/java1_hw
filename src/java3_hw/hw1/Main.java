package java3_hw.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Character[] arr1 = new Character[]{'j', 'a', 'v', 'a'};
        Integer[] arr2 = new Integer[]{1, 2, 3, 4};
        arrayItemSwap(arr1, 0, 3);
        arrayItemSwap(arr2, 0, 3);

        for (Character ch : arr1) {
            System.out.print(ch + " ");
        }
        System.out.println();
        for (Integer i : arr2) {
            System.out.print(i + " ");
        }

        List<Character> list1 = arrTransform(arr1);
        List<Integer> list2 = arrTransform(arr2);
    }

    //1st task
    public static <T> void arrayItemSwap(T[] arr, int from, int to){
        if (from < 0 || from >= arr.length || to < 0 || to >= arr.length){
            throw new IllegalArgumentException();
        }
        T temp = arr[to];
        arr[to] = arr[from];
        arr[from] = temp;
    }

    //2nd task
    public static <T> List<T> arrTransform(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
}
