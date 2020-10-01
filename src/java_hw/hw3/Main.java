package java_hw.hw3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        firstGame();
        secondGame();
    }

    //task1
    public static void firstGame() {
        int countOfTries = 3;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int hiddenNumb = random.nextInt(9);
        System.out.println("Добро пожаловать в игру, постарайтесь угадать число от 0 до 9 за 3 попытки.");
        int inputNumb;

        for (int i = 0; i < countOfTries; i++) {
            System.out.println("Введите число:");

            while (true) {
                try {
                    inputNumb = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Некорректное значение. Введите еще раз");
                    scanner.next();
                }
            }

            if (inputNumb == hiddenNumb) {
                System.out.println("Ура! Вы победили!");
                break;
            } else {
                if (inputNumb > hiddenNumb) {
                    System.out.print("Ваше число больше загаданного. ");
                } else {
                    System.out.print("Ваше число меньше загаданного. ");
                }

                if (countOfTries - i - 1 == 0) {
                    System.out.println("Игра окончена");
                } else {
                    System.out.println("Осталось попыток: " + (countOfTries - i - 1));
                }
            }
        }

        while (true) {
            try {
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int userAnswer;
                userAnswer = scanner.nextInt();
                if (userAnswer == 1) {
                    firstGame();
                    return;
                } else if (userAnswer == 0) {
                    return;
                } else {
                    System.out.println("Некорректное значение. Введите еще раз");
                }
            } catch (Exception e) {
                System.out.println("Некорректное значение. Введите еще раз");
                scanner.next();
            }
        }
    }

    //task2
    public static void secondGame(){
        String[] arr = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String hiddenWord = arr[new Random().nextInt(arr.length)];
        String userAnswer;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Мы загадали слово, попробуйте угадать?");

        while (true){
            System.out.println("Введите ваше слово: ");
            userAnswer = scanner.nextLine().toLowerCase().trim();
            if (isWordsEquals(hiddenWord, userAnswer)){
                return;
            }
        }
    }

    public static boolean isWordsEquals(String hiddenWord, String userAnswer){
        int minSize = Math.min(hiddenWord.length(), userAnswer.length());
        if (hiddenWord.equals(userAnswer)) {
            System.out.println("Поздравляем! Вы победили!");
            return true;
        }else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < minSize; i++) {
                if (hiddenWord.charAt(i) == userAnswer.charAt(i)){
                    sb.append(hiddenWord.charAt(i));
                }
                else {
                    sb.append('#');
                }
            }

            while (sb.length() != 15){
                sb.append('#');
            }

            System.out.println("Ответ неверный. Мы покажем буквы, совпавшие с загаданным словом: ");
            System.out.println(sb);

            return false;
        }
    }
}
