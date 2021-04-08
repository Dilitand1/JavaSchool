import MyExceptions.AccountIsLockedException;
import MyExceptions.NotEnoughtMoney;
import MyExceptions.PinException;
import MyExceptions.WrongSum;

public interface ITerminal {
    void withdraw(double sum) ;
    void deposit(double sum) ;
    void balance() ;
}
