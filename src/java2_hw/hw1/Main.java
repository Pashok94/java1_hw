package java2_hw.hw1;

import java2_hw.hw1.blockage.Barrier;
import java2_hw.hw1.blockage.Course;
import java2_hw.hw1.blockage.RunDistance;
import java2_hw.hw1.participant.Cat;
import java2_hw.hw1.participant.Competitors;
import java2_hw.hw1.participant.Human;
import java2_hw.hw1.participant.Robot;

public class Main {
    public static void main(String[] args) {
        Competitors[] team = new Competitors[]{new Cat("Васька", 1000, 3),
                new Human("Макс", 5000, 6),
                new Robot("Т1000", 10000, 20)};
        Course[] course = new Course[]{new Barrier(3),
                new RunDistance(800),
                new Barrier(5),
                new RunDistance(7000),
                new Barrier(18),
                new RunDistance(15000)};

        for (Course c : course) {
            for (Competitors competitor : team) {
                if (competitor.onDistance()){
                    competitor.startAction(c);
                }
            }
        }
    }
}
