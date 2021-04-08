import MyExceptions.*;

public class TerminalImpl implements ITerminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;

    TerminalImpl(TerminalServer ts, PinValidator pinValidator) {
        this.server = ts;
        this.pinValidator = pinValidator;
    }

    void enterTruePin() {
        pinValidator.enterTruePin();
    }

    void enterFalsePin() {
        try {
            pinValidator.enterFalsePin();
        } catch (WrongPin | AccountIsLockedException e) {
            System.out.println(e.getMessage());
        }
    }

    void disco() {
        server.setConnect(false);
    }

    @Override
    public void withdraw(double sum) {
        try {
            server.isConnected();
            pinValidator.isPin();
        } catch (ConnectError | PinException p) {
            System.out.println(p.getMessage());
            return;
        }

        try {
            server.withdraw(sum);
        } catch (WrongSum | NotEnoughtMoney wrongSum) {
            System.out.println(wrongSum.getMessage());
        }
    }

    @Override
    public void deposit(double sum) {
        try {
            server.isConnected();
            pinValidator.isPin();
        } catch (ConnectError | PinException p) {
            System.out.println(p.getMessage());
            return;
        }

        try {
            server.deposit(sum);
        } catch (WrongSum wrongSum) {
            System.out.println(wrongSum.getMessage());
        }
    }

    @Override
    public void balance() {
        try {
            server.isConnected();
            pinValidator.isPin();
        } catch (ConnectError | PinException p) {
            System.out.println(p.getMessage());
            return;
        }
        System.out.println("Ваш баланс " + server.getBalance());
    }
}
