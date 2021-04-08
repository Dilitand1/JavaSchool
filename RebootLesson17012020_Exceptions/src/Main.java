import MyExceptions.PinException;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        PinValidator pinValidator = new PinValidator(0,3);
        TerminalServer terminalServer = new TerminalServer();
        TerminalImpl terminal = new TerminalImpl(terminalServer,pinValidator);

        System.out.println("Симуляция с 3 неверными пинами:");
        wrongPinThree(terminal);
        System.out.println();

        System.out.println("Симуляция со снятием:");
        withdraw(terminal);
        System.out.println();

        System.out.println("Симуляция с депозитом:");
        deposit(terminal);
        System.out.println();

        System.out.println("Симуляция с обрывом связи:");
        disco(terminal);
        System.out.println();

        System.out.println("Симуляция с недостатком средств:");
        terminal = new TerminalImpl(new TerminalServer(150),pinValidator);
        withdraw(terminal);
    }

    public static void wrongPinThree(TerminalImpl t){
        t.enterFalsePin();
        t.enterFalsePin();
        t.enterFalsePin();
    }

    public static void withdraw(TerminalImpl t){
        t.enterTruePin();
        t.balance();
        t.withdraw(1000);
        t.balance();
    }
    public static void deposit(TerminalImpl t){
        t.enterTruePin();
        t.balance();
        t.deposit(133);//Кладем некратную сумму
        t.deposit(1000);
        t.balance();
    }
    public static void disco(TerminalImpl t){
        t.enterTruePin();
        t.balance();
        t.disco();
        t.deposit(1000);
        t.balance();
    }

}

