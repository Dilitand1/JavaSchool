import MyExceptions.AccountIsLockedException;
import MyExceptions.PinException;
import MyExceptions.WrongPin;

import java.util.Date;

public class PinValidator {

    private boolean pin;
    private int counter;
    private final int maxCounter;

    PinValidator(int counter, int maxCounter) {
        this.counter = counter;
        this.maxCounter = maxCounter;
        this.pin = false;
    }
    void enterTruePin(){
        pin = true;
        counter = 0;
    }
    void enterFalsePin() throws AccountIsLockedException, WrongPin {
        pin = false;
        counter++;
        if (counter == 3){
            Date unlock = new Date();
            String dateOutput = unlock.getHours() + ":" + unlock.getMinutes() + ":" + (unlock.getSeconds()+5);
            throw new AccountIsLockedException(dateOutput);
        }
        else{
            throw new WrongPin("Введен не верный пин код");
        }
    }
    void isPin() throws PinException {
        if (!pin){
            throw new PinException();
        }
    }
}
