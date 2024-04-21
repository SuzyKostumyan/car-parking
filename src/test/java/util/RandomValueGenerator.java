package util;

import java.util.Random;
import java.util.UUID;

public class RandomValueGenerator {

    public static String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    public static Long generatePositiveRandomLong() {
        return Math.abs(new Random().nextLong());
    }

    public static boolean generateRandomBoolean() {
        return new Random().nextBoolean();
    }
}