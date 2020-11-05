package java2_hw.hw1.participant;

import java2_hw.hw1.blockage.Course;

public interface Competitors {
    void startAction(Course c);
    boolean onDistance();
    void run(int distance);
    void jump(int height);
}
