package search;

import java.util.ArrayList;

/**
 * @author liyingdan
 * @date 2019/10/5
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8, 10, 89,1000, 1000, 1000,1234};
        ArrayList<Integer> integers = binarySearch1(arr, 0, arr.length, 1000);
        System.out.println(integers); //[4, 5, 6]
    }

    /*
    * 只查找到一个符合结果的数就行
    *
    * 假设传入的数组是从小到大排列的有序数组
    * */
    public static int binarySearch(int[] arr, int left, int right, int findVal){
        if(left > right)
            return -1;
        int mid = (left + right) / 2;
        if(findVal > arr[mid])
            return binarySearch(arr, mid + 1, right, findVal );
        else if(findVal < arr[mid])
            return binarySearch(arr, left, mid - 1, findVal );
        else
            return mid;
    }

    /**
     * {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000.
     * */
    public static ArrayList<Integer> binarySearch1(int[] arr, int left, int right, int findVal){
        if(left > right)
            return new ArrayList<Integer>();
        int mid = (left + right) / 2;
        if(findVal > arr[mid])
            return binarySearch1(arr, mid + 1, right, findVal );
        else if(findVal < arr[mid])
            return binarySearch1(arr, left, mid - 1, findVal );
        else{
            ArrayList<Integer> resultList = new ArrayList<>();
            //把mid左边符合条件的值放到list中
            int temp = mid - 1;
            while (true){
                if(temp <0 || arr[temp] != findVal)
                    break;
                resultList.add(temp);
                temp --;
            }
            resultList.add(mid);
            //把mid右边符合条件的值放到list中
            temp = mid + 1;
            while (true){
                if(temp >= arr.length || arr[temp] != findVal)
                    break;
                resultList.add(temp);
                temp ++;
            }
            return resultList;
        }
    }
}
