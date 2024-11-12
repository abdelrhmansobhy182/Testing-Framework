package helpers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GeneralHelperMethods {

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

    public static String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }

    public static String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime now = LocalTime.now();
        return now.format(formatter);
    }

    public static Float generateAmountNumber() {
        Float min = 2F;
        Float max = 20F;
        Random random = new Random();
        return random.nextFloat(max - min + 1) + min;
    }

}
