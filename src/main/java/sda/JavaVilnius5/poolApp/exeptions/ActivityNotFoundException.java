package sda.JavaVilnius5.poolApp.exeptions;

public class ActivityNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ActivityNotFoundException(String message) {
        super(message);
    }
}
