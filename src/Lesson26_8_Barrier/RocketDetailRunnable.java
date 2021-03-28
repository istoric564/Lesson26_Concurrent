package Lesson26_8_Barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RocketDetailRunnable implements Runnable{
    private final RocketDetail1 rocketDetail1;
    private final CyclicBarrier cyclicBarrier;

    public RocketDetailRunnable(RocketDetail1 rocketDetail1, CyclicBarrier cyclicBarrier) {
        this.rocketDetail1 = rocketDetail1;
        this.cyclicBarrier = cyclicBarrier;
    }


    @Override
    public void run() {
        System.out.println("Готовится деталь: " + rocketDetail1);
        try {
            Thread.sleep(1000L);
            System.out.println("Деталь готова и ожидает: " + rocketDetail1);
            cyclicBarrier.await();
            System.out.println("Деталь использована: " + rocketDetail1);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
