package day01;

import java.util.ArrayList;

public class NewArray {
    public static void main(String[] args) {
        //一维数组
//        int[] arr1 = {1,2,3,4,5};
//
//        int arr2[] = new int[]{1,2,3,4,5};
//
//        int arr3[] = new int[5];
//        arr3[0] = 1;
//        arr3[1] = 2;
//
//        for (int i = 0; i < arr3.length; i++) {
//            System.out.print(arr3[i]); //12000
//        }


        //二维数组
        //动态初始化
        //二维数组中有3个一维数组，每个一维数组中有2个元素，一维数组的名称分别为d[0],d[1],d[2]
        int[][] arr4 = new int[3][2];
        arr4[0][0] = 1;
        arr4[0][1] = 2;
        arr4[1][1] = 5;

        //动态初始化
        int[][] arr5 = new int[3][];
        arr5[0] = new int[2];

        //静态初始化
        //第一个一维数组arr6[0] = {1,2,3}
        int[][] arr6 = new int[][]{{1,2,3},{4,5,6}};

        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j]+"");
            }
            System.out.println();
        }
    }

}
