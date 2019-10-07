package tree;

/**
 * @author liyingdan
 * @date 2019/9/28
 */
public class Test {
    public static void main(String[] args) throws Exception {
        /**
         * 由先根和中根遍历序列建立一棵二叉树，并输出该二叉树的后根遍历序列
         * */
//        String preOrder = "ABDEGCFH";
//        String inOrder = "DBGEAFHC";
//        BiTree biTree1 = new BiTree(preOrder, inOrder, 0, 0, preOrder.length());


        BiTreeNode node8 = new BiTreeNode(8);
        BiTreeNode node10 = new BiTreeNode(10);
        BiTreeNode node14 = new BiTreeNode(14);
        BiTreeNode node3 = new BiTreeNode(3,node8,node10);
        BiTreeNode node6 = new BiTreeNode(6,node14,null);
        BiTreeNode node1 = new BiTreeNode(1,node3,node6);
        BiTree biTree = new BiTree(node1);
//        biTree.preRootTraverse(note1);
        //测试中序线索化
        biTree.threadedNodes();
        //测试：以10号结点测试
        BiTreeNode leftNode = node10.lchild;
        System.out.println("10号结点的前驱是："+leftNode.data);//3
        BiTreeNode rightNode = node10.rchild;
        System.out.println("10号结点的后继是："+rightNode.data);//1

        //线索化二叉树的遍历
        biTree.threadedList(); //8 3 10 1 14 6





    }

}
