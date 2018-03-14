package sveikata.models;

import com.github.javafaker.Faker;

import java.util.Random;

public class Patient extends Person {

    private static Random random = new Random();
    private static String id = "3551210" + random.nextInt(9999);
    private String password;

    private static Faker FAKER = new Faker();

    public static Patient createPatient(){
        return new Patient(
                id,
                FAKER.firstName(),
                FAKER.lastName());

    }

    public Patient(String id, String firstName, String lastName) {
        super(firstName, lastName);
    }
    public String getId() {
        return id;    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
