package ru.litvinov.multy2.task2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyClass implements Runnable {
    int x;
    int y;

    public MyClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            int z = x / y;
            System.out.println(Thread.currentThread().getName() + " is ended, result is " + z);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted");
        }

    }
}