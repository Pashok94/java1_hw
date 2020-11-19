package java2_hw.hw2;

public class Main {
    public static void main(String[] args) {
        Object[][] arr1 = new Object[3][4];
        Object[][] arr2 = {{1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, "d", 4},
            {1, 2, 3, 4}};

//        System.out.println(sumArray(arr1));
        System.out.println(sumArray(arr2));
    }

    public static int sumArray (Object[][] arr){
        if (arr.length != 4)
            throw new MyArraySizeException();
        for (Object[] objArr : arr) {
            if (objArr.length != 4)
                throw new MyArraySizeException();
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += (Integer) arr[i][j];
                }catch (Exception e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }
}
