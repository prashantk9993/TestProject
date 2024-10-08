package src;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarrierAction());

        System.out.println("Starting");
        new Thread(new MyThread(cb, "A")).start();
        new Thread(new MyThread(cb, "B")).start();
        new Thread(new MyThread(cb, "C")).start();

        new Thread(new MyThread(cb, "X")).start();
        new Thread(new MyThread(cb, "Y")).start();
        new Thread(new MyThread(cb, "Z")).start();

        System.out.println("Main method end...");
    }
}

class MyThread implements Runnable {
    CyclicBarrier cbar;
    String name;
    MyThread(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
    }

    @Override
    public void run() {
        System.out.println("Thread Starting ::::"+name);
        try {
            System.out.println("Thread Awaiting ::::"+name);
            cbar.await();
            System.out.println("Thread Done Awaiting ::::"+name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class BarrierAction implements Runnable{
    @Override
    public void run() {
        System.out.println("Barrier Reached! and starting Barrier Action Thread");
    }
}