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
    //输出 1-52
    static class Thread1 implements Runnable{
        @Override
        public void run() {
            int i = 1;
            while (true){
                synchronized (lock){
                    lock.notifyAll();
                    for (; i <= 52; i++) {
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
    }
    //输出A-Z
    static class Thread2 implements Runnable{
        @Override
        public void run() {
            char a = 65;
            synchronized (lock){
                lock.notify();
                for (; a <= 97; a++) {
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


