package sveikata.models;

import com.github.javafaker.Faker;

public class Pharmacist extends Person {
    private final String businessType;
    private final String companyName;
    private String username;
    private String password;

    private static Faker FAKER = new Faker();

    public static Pharmacist createPharmacist() {
        return new Pharmacist(
                FAKER.firstName(),
                FAKER.lastName(),
                "MB",
                FAKER.lastName() + "& CO");
    }

    public Pharmacist(String firstName, String lastName, String businessType, String companyName) {
        super(firstName, lastName);
        this.businessType = businessType;
        this.companyName = companyName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}