package Practic_11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadMain {
    static long totalSum = 0;
    static AtomicInteger atomicTotalSum = new AtomicInteger();
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        long startTime, endTime;
        ArrayList<Thread> threads = new ArrayList<>();

        System.out.println("Первый метод - \"Чистый\"");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            work(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
        totalSum = 0;


        System.out.println("Второй метод - \"Синхронизированный\"");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread= new Thread(()-> synWork(finalI));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
        totalSum = 0;
        threads.clear();

        System.out.println("Третий метод - \"Атомичный\"");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread= new Thread(()-> atomicWork(finalI));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + atomicTotalSum.get());
        threads.clear();

        System.out.println("Четвертый метод - \"Заглушечный\"");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread= new Thread(()-> lockWork(finalI));
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
        totalSum = 0;
        threads.clear();
    }



    public static void work(int i) {
        long startLocalTime = System.currentTimeMillis();
        long result = hardWork(i * 1000, 100_000_000);
        long endLocalTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endLocalTime - startLocalTime));
    }


    public static void synWork(int i) {
        long startLocalTime = System.currentTimeMillis();
        long result = synHardWork(i * 1000, 100_000_000);
        long endLocalTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endLocalTime - startLocalTime));
    }


    public static void atomicWork(int i) {
        long startTime = System.currentTimeMillis();
        long result = atomicHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime - startTime));
    }

    private static void lockWork(int i) {
        long startTime = System.currentTimeMillis();
        long result = lockHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime - startTime));
    }

    public static long hardWork(int num, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (num + i) * Math.sqrt(num + i) * Math.pow(num + i, num);
            totalSum++;
        }
        return a;
    }

    public static synchronized long synHardWork(int num, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (num + i) * Math.sqrt(num + i) * Math.pow(num + i, num);
            totalSum++;
        }
        return a;
    }

    public static long atomicHardWork(int num, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (num + i) * Math.sqrt(num + i) * Math.pow(num + i, num);
            atomicTotalSum.getAndIncrement();
        }
        return a;
    }

    public static long lockHardWork(int num, int count) {
        long a = 0;
        lock.lock();
        for (int i = 0; i < count; i++) {
            a += (num + i) * Math.sqrt(num + i) * Math.pow(num + i, num);
            totalSum++;
        }
        lock.unlock();
        return a;
    }
}
