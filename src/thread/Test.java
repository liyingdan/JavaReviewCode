package thread;

/**
 * @author liyingdan
 * @date 2019/9/13
 */
/**
 * 练习：两个线程交叉打印1~10的数
 **/
//方式一
//public class Test {
//    private static Object lock = new Object();
//    private static Boolean flag = true;
//
//    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 10; i += 2) {
//                    synchronized (lock){
//                        if(!flag){
//                            try {
//                                lock.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        System.out.println(Thread.currentThread().getName()+":"+i);
//                        flag = false;
//                        lock.notify();
//                    }
//                }
//            }
//        },"线程1").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 2; i <= 10; i += 2) {
//                    synchronized (lock){
//                        if(flag){
//                            try {
//                                lock.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        System.out.println(Thread.currentThread().getName()+":"+i);
//                        flag = true;
//                        lock.notify();
//                    }
//                }
//            }
//        },"线程2").start();
//    }
//

    //方式二
public class Test {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();

    }
}
class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                this.notify();
                if(number <= 10){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number ++;
                    try {
                        this.wait(); //告知线程进入阻塞状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else
                    break;
            }
        }
    }
}
