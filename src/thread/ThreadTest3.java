package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author liyingdan
 * @date 2019/9/13
 */
//1.创建一个实现Callable的实现类
class MThreas1 implements Callable {
    //2.实现call()方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        /*
        * 找出1000以内的完数--并且返回其个数
        * 完数：一个数如果恰好等于它的因子之和，这个数就成为完数。（因子：除去这个数本身的约数）
        * 例： 6 = 1 + 2 + 3
        * */
        int factor = 0;
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j < i; j++) {
                if(i % j == 0){
                    factor += j;
                }
            }
            if(i == factor){
                System.out.println(i);
                sum ++;
            }
            factor = 0;
        }
        return sum;
    }
}

public class ThreadTest3 {
    public static void main(String[] args) {
        //3.创建callable接口实现类的对象
        MThreas1 mThreas1 = new MThreas1();
        //4.将此callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(mThreas1);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start
        new Thread(futureTask).start();
        try {
            //6.获取callable中call方法的返回值
            Object o = futureTask.get();
            System.out.println("一共有"+o+"个完数");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
