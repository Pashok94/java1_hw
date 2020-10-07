package java_hw.hw5;

public class Person {
    private String name;
    private String function;
    private String email;
    private String phoneNumb;
    private int salary;
    private int age;

    public Person(String name, String function, String email, String phoneNumb, int salary, int age) {
        this.name = name;
        this.function = function;
        this.email = email;
        this.phoneNumb = phoneNumb;
        this.salary = salary;
        this.age = age;
    }

    public void info(){
        System.out.printf("Сотрудник %s имеет должность %s. Его контакты: email: %s, телефон: %s, имеет оклад: %d, возраст: %d \n",
                name, function, email, phoneNumb, salary, age);
    }

    public int getAge() {
        return age;
    }
}
