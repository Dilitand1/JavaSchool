package ru.litvinov.timer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 100;i++) {
            list.add(executorService.schedule(new ThreadClass(),1L,TimeUnit.SECONDS));
            System.out.println(i + ": "  + list.get(i).get());
        }
        executorService.shutdown();
    }

    static public class ThreadClass implements Callable {
        @Override
        public String call() {
            return LocalDateTime.now().toString();
        }
    }
}
