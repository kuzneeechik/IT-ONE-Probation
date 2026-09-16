package ru.itone.course_java.core.base_threads;

public class IncrementCounterTask {

    private static int counter = 0;

    private static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(IncrementCounterTask::increment);
        Thread thread2 = new Thread(IncrementCounterTask::increment);
        Thread thread3 = new Thread(IncrementCounterTask::increment);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();


        System.out.println("Counter: " + counter);
    }
}
