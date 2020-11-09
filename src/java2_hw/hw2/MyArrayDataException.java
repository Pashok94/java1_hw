package java2_hw.hw2;

public class MyArrayDataException extends ClassCastException{
    public MyArrayDataException(int iCoordinate, int jCoordinate) {
        super("Некорректное значение в ячейке: " + iCoordinate + " - " + jCoordinate);
    }
}
