package day01;

/**
 * @author liyingdan
 * @date 2019/9/21
 * 两个线程打印12A 34B 56C-----95Z
 */
public class Main {
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();

    }

    static class Thread1 implements Runnable{
        @Override
        public void run() {
            for (int i = 1; i <= 52; i++) {
                synchronized (lock){
                    lock.notify();
                    System.out.print(i);
                    if(i % 2 == 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class Thread2 implements Runnable{
        @Override
        public void run() {
            for (char a = 65; a <= 97; a++) {
                synchronized (lock){
                    lock.notify();
                    System.out.print(a+" ");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}


