package StackAndQueue;

/**
 * @author liyingdan
 * @date 2019/9/15
 *
 *  n阶汉诺塔问题:假设有3个分别命名为X、Y和Z的塔座，在塔座X上插有n个直径大小各不相同，且从小到大编号为1、2.....n的圆盘。
 *  现要求将塔座X上的n个圆盘借助塔座Y移至塔座Z上，并仍按同样顺序叠排。圆盘移动时必须遵循下列规则:
 *
 * (1)每次只能移动一个圆盘。
 *
 * (2)圆盘可以插在X、Y和Z中的任何一个塔座上。
 *
 * (3)任何时刻都不能将一一个较大的圆盘压在较小的圆盘之上。
 */
public class Test_Hanoi {
    public static void main(String[] args) {
        Test_Hanoi test_hanoi = new Test_Hanoi();
        test_hanoi.hanoi(3,'x','y','z');
    }

    //计数，第几次移动
    private int time = 0;
    //将塔座x上按直径由小到大且自上而下的编号为1至n的n个圆盘按规则移到塔座z上，y作为辅助塔座
    public void hanoi(int n, char x, char y, char z){
        if(n == 1){
            move(x,1,z); //将编号为1的圆盘从x移动到z
        }else {
            hanoi(n-1,x,z,y); //将x上编号为1至n-1的圆盘移动到y上，z为辅助
            move(x,n,z); //将编号为n的圆盘从x移动到z
            hanoi(n-1,y,x,z); //将y上编号为1到n-1的圆盘移动到z，x为辅助
        }
    }
    private void move(char x, int n, char z) {
        System.out.println("第"+ ++time + "次移动："+ n + "号园盘，"+ x + "--->" + z);
    }
}
