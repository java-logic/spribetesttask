package utils;

import java.util.Random;

public class DataGenerator {

    private static final String ALPHANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new Random();

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            sb.append(ALPHANUM.charAt(random.nextInt(ALPHANUM.length())));
        }
        return sb.toString();
    }

    public static int randomAge() {
        return 16 + random.nextInt(45); // 16-60
    }

    public static String randomGender() {
        return random.nextBoolean() ? "male" : "female";
    }

    public static String randomRole() {
        return random.nextBoolean() ? "user" : "admin";
    }
}