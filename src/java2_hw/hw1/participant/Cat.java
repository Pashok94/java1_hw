package java2_hw.hw1.participant;

import java2_hw.hw1.blockage.Barrier;
import java2_hw.hw1.blockage.Course;
import java2_hw.hw1.blockage.RunDistance;

public class Cat implements Competitors {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private boolean isOnDistance = true;

    public Cat(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void startAction(Course c) {
        if (c instanceof Barrier){
            jump(((Barrier) c).height);
        }
        else if (c instanceof RunDistance){
            run(((RunDistance) c).distance);
        }
    }

    @Override
    public boolean onDistance() {
        return isOnDistance;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance){
            System.out.println("Кот " + name + " успешно пробежал " + distance + " метров");
        }
        else {
            System.out.println("Кот " + name + " не смог пробежать " + distance + " метров и сошел с дистанции");
            isOnDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight){
            System.out.println("Кот " + name + " успешно прыгнул на " + height + " метров");
        }
        else {
            System.out.println("Кот " + name + " не смог прыгнуть на " + height + " метров и сошел с дистанции");
            isOnDistance = false;
        }
    }
}
