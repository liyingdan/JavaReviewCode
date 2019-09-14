package thread;

/**
 * @author liyingdan
 * @date 2019/9/13
 */
class Windows1 implements Runnable{
    private int ticket = 50;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName()+"卖第"+ticket+"张票");
                    ticket --;
                }else
                    break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Windows1 windows1 = new Windows1();

        Thread t1 = new Thread(windows1);
        Thread t2 = new Thread(windows1);
        Thread t3 = new Thread(windows1);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}
