package java_hw.hw6;

public class Animal {
    private static int countOfAnimal = 0;
    private final int limitRun;
    private final int limitSwim;
    private final String name;

    public Animal(int limitRun, int limitSwim, String name) {
        countOfAnimal++;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        this.name = name;
    }

    public void run(int distance){
        if (distance <= limitRun){
            System.out.printf("%s run %d meters\n", name, distance);
        }else
            System.out.printf("%s can`t run %d meters\n", name, distance);
    }

    public void swim(int distance){
        if (distance <= limitSwim){
            System.out.printf("%s swim %d meters\n", name, distance);
        }else
            System.out.printf("%s can`t swim %d meters\n", name, distance);
    }

    public static int getCountOfAnimal() {
        return countOfAnimal;
    }
}
