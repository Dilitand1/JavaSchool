package MyExceptions;

public class PinException extends Exception {
    public PinException() {
        super("Не был введен пин");
    }
}