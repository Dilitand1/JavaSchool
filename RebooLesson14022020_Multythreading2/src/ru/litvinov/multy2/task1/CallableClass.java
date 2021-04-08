package ru.litvinov.multy2.task1;

import java.util.concurrent.Callable;

public class CallableClass implements Callable {
    MyClass myClass;

    public CallableClass(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public Object call() throws Exception {
        myClass.setY(myClass.getY()+1);
        String s = myClass.longworker();
        return s;
    }
}
