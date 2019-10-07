package tree;

/**
 * @author liyingdan
 * @date 2019/10/7
 *
 * 给你一个数组 {1,2,3,4,5,6,7}，要求以二叉树前序遍历的方式进行遍历
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        preOrder(arr,0); //1 2 4 8 9 5 3 6 7
        System.out.println();
        inOrder(arr,0); //8 4 9 2 5 1 6 3 7
        System.out.println();
        postOrder(arr,0); //8 9 4 5 2 6 7 3 1

    }
    //前序遍历
    public static void preOrder(int[] arr,int index) {
        if (arr == null || arr.length == 0)
            System.out.print("数组为空，不能按照二叉树前序遍历");
        System.out.print(arr[index]+" ");
        if ((index * 2 + 1) < arr.length)
            preOrder(arr,index * 2 + 1);
        if ((index * 2 + 2) < arr.length)
            preOrder(arr,index * 2 + 2);
    }

    //中序遍历
    public static void inOrder(int[] arr,int index) {
        if (arr == null || arr.length == 0)
            System.out.print("数组为空，不能按照二叉树中序遍历");
        if ((index * 2 + 1) < arr.length)
            inOrder(arr,index * 2 + 1);
        System.out.print(arr[index]+" ");
        if ((index * 2 + 2) < arr.length)
            inOrder(arr,index * 2 + 2);
    }

    //后序遍历
    public static void postOrder(int[] arr,int index) {
        if (arr == null || arr.length == 0)
            System.out.print("数组为空，不能按照二叉树中序遍历");
        if ((index * 2 + 1) < arr.length)
            postOrder(arr,index * 2 + 1);
        if ((index * 2 + 2) < arr.length)
            postOrder(arr,index * 2 + 2);
        System.out.print(arr[index]+" ");
    }

}



