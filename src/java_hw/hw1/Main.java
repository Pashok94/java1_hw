package java_hw.hw1;

public class Main {

    //task1

    public static void main(String[] args) {

        //task2

        byte byteField = 127;
        short shortField = 6000;
        int intField = 60000;
        long longField = 6000000L;
        float floatField = 3.14f;
        double doubleField = 3.14159265358979323846264;
        boolean booleanField = true;
        char charField = 'A';
    }

    //task3

    static int getResult(int a, int b, int c, int d){
        return a * (b + (c / d));
    }

    //task4

    static boolean checkSum(int a, int b){
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //task5

    static void checkParity(int a){
        if (a < 0){
            System.out.println("odd");
        }
        else {
            System.out.println("even");
        }
    }

    //task6

    static boolean isOdd(int a){
        return a < 0;
    }

    //task7

    static void sayHi(String name){
        System.out.println("Привет, " + name);
    }

    //task8

    static void checkDate(int date){
        if (date % 4 == 0){
            if (date % 100 == 0){
                if (date % 400 == 0){
                    System.out.println(date + " год является високосным");
                }
                else {
                    System.out.println(date + " год не является високосным");
                }
            }
            else {
                System.out.println(date + " год является високосным");
            }
        }
        else {
            System.out.println(date + " год не является високосным");
        }
    }
}
