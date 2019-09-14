package thread;

/**
 * @author liyingdan
 * @date 2019/9/13
 */
/**
 * 三个线程交叉打印a、b、c各10遍。---synchronized
 * */
public class Test2 {
     private static int state = 1;
     private static Object lock = new Object();

     public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        t1.setName("线程1");
        t1.start();
        Thread t2 = new Thread(new Thread2());
        t2.setName("线程2");
        t2.start();
        Thread t3 = new Thread(new Thread3());
        t3.setName("线程3");
        t3.start();

    }

    static class Thread1 implements Runnable{
         public void run(){
             int i = 0;
             while (i < 10){
                 synchronized (lock){
                     if(state == 1){
                         System.out.println(Thread.currentThread().getName()+"：A，第"+i+"遍");
                         i ++;
                         state = 2;
                         lock.notifyAll();//调用方法时加上锁
                     }else {
                         try {
                             lock.wait(); //调用方法时加上锁
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 }
             }
         }
    }
    static class Thread2 implements Runnable{
        public void run(){
            int i = 0;
            while (i < 10){
                synchronized (lock){
                    if(state == 2){
                        System.out.println(Thread.currentThread().getName()+"：B，第"+i+"遍");
                        i ++;
                        state = 3;
                        lock.notifyAll();
                    }else {
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
    static class Thread3 implements Runnable{
        public void run(){
            int i = 0;
            while (i < 10){
                synchronized (lock){
                    if(state == 3){
                        System.out.println(Thread.currentThread().getName()+"：C，第"+i+"遍");
                        i ++;
                        state = 1;
                        lock.notifyAll();
                    }else {
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
