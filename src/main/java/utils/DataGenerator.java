package utils;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataGenerator {

    private static final String ALPHANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new Random();

    public static String randomString(int length) {
        return IntStream.range(0, length)
                .mapToObj(i -> String.valueOf(ALPHANUM.charAt(random.nextInt(ALPHANUM.length()))))
                .collect(Collectors.joining());
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