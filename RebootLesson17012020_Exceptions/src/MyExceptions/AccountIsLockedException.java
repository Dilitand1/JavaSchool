package MyExceptions;

public class AccountIsLockedException extends Exception{
    public AccountIsLockedException(String message) {
        super("Введено слишком много попыток, счет разблокируется в " + message);
    }
}
