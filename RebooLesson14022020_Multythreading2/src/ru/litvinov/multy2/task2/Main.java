package ru.litvinov.multy2.task2;


import ru.litvinov.multy2.task2.Context.Context;
import ru.litvinov.multy2.task2.exception.ExeptionHandler;
import ru.litvinov.multy2.task2.callback.CallBack;
import ru.litvinov.multy2.task2.ExecutionManager.ExecutionManager;
import ru.litvinov.multy2.task2.ExecutionManager.ExecutionManagerImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Runnable> list = new ArrayList<Runnable>();

        for (int i = 0; i < 5; i++) {
            MyClass myClass = new MyClass(25, i);
            list.add(myClass);
        }
        ExeptionHandler exeptionHandler = new ExeptionHandler();
        ExecutionManager executionManager = new ExecutionManagerImpl(exeptionHandler);
        Context context = executionManager.execute(new CallBack(exeptionHandler), list.toArray(new Runnable[0]));
        Thread.sleep(1000);
        //можно потестить интеррупт
        //context.interrupt();
    }
}
