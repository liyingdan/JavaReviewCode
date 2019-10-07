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
        String preOrder = "ABDEGCFH";
        String inOrder = "DBGEAFHC";
        BiTree biTree1 = new BiTree(preOrder, inOrder, 0, 0, preOrder.length());
//        System.out.print("后根遍历：");
//        biTree1.postRootTraverse(); // DGEBHFCA
//        System.out.println();

        /**
         * 首先由标明空子树的先根遍历序列创建一棵二叉树，然后标出该二叉树的先根、中根、后根遍历序列
         * */
//        String preStr = "AB##CD###";
//        BiTree T = new BiTree(preStr);
//        System.out.print("先根遍历：");
//        T.preRootTraverse(); //ABCD
//        System.out.println();
//        System.out.print("中根遍历：");
//        T.inRootTraverse(); //BADC
//        System.out.println();
//        System.out.print("后根遍历：");
//        T.postRootTraverse(); //BDCA

        Test test = new Test();
        BiTree biTree = test.creatBitree();
        BiTreeNode root = biTree.root; //取得树的根结点
//        //调试先根遍历
//        System.out.print("(递归)先根遍历为：");
//        biTree.preRootTraverse(root);
//        System.out.println();
//        System.out.print("(非递归)先根遍历为：");
//        biTree.preRootTraverse();
//        System.out.println();
//
//        //调试中根遍历
//        System.out.print("(递归)中根遍历为：");
//        biTree.inRootTraverse(root);
//        System.out.println();
//        System.out.print("(非递归)中根遍历为：");
//        biTree.inRootTraverse();
//        System.out.println();
//
//        //调试后根遍历
//        System.out.print("(递归)后根遍历为：");
//        biTree.postRootTraverse(root);
//        System.out.println();
//        System.out.print("(非递归)后根遍历为：");
//        biTree.postRootTraverse();
//        System.out.println();
//
//        //调试层次遍历
//        System.out.print("层次遍历为：");
//        biTree.levelRootTraverse();


        boolean equal = biTree.isEqual(biTree1.root, biTree.root);
        System.out.println(equal);


    }
    //构建如图2.3(a)的二叉树
    public BiTree creatBitree(){
        BiTreeNode d = new BiTreeNode('D');
        BiTreeNode g = new BiTreeNode('G');
        BiTreeNode h = new BiTreeNode('H');
        BiTreeNode e = new BiTreeNode('E',g,null);
        BiTreeNode b = new BiTreeNode('B',d,e);
        BiTreeNode f = new BiTreeNode('F',null,h);
        BiTreeNode c = new BiTreeNode('C',f,null);
        BiTreeNode a = new BiTreeNode('A',b,c);
        return new BiTree(a);
    }
}
