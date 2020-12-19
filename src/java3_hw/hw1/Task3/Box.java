package java3_hw.hw1.Task3;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public float getWeight(){
        float res = 0;
        for (T fruit : fruits) {
            res += fruit.weight;
        }
        return res;
    }

    public boolean compare(Box<? extends Fruit> otherBox){
        return this.getWeight() == otherBox.getWeight();
    }

    public void put(T fruit){
        fruits.add(fruit);
    }

    public void transfer(Box<T> otherBox){
        for (T fruit : fruits) {
            otherBox.put(fruit);
        }
        fruits = new ArrayList<>();
    }
}
