package net.brac.web.fluentlenium.util;

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
}
