package sveikata.models;

import com.github.javafaker.Faker;

public class Person {

    private static final Faker FAKER = new Faker();
    public static Person createPerson(){
        return new Person(FAKER.firstName(), FAKER.lastName());
    }

    private String firstName;
    private String lastName;

    public Person(String name, String lastName) {
        this.firstName = name;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
