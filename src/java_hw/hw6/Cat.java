package java_hw.hw6;

public class Cat extends Animal{
    private static int countOfCat = 0;

    public Cat(int limitRun, int limitSwim, String name) {
        super(limitRun, limitSwim, name);
        countOfCat++;
    }

    public static int getCountOfCat() {
        return countOfCat;
    }
}
