package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyingdan
 * @date 2019/9/13
 */
class Window implements Runnable{
    private int ticket = 50;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock(); //2.调用锁定方法lock
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖第"+ticket+"张票");
                    ticket --;
                }else
                    break;
            } finally {
                lock.unlock(); //3.调用解锁方法：unlock()
            }
        }
    }
}


public class LookTest {
    public static void main(String[] args) {
        Window window = new Window();

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}
