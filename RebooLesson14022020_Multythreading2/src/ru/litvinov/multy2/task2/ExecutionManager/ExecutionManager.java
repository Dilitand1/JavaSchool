package ru.litvinov.multy2.task2.ExecutionManager;

import ru.litvinov.multy2.task2.Context.Context;


public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks) throws InterruptedException;
}
