package thread;

/**
 * @author liyingdan
 * @date 2019/9/12
 */
public class ThreadTest{
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread myThread1 = new MyThread();
        myThread1.setName("线程1");
        /*如果不执行start，直接执行run的话，只有一个线程*/
        //4.通过此对象调用start
        myThread1.start();
    }
}
//1.创建一个继承于Thread的子类
class MyThread extends Thread {
    //2.重写Thread类的run()
    public void run(){
        //求100以内的质数
        label: for (int i = 2; i <= 100; i++) {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if(i % j == 0)
                        continue label;
                }
                System.out.println(i);
        }
    }
}
