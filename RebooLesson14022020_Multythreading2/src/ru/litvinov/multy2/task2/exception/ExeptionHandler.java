package ru.litvinov.multy2.task2.exception;

public class ExeptionHandler implements Thread.UncaughtExceptionHandler {
    private Integer countFailed = 0;
    private Integer countInterrupted = 0;

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e.getMessage().equals("Interrupted")) {
            countInterrupted++;
        } else {
            countFailed++;
        }
    }

    public Integer getCountFailed() {
        return countFailed;
    }

    public Integer getCountInterrupted() {
        return countInterrupted;
    }
}
