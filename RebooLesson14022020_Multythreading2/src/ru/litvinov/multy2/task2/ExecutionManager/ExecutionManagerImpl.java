package ru.litvinov.multy2.task2.ExecutionManager;

import ru.litvinov.multy2.task2.Context.Context;
import ru.litvinov.multy2.task2.Context.ContextImpl;
import ru.litvinov.multy2.task2.exception.ExeptionHandler;

import java.util.ArrayList;
import java.util.List;


public class ExecutionManagerImpl implements ExecutionManager {
    private static List<Thread> threadList = new ArrayList<Thread>();
    private static Context context;
    ExeptionHandler exeptionHandler;

    public ExecutionManagerImpl(ExeptionHandler exeptionHandler) {
        this.exeptionHandler = exeptionHandler;
    }

    @Override
    public Context execute(Runnable callback, Runnable... tasks) throws InterruptedException {
        for (int i = 0; i < tasks.length; i++) {
            threadList.add(new Thread(tasks[i]));
            threadList.get(i).setUncaughtExceptionHandler(exeptionHandler);
            threadList.get(i).start();
        }
        context = new ContextImpl(threadList, exeptionHandler);
        threadList.get(3).interrupt();
        new Thread(new IsEnded(callback)).start();
        return context;
    }

    private class IsEnded implements Runnable {
        Runnable callback;

        public IsEnded(Runnable callback) {
            this.callback = callback;
        }

        public void run() {
            while (!context.isFinished()) {
                Thread.yield();
            }
            new Thread(callback).start();
        }
    }
}
