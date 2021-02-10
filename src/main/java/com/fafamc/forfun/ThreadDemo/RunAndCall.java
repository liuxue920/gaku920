package com.fafamc.forfun.ThreadDemo;

import java.util.concurrent.*;

public class RunAndCall {
//    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("I am a runnable task");
//            }
//        });
//        thread.start();
//    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        BooleanCallableTask b = new BooleanCallableTask();
        Future<Boolean> future = executor.submit(b);
        executor.shutdown();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}

class BooleanCallableTask implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        return false;
    }
}