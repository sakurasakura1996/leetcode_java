package Art_of_Programming_in_Java.chapter1;

/*改代码用于演示死锁代码*/
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        Thread.currentThread().sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t1线程等待获取 资源B");
                    synchronized (B){
                        System.out.println("1");

                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    System.out.println("t2线程等待获取 资源A");
                    synchronized (A){
                        System.out.println("2");

                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
