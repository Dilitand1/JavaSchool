package ru.litvinov.multy2.task1;
import ru.litvinov.multy2.task1.CallableClass;
import ru.litvinov.multy2.task1.MyClass;
import ru.litvinov.multy2.task1.Task;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Задачка номер один
        testTask1(new MyClass(25,5)); //пример без исключения
        Thread.sleep(3000);
        testTask1(new MyClass(25,-1)); //пример с исключением (деление на ноль)
        Thread.sleep(3000);
    }
    static void testTask1(MyClass myClass){
        Task task = new Task(new CallableClass(myClass));

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(task.get());
                    } catch (InterruptedException | ExecutionException e) {
                        task.setException(true);
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
