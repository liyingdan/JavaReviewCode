package thread;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyingdan
 * @date 2019/9/13
 */
/*
* 三个线程交叉打印a、b、c各10遍。---lock
* */
public class Test3 {
    private static int state = 1;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread4());
        Thread t2 = new Thread(new Thread5());
        Thread t3 = new Thread(new Thread6());
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();
    }

    static class Thread4 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    if(state == 1){
                        System.out.println(Thread.currentThread().getName()+"：A，第"+i+"遍");
                        state = 2;
                        i ++;
                    }

                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class Thread5 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    if(state == 2){
                        System.out.println(Thread.currentThread().getName()+"：B，第"+i+"遍");
                        state = 3;
                        i ++;
                    }

                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class Thread6 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    if(state == 3){
                        System.out.println(Thread.currentThread().getName()+"：C，第"+i+"遍");
                        state = 1;
                        i ++;
                    }

                }finally {
                    lock.unlock();
                }
            }
        }
    }
}


