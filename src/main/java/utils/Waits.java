package utils;

public class Waits {

    public static void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new Error("got interrupted:" + e.getMessage(), e);
        }
    }
}
