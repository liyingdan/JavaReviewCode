package thread;

/**
 * @author liyingdan
 * @date 2019/9/13
 */
//1.创建了一个runnable接口的类
class MThread implements Runnable{
    //2.实现run()
    @Override
    public void run() {
        /*
        * 找1000以内的水仙花数 三位数 其各个位数上的和等于其本身
        * 153 = 1*1*1 + 3*3*3 + 5*5*5
        * */
        for (int i = 100; i <= 999; i++) {
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;
            if(i == a*a*a + b*b*b +c*c*c)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MThread mThread = new MThread();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread thread = new Thread(mThread);
        thread.setName("线程1");
        //5.通过Thread的对象调用start()
        thread.start();
    }
}
