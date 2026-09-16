package ru.itone.course_java.core.base_threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTask {

    private static final CyclicBarrier barrier = new CyclicBarrier(3);

    private static void work() {
        try {
            System.out.println(
                    Thread.currentThread().getName() + " started"
            );

            Thread.sleep(1000);

            System.out.println(
                    Thread.currentThread().getName() + " reached barrier"
            );

            barrier.await();

            System.out.println(
                    Thread.currentThread().getName() + " continued"
            );

        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(CyclicBarrierTask::work, "Thread 1");
        Thread thread2 = new Thread(CyclicBarrierTask::work, "Thread 2");
        Thread thread3 = new Thread(CyclicBarrierTask::work, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
