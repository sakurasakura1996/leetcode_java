package Understand_JVM.Chapter12;

import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }


            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    for (int i = 0; i < vector.size(); i++) {
//                        vector.remove(i);
//                    }
                    synchronized (vector){
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    for (int i = 0; i < vector.size(); i++) {
//                        System.out.println(vector.get(i));
//                    }
                    synchronized (vector) {   // 注释的代码在多线程环境下并不能保证 vector线程安全，还是得外部采取措施来保证它线程安全。
                        for (int i = 0; i < vector.size(); i++) {
//                            System.out.println(vector.get(i));
                            System.out.println(vector.size());
                        }
                    }
                }
            });

            removeThread.start();
            printThread.start();
        }
    }
}
