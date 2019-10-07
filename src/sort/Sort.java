package sort;

import java.util.Arrays;

/**
 * @author liyingdan
 * @date 2019/10/3
 *
 *
//        int[] ints = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            ints[i] = (int) (Math.random() * 8000000);
//        }
////        System.out.println(Arrays.toString(ints));
//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(date1);
//        System.out.println(format);
//        shellSort(ints);
//        Date date = new Date();
//        String format1 = simpleDateFormat.format(date);
//        System.out.println(format1);

 */
public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{1,20,1,20,3,4,60,7,8,19,2,510,100,110,1200};
        int[] ints = radixSort(array);
        System.out.println(Arrays.toString(ints)); //[1, 1, 2, 3, 4, 7, 8, 19, 20, 20, 60, 100, 110, 510, 1200]

    }

    /*
    * 基数排序
    * */
    public static int[] radixSort(int[] arr){
        if (arr == null || arr.length < 2)
            return arr;
        //找到最大的数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
        int maxLength = (max + "").length();
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组（长度为arr.length,防止溢出）
        int[][] bucket = new int[10][arr.length];
        //定义一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];
        int digitOfElement = 0; //每个元素的位数的值
        //第几轮
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //遍历数组中的元素
            for (int j = 0; j < arr.length; j++) {
                digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement] ++;
            }
            //1) 按照顺序，把桶中的元素放到数组中
            int index = 0;
            //k代表第k个桶
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //2) 如果桶中有数据，放到原数组中
                if(bucketElementCounts[k] != 0){
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index ++] = bucket[k][l];
                    }
                }
                //每轮结束后，清空桶中的数据
                bucketElementCounts[k] = 0;
            }
        }
        return arr;
    }


    /*
    * 归并排序 - 分 + 合 的方法
    * */
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    /*
    * 归并排序 - 合并的方法
    *
    * arr：排序的原始数组
    * left：左边有序序列的初始索引
    * mid：中间索引
    * right：右边索引
    * temp：做中转的数组
    * */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left; //初始化i，左边有序序列的初始索引
        int j = mid + 1; //初始化j，右边有序序列的初始索引
        int t = 0; //指向temp数组的当前索引
        //1.先把左右两边（有序）的数据按照规则填充到temp数组中，直到左右两边的有序序列有一边处理完毕为止
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else{
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //2.把有剩余数据的一边数据依次全部填充到temp
        while(i <= mid){
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while(j <= right){
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //3.将temp数组的元素拷贝到arr。注意：不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }


    /*
     * 快速排序
     * */
    //如果有相同的数会报错
//    public static int[] quickSort(int[] arr, int left, int right){
//        if (arr.length < 1 || left < 0 || right >= arr.length || left > right)
//            return null;
//        int i = left, j = right, temp = 0;
//        while(i < j){
//            while (arr[j] > arr[left])
//                j --;
//            while (arr[i] < arr[left])
//                i ++;
//            temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//        }
//        if(i == j){
//            temp = arr[left];
//            arr[left] = arr[i];
//            arr[i] = temp;
//        }
//        quickSort(arr, left, i - 1);
//        quickSort(arr, i + 1, right);
//        return arr;
//    }

    public static int[] quickSort(int[] arr, int left, int right){
        if (arr.length < 1 || left < 0 || right >= arr.length || left > right)
            return null;
        int i = left, j = right;
        while(i != j){
            while (arr[j] >= arr[left] && j > i)
                j --;
            while (arr[i] <= arr[left] && i < j)
                i ++;
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if(i == j){
            int temp = arr[left];
            arr[left] = arr[i];
            arr[i] = temp;
        }
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
        return arr;
    }

    /*冒泡排序*/
    public static int[] bubbleSort(int[] arr) {
        boolean flag = false; //标识变量，表示此次循环是否进行过交换
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第"+(i + 1)+"趟");
            if(!flag) //在一趟排序中，一次交换都没有发生过
                break;
            else
                flag = false; //重置flag，进行下次判断
        }
        return arr;
    }

    /*选择排序*/
    public static int[] selectedSort(int[] arr) {
        if(arr.length == 0)
            return arr;
        int temp = 0;
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j])
                    index = j;
            }
            if (index != i) {
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        return arr;
    }

    /*插入排序*/
    public static int[] insertSort(int[] arr){
        if(arr.length == 0)
            return arr;
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }
            arr[insertIndex + 1] = insertVal;
        }
        return arr;
    }

    /*希尔排序 -- 交换法 - 速度慢*/
//    public static int[] shellSort(int[] arr){
//        if(arr.length == 0)
//            return arr;
//        int temp = 0;
//        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
//            for (int i = gap; i < arr.length; i++) {
//                //遍历各组中的所有元素（共gap组），步长gap
//                for (int j = i - gap; j >= 0 ; j -= gap) {
//                    //如果当前元素大于步长后的那个元素，说明交换
//                    if(arr[j] > arr[j + gap]){
//                        temp = arr[j];
//                        arr[j] = arr[j + gap];
//                        arr[j + gap] = temp;
//                    }
//                }
//            }
//        }
//        return arr;
//    }

    /**
     * 希尔排序 - 平移法
     */
    public static int[] shellSort(int[] array) {
        int temp, gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }


















}