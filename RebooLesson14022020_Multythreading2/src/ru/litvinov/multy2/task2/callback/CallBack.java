package ru.litvinov.multy2.task2.callback;

import ru.litvinov.multy2.task2.exception.ExeptionHandler;

public class CallBack implements Runnable {

    private ExeptionHandler exceptionHandler;

    public CallBack(ExeptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void run() {
        System.out.println("CallBack is started");
        System.out.println("Сломалось " + exceptionHandler.getCountFailed() + " потоков\nПрервано " + exceptionHandler.getCountInterrupted() + " потоков");
        System.out.println("All threads completed");

    }
}
