package Template;
/*模板方法设计模式*/
public class TestTemplate {
    public static void main(String[] args) {
        new MyTemplate().spendTimme();;
    }
}


abstract class Template{
    public abstract void code();
    public void spendTimme(){
        long s = System.currentTimeMillis();
        code();
        long e = System.currentTimeMillis();
        System.out.println("花费的时间为："+(e -s));
    }
}

class MyTemplate extends Template{
    @Override
    public void code() {
        //质数
        boolean flag = false;
        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                System.out.print(i + " ");
            flag = false;
        }
    }
}
