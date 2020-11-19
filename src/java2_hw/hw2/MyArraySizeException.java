package java2_hw.hw2;

public class MyArraySizeException extends IllegalArgumentException{
    public MyArraySizeException() {
        super("Размер массива не равен 4");
    }
}
