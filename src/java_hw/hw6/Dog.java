package java_hw.hw6;

public class Dog extends Animal{
    private static int countOfDog = 0;

    public Dog(int limitRun, int limitSwim, String name) {
        super(limitRun, limitSwim, name);
        countOfDog++;
    }

    public static int getCountOfDog() {
        return countOfDog;
    }
}
