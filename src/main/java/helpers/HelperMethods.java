package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class HelperMethods {

    public static String generatePhoneNumber() {
        String[] prefixes = {"010", "011", "012", "015"};
        Random random = new Random();
        String prefix = prefixes[random.nextInt(prefixes.length)];
        int randomDigits = 10000000 + random.nextInt(90000000);
        return String.format("%s%d", prefix, randomDigits);
    }

    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }

    public static int generateAmountNumber() {
        int min = 2;
        int max = 20;
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}
