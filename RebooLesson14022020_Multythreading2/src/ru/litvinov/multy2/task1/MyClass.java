package ru.litvinov.multy2.task1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyClass {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public MyClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String longworker() throws InterruptedException {
        try {
            Date date = new Date();
            TimeUnit.SECONDS.sleep(2);
            int z = x / y;
            return date.toString() + " " + z;
        }
        catch (ArithmeticException e){
            throw new MyException("Мое исключение");
        }
    }
}