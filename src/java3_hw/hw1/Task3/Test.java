package java3_hw.hw1.Task3;

public class Test {
    public static void main(String[] args) {
        Box<Orange> box1 = new Box<>();
        Box<Apple> box2 = new Box<>();
        System.out.println("Test1: " + box1.compare(box2));

        box1.put(new Orange());
        box2.put(new Apple());
        box2.put(new Apple());
        box2.put(new Apple());
        System.out.println("Test2: " + box1.compare(box2));

        Box<Apple> box3 = new Box<>();
        box1.put(new Orange());
        box2.transfer(box3);
        System.out.println("Test3: " + box1.compare(box2));
        System.out.println("Test3: " + box1.compare(box3));
    }
}
