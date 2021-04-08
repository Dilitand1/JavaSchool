import MyExceptions.ConnectError;
import MyExceptions.NotEnoughtMoney;
import MyExceptions.WrongSum;

public class TerminalServer {

    private boolean isConnect;
    private double accountBalance;


    TerminalServer() {
        isConnect = true;
        accountBalance = Math.random() * 10000 + 1000; //случайный баланс от 1000 до 10000
    }

    TerminalServer(double balance) {
        isConnect = true;
        if (balance < 0) {
            accountBalance = 0;
        } else {
            accountBalance = balance; 
        }
    }

    void isConnected() throws ConnectError {
        if (!isConnect) {
            throw new ConnectError("Отсутствует подключение к серверу, обратитесь в службу поддержки");
        }
    }

    void withdraw(double sum) throws WrongSum, NotEnoughtMoney {
        if (sum % 100D != 0.00D) {
            throw new WrongSum("Сумма должна быть кратна 100");
        } else if (sum > accountBalance) {
            throw new NotEnoughtMoney("Недостаточно средств");
        } else {
            accountBalance -= sum;
        }
    }

    void deposit(double sum) throws WrongSum {
        if (sum%100D != 0.00D) {
            throw new WrongSum("Сумма должна быть кратна 100");
        } else {
            accountBalance += sum;
        }
    }

    double getBalance() {
        return accountBalance;
    }

    public void setConnect(boolean b) {
        isConnect = b;
    }
}
