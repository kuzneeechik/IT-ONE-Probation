package ru.itone.course_java.core.base_threads;

public class ProducerConsumerTask {

    private static int value;
    private static boolean available = false;

    public static synchronized void produce() throws InterruptedException {
        while (available) {
            ProducerConsumerTask.class.wait();
        }

        value = 10;
        available = true;

        System.out.println("Produced: " + value);

        ProducerConsumerTask.class.notify();
    }

    public static synchronized void consume() throws InterruptedException {
        while (!available) {
            ProducerConsumerTask.class.wait();
        }

        System.out.println("Consumed: " + value);

        available = false;

        ProducerConsumerTask.class.notify();
    }

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}
