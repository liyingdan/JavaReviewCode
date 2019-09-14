package thread;

/**
 * @author liyingdan
 * @date 2019/9/14
 */
public class ChangeABC {
    private Object lock = new Object();
    private boolean RUN0 = true;
//    private static final int LIMIT = 10;

    public static void main(String[] args) throws InterruptedException {
        final ChangeABC o = new ChangeABC();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    o.m0();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    o.m1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程2").start();
        Thread.sleep(10 * 1000);
    }

    private void m1() throws InterruptedException {
        for (int i = 1; i <= 10; i += 2) {
            synchronized (lock) {
                if (RUN0) {
                    lock.wait();
                }
                System.out.println(Thread.currentThread().getName() + "：" + i);
                RUN0 = true;
                lock.notify();
            }
        }
    }

    private void m0() throws InterruptedException {
        for (int i = 0; i <= 10; i += 2) {
            synchronized (lock) {
                if (!RUN0) {
                    lock.wait();
                }
                System.out.println(Thread.currentThread().getName() + "：" + i);
                RUN0 = false;
                lock.notify();
            }
        }
    }
}



