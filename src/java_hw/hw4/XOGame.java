package java_hw.hw4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class XOGame {
    static int SIZE = 3;
    static int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;
    static int[][] ratingMap;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Select game type: 0 - (3x3), 1 - (5x5), or buy premium and create your size of map :)");
        int gameType = sc.nextInt();
        if (gameType == 1){
            SIZE = 5;
            DOTS_TO_WIN = 4;
        }

        initRatingMap();
        initMap();
        printMap();

        while (true) {
            refreshRatingMap();

            humanTurn();
            printMap();
            if(checkWin(DOT_X, DOTS_TO_WIN)){
                System.out.println("Вы победитель!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();
            if(checkWin(DOT_O, DOTS_TO_WIN)){
                System.out.println("Комьютер победил!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }


    static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static void initRatingMap(){
        ratingMap = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                ratingMap[i][j] = 0;
            }
        }
    }

    static void refreshRatingMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (ratingMap[i][j] != -1) {
                    ratingMap[i][j] = 0;
                }
            }
        }
    }

    static void useCellWithMaxRating(char c){
        int y = 0;
        int x = 0;
        int maxRating = -1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (ratingMap[i][j] > maxRating){
                    maxRating = ratingMap[i][j];
                    y = i;
                    x = j;
                }
            }
        }
        ratingMap[y][x] = -1;
        map[y][x] = c;
    }

    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Input coord X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x) || !isCellEmpty(y, x));

        ratingMap[y][x] = -1;
        map[y][x] = DOT_X;
    }

    static void aiTurn() {
        boolean findCellForWin = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (ratingMap[i][j] != -1){
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O, DOTS_TO_WIN)){
                        findCellForWin = true;
                        break;
                    }
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X, DOTS_TO_WIN)){
                        ratingMap[i][j] = 50;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }

            if (findCellForWin){
                break;
            }
        }

        if (!findCellForWin){
            useCellWithMaxRating(DOT_O);
        }
    }


    static boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < SIZE && y < SIZE;
    }

    static boolean isCellEmpty(int y, int x) {
        return map[y][x] == DOT_EMPTY;
    }

    static boolean isCellEqualChar(int y, int x, char c) {
        if (isCellValid(y, x))
            return map[y][x] == c;

        return false;
    }

    static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(char c, int DOTS_TO_WIN) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkCellForCombo(i, j, DOTS_TO_WIN, c)){
                    return true;
                }
            }
        }

        return false;
    }

    static boolean checkCellForCombo(int y, int x, int DOTS_TO_WIN, char c){
        if (map[y][x] != c){
            return false;
        }

        boolean horizontal = true;
        boolean vertical = true;
        boolean diagonal = true;
        boolean reversDiagonal = true;

        for (int i = 0; i < DOTS_TO_WIN; i++) {             //проверка в цикле каждой комбинации. если хоть одна прерывается, дальше ее уже не проверяем
            if (horizontal){
                if (!isCellEqualChar(y, x + i, c)){
                    horizontal = false;
                }
            }

            if (vertical){
                if (!isCellEqualChar(y + i, x, c)){
                    vertical = false;
                }
            }

            if (diagonal){
                if (!isCellEqualChar(y + i, x + i, c)){
                    diagonal = false;
                }
            }

            if (reversDiagonal){
                if (!isCellEqualChar(y - i, x + i, c)){
                    reversDiagonal = false;
                }
            }
        }

        return horizontal || vertical || diagonal || reversDiagonal;
    }
}
