package MyExceptions;

public class ConnectError extends Exception {
    public ConnectError(String message) {
        super(message);
    }
}