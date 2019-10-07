package search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liyingdan
 * @date 2019/10/5
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,3,5,8,7,0,2,9,4};
        ArrayList arrayList = seqSearch(arr, 4);
        System.out.println(arrayList);

    }

    //判断数列中是否包含此value   如果找到了，就提示找到，并给出下标值。
    public static ArrayList seqSearch(int[] arr, int value){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value)
                result.add(i);
        }
        return result;
    }
}
