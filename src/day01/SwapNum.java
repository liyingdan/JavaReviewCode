package day01;

public class SwapNum {
    public static void main(String[] args) {
        int m = 5, n = 10;
        System.out.println("m="+m+", n="+n);

        //1.提供一个临时变量
        int temp = m;
        m = n;
        n = temp;
        System.out.println("m="+m+", n="+n);

        //2.位运算n^m^n = m
        m = m^n;
        n = m^n;
        m = m^n;
        System.out.println("m="+m+", n="+n);

    }


}
