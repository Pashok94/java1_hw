package java_hw.hw6;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat(200, 0, "c-101");
        Dog dog1 = new Dog(500, 10, "d-101");

        cat1.run(150);
        cat1.run(350);
        cat1.swim(5);

        dog1.run(350);
        dog1.run(870);
        dog1.swim(5);
        dog1.swim(15);

        System.out.println(Animal.getCountOfAnimal());
        System.out.println(Cat.getCountOfCat());
        System.out.println(Dog.getCountOfDog());
    }
}
