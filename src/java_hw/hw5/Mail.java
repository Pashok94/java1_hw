package java_hw.hw5;

public class Mail {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Vasin Vasya", "Clerk", "vasvas@mailbox.com", "892412312", 40000, 50);
        persArray[2] = new Person("Mishin Misha", "Developer", "misha@mailbox.com", "792312312", 10000, 20);
        persArray[3] = new Person("Petrov Petr", "Car driver", "petpet@mailbox.com", "892312312", 100000, 40);
        persArray[4] = new Person("Maksimov Maksim", "Security", "maksimax@mailbox.com", "8923542312", 35000, 70);

        for (Person person : persArray) {
            if (person.getAge() >= 40)
                person.info();
        }
    }
}
