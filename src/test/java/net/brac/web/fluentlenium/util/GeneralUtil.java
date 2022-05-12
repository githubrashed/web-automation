package net.brac.web.fluentlenium.util;

import java.util.Random;

public class GeneralUtil {
    //    public static String getNationalId() {
//        return "197" + (long) Math.floor(Math.random() * 9_000_000_000_000_0L) + 1_000_000_000_000_0L;
//    }
    public static String getNationalId() {
        return "197" + Math.floor(Math.random() * 9_000_000_000_000_0L) + 1_000_000_000_000_0L;
    }

    public static String getPassportNo() {
        return "PaNo" + (long) Math.floor(Math.random() * 9_000_000L) + 1_000_000L;
    }

    public static String getSmartCardId() {
        return String.valueOf((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_1000L);
    }

    public static void waitForDomStable() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getMobileNumber() {
        int num1, num2;
        int lastSixDigit;
        Random generator = new Random();
        num1 = generator.nextInt(9);
        num2 = generator.nextInt(9);
        lastSixDigit = generator.nextInt(999999) + 100000;
        return "017" + num1 + "" + num2 + "" + lastSixDigit;
    }
}
