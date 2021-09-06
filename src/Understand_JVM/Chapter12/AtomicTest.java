package Understand_JVM.Chapter12;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase(){
        race.incrementAndGet();  // 归功于 incrementAndGet()方法是原子性的。
    }

    private static final int THREADS_COUNT = 2;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 2){  // 这里的IDEA要改成2，因为启动的时候默认多加了一个线程 Monitor Ctrl-Break线程。
            Thread.yield();
        }

        System.out.println(race);
    }
}
