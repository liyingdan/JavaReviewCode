package day01;

import org.junit.Test;

public class Sort {
    /*冒泡排序-从小到大*/
    public int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    @Test
    public void test1(){
        int[] arr = {1,6,9,7,5,8,3,10,2};
        int[] ints = bubbleSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }

    /*直接选择排序*/
    public int[] directSort(int[] arr){
        if(arr.length == 0)
            return arr;
        for (int i = 0; i < arr.length - 1; i++) {
            int t = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[t] > arr[j])
                    t = j;
            }
            if(i != t){
                int temp = arr[i];
                arr[i] = arr[t];
                arr[t] = temp;
            }
        }
        return arr;
    }
    @Test
    public void test2(){
        int[] arr = {1,6,9,7,5,8,3,10,2,0,100};
        int[] ints = directSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }


    /*快速排序*/
    public void firstBaseValue(int[] arr, int first, int last){
        if (first > last) return;
        int i = first;
        int j = last;
        while (i != j){
           while (arr[j] >= arr[first] && j >i){
               j--;
           }
           while (arr[i] <= arr[first] && i < j){
               i++;
           }
           if(i < j){
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
           }
        }
        if(i == j){
           int temp = arr[i];
           arr[i] = arr[first];
           arr[first] = temp;
        }
        firstBaseValue(arr,first,i-1);
        firstBaseValue(arr,i+1,last);
    }


    @Test
    public void test3(){
        int[] arr = {1,9,3,6,7,0,12,2,4,8,5};
        firstBaseValue(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }






}