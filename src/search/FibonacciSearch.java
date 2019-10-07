package search;

import java.util.Arrays;

/**
 * @author liyingdan
 * @date 2019/10/5
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 89));
    }

    /**
     * 因为后面会用到斐波那契数列 求 mid = low + F(k - 1) - 1
     *
     * 构建斐波那契数列 - 非递归
     * */
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找算法 - 非递归
     *
     * key 为要查找的关键码
     * */
    public static int fibSearch(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        int k = 0; //表示斐波那契分割数值的下标
        int mid = 0; //存放mid值
        int f[] = fib(); //获取到斐波那契数列
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1)
            k ++;
        //因为 f[k] 值可能大于 a 的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        //不足的部分先用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际上需求使用arr数组最后的数填充 temp
        //举例：
        //temp = {1, 8, 10, 89, 1000, 1234，0,0,0} => {1, 8, 10, 89, 1000, 1234,1234,1234,1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //使用while循环来处理，找到数key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if(key < temp[mid]){ //继续向数组的前面（左边）查找
                high = mid - 1;
                //为什么是k-- ？
                //说明：
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k - 1] + f[k - 2]
                //3. 因为前面有 f[k - 1] 个元素，所以可以继续拆分 f[k - 1] = f[k - 2] + f[k - 3]
                //4. 即在 f[k - 1] 的前面继续查找
                //5. 即下次循环 mid = f[k - 1 - 1] - 1
                k --;
            }else if(key > temp[mid]){ //继续向数组的后面（右边）查找
                low = mid + 1;
                //为什么是k -= 2
                //说明：
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k - 1] + f[k - 2]
                //3. 因为后面有 f[k - 2] 个元素，所以可以继续拆分 f[k - 1] = f[k - 3] + f[k - 4]
                //4. 即在 f[k - 2] 的前面继续查找 k -= 2
                //5. 即下次循环 mid = f[k - 1 - 2] - 1
                k -= 2;
            }else{ //找到
                if( mid <= high)
                    return mid;
                else
                    return high;
            }
        }
        return -1;
    }

}