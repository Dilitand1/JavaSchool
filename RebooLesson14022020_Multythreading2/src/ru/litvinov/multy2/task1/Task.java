package ru.litvinov.multy2.task1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Task<T> {
    private Callable<T> callable;
    private volatile T t = null;
    private volatile boolean isException = false;

    public Task(Callable<? extends T> callable) {
        this.callable = (Callable<T>) callable;
    }

    public void setException(boolean exception) {
        isException = exception;
    }

    public T get() throws MyException,InterruptedException, ExecutionException {
        if (t == null) {
            synchronized (this) {
                if (t == null) {
                    if (!isException){
                            System.out.println("результат не рассчитан считаем");
                            FutureTask<T> futureTask = new FutureTask<T>(callable);
                            new Thread(futureTask).start();
                            t = futureTask.get();
                            return t;
                        }
                    else {
                        throw new MyException("Проброс исключения в потоке " + Thread.currentThread().getName());
                    }
                }
            }
        }
        System.out.println("результат рассчитан берем из переменной");
        return t;
    }
}