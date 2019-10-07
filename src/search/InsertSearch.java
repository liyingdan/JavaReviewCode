package search;

import java.util.Arrays;

/**
 * @author liyingdan
 * @date 2019/10/5
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8, 10, 89, 1000, 1234};
        int i = insertValueSearch(arr, 0, arr.length - 1, 1000);
        System.out.println(i);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int findVal){
        // findVal < arr[0] 和 findVal > arr[arr.length - 1]这两句话必须有，否则mid可能会越界
        if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1])
            return -1;
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if(findVal > arr[mid]) //向右递归
            return insertValueSearch(arr, mid + 1, right, findVal );
        else if(findVal < arr[mid]) //向左递归
            return insertValueSearch(arr, left, mid - 1, findVal );
        else
            return mid;
    }
}




