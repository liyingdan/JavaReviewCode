package thread;

/**
 * @author liyingdan
 * @date 2019/9/13
 */
class Window4 extends Thread{
    private static int ticket = 50;
    public void run(){
        while (true){
            show();
        }
    }
    private static synchronized void show(){
        if(ticket > 0){
            System.out.println(Thread.currentThread().getName()+"卖第"+ticket+"张票");
            ticket --;
        }
    }
}
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
