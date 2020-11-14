package sda.JavaVilnius5.poolApp.exeptions;

public class ParticipantNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public ParticipantNotFoundException(String message) {
        super(message);
    }

}
