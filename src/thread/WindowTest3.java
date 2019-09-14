package thread;

/**
 * @author liyingdan
 * @date 2019/9/13
 */
class Window3 implements Runnable{
    private int ticket = 50;
    @Override
    public void run() {
        while (true){
            show();
        }
    }

    private synchronized void show(){ //同步监视器：this
        if(ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖第"+ticket+"张票");
            ticket --;
        }
    }
}
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 windows3 = new Window3();

        Thread t1 = new Thread(windows3);
        Thread t2 = new Thread(windows3);
        Thread t3 = new Thread(windows3);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
