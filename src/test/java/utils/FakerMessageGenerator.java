package utils;

import com.github.javafaker.Faker;


public class FakerMessageGenerator {

    public static String generateName() {
        return new Faker().name().firstName();
    }

    public static String generateJob() {
        return new Faker().company().profession();
    }

    public static String generateEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String generatePassword() {
        return new Faker().internet().password();
    }

}
