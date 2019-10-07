package tree;

import StackAndQueue.LinkQueue;
import StackAndQueue.LinkStack;


/**
 * @author liyingdan
 * @date 2019/9/26
 *
 * 二叉链式存储结构下二叉树类的描述
 */
public class BiTree {
    public BiTreeNode root; //树的根结点

    //为了实现线索化，需要创建指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre总是保留前一个结点
    public BiTreeNode pre = null;

    /**
     * 线索化二叉树
     *
     * T 为当前需要线索化的结点
     * */
    public void threadedNodes(BiTreeNode T){
        if(T == null)
            return;
        //1. 线索化左子树
        threadedNodes(T.lchild);

        //2. 线索化当前结点
        //处理当前结点的前驱结点
        if(T.lchild == null){
            T.lchild = pre;
            T.leftType = 1; //修改当前结点的左指针的类型，指向当前前驱
        }
        //处理当前结点的后继结点
        if(pre != null && pre.rchild == null){
            pre.rchild = T; //让前驱结点的右指针指向当前结点
            pre.rightType = 1;
        }
        //！！每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = T;


        //3. 线索化右子树
        threadedNodes(T.rchild);

    }

    //构造一棵空树
    public BiTree(){
        this.root = null;
    }

    //构造一棵树
    public BiTree(BiTreeNode root){
        this.root = root;
    }

    /**
     * 由先根遍历和中根遍历序列创建一棵二叉树的算法
     * */
    public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count){
        if(count > 0){ //先根和中根非空
            char r = preOrder.charAt(preIndex); //取先根遍历序列中的第一个结点作为根结点
            int i = 0;
            for(; i < count; i++) //寻找根结点在中根遍历序列中的位置
                if(r == inOrder.charAt(i + inIndex))
                    break;
            root = new BiTreeNode(r); //建立树的根结点
            root.lchild = new BiTree(preOrder, inOrder, preIndex + 1, inIndex, i).root; //建立树的左子树
            root.rchild = new BiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1).root; //建立树的右子树
        }
    }

    /**
     * 由标明空子树的先根遍历序列创建一棵二叉树,并返回其根结点
     * */
    private static int index = 0; //用于记录preStr的索引值
    public BiTree(String preStr){
        char c = preStr.charAt(index++); //取出字符串索引为index的字符，且index增1
        if(c != '#'){ //字符不为#
            root = new BiTreeNode(c); //建立树的根结点
            root.lchild = new BiTree(preStr).root; //建立树的左子树
            root.rchild = new BiTree(preStr).root; //建立树的右子树
        }else
            root = null;
    }

    /**
     * 先根遍历二叉树的递归算法
     * */
    public void preRootTraverse(BiTreeNode T){
        if(T != null){
            System.out.print(T.data); //访问根结点
            preRootTraverse(T.lchild); //先根遍历左子树
            preRootTraverse(T.rchild); //先根遍历右子树
        }
    }
    /**
     * 先根遍历二叉树的非递归算法
     * 1）创建一个栈对象，根结点入栈
     * 2）当栈为非空时，将栈顶结点弹出栈内并访问该结点。
     * 3）对当前访问结点的非空左孩子结点相继依次访问，并将当前访问结点的非空右孩子结点压入栈内。
     * 4）重复2）和3），直到栈为空
     * */
    public void preRootTraverse() throws Exception {
        BiTreeNode T = root;
        if(T != null){
            LinkStack S = new LinkStack();
            S.push(T);
            while (!S.isEmpty()){
                T = (BiTreeNode) S.pop();
                System.out.print(T.data);
                while (T != null){
                    if(T.lchild != null)
                        System.out.print(T.lchild.data);
                    if(T.rchild != null)
                        S.push(T.rchild);
                    T = T.lchild;
                }
            }
        }
    }
    /**
     * 中根遍历二叉树的递归算法
     * */
    public void inRootTraverse(BiTreeNode T){
        if(T != null){
            inRootTraverse(T.lchild);
            System.out.print(T.data);
            inRootTraverse(T.rchild);
        }
    }

    /**
     * 中根遍历二叉树的非递归算法
     *
     * 1）创建一个栈对象，根结点入栈
     * 2）若栈非空，则将栈顶结点的左孩子相继入栈
     * 3）栈顶结点出栈，并将该结点的右孩子入栈
     * 4）重复2）和3），直到栈为空
     * */
    public void inRootTraverse() throws Exception {
        BiTreeNode T = root;
        if(T != null){
            LinkStack S = new LinkStack();
            S.push(T); //根结点入栈
            while (!S.isEmpty()){
                while(S.peek() != null) //将栈顶结点的左结点相继入栈
                    S.push(((BiTreeNode)S.peek()).lchild);
                S.pop(); //空结点退栈
                if(!S.isEmpty()){
                    T = (BiTreeNode) S.pop();
                    System.out.print(T.data);
                    S.push(T.rchild); //结点的右孩子入栈
                }
            }
        }
    }
    /**
     * 后根遍历二叉树的递归算法
     * */
    public void postRootTraverse(BiTreeNode T){
        if(T != null){
            postRootTraverse(T.lchild);
            postRootTraverse(T.rchild);
            System.out.print(T.data);
        }
    }
    /**
     * 后根遍历二叉树的非递归算法
     *
     * (1)创建一个栈对象，根结点进栈，p赋初始值null。
     * (2)若栈非空，则栈顶结点的非空左孩子相继进栈。
     * (3)若栈非空,查看栈顶结点,若栈顶结点的右孩子为空,或者与p相等，则将栈顶结点弹出栈并访问它,
     * 同时使p指向该结点,并置flag 值为true;否则，将栈顶结点的右孩子压入栈,并置flag值为false。
     * (4)若flag值为true,则重复执行步骤(3);否则,重复执行步骤(2)和(3),直到栈为空为止。
     * */
    public void postRootTraverse() throws Exception {
        BiTreeNode T = root;
        if(T != null){
            LinkStack S = new LinkStack();
            S.push(T);
            Boolean flag; //访问标记
            BiTreeNode p = null; //p指向刚刚被访问过的结点
            while(!S.isEmpty()){
                while (S.peek() != null) //将栈顶结点的左结点相继入栈
                    S.push(((BiTreeNode)S.peek()).lchild);
                S.pop(); //空结点退栈
                while (!S.isEmpty()){
                    T = (BiTreeNode) S.peek(); //查看栈顶元素
                    if(T.rchild == null || T.rchild == p){
                        System.out.print(T.data);
                        S.pop();
                        p = T; //p指向刚刚被访问过的结点
                        flag = true; //设置访问标记
                    }else{
                        S.push(T.rchild);
                        flag = false; //设置未访问标记
                    }
                    if(!flag)
                        //当flag = true时，说明元素都已经入栈完毕，可以继续出栈
                        //当flag = false时，说明栈顶元素是刚刚进来的右结点，所以退出循环把该结点的左结点压入栈顶
                        break;
                }
            }
        }
    }

    /**
     * 层次遍历二叉树的算法（自左向右）
     * */
    public void levelRootTraverse() throws Exception {
        BiTreeNode T = root;
        if(T != null){
            LinkQueue L = new LinkQueue();
            L.offer(T);
            while (!L.isEmpty()){
                T = (BiTreeNode) L.poll();
                System.out.print(T.data);
                if(T.lchild != null)
                    L.offer(T.lchild);
                if(T.rchild != null)
                    L.offer(T.rchild);
            }
        }
    }

    public BiTreeNode getRoot(){
        return root;
    }
    public void setRoot(BiTreeNode root){
        this.root = root;
    }

    /**
     * 在二叉树中查找值为x的结点，若找到则返回该值，否则返回空值
     * */
    public BiTreeNode searchNode(BiTreeNode T, Object x){
        if(T != null){
            if(T.data.equals(x))
                return T;
            else {
                BiTreeNode lresult = searchNode(T.lchild, x);
                return lresult != null ? lresult : searchNode(T.rchild, x);
            }
        }
        return null;
    }

    /**
     * 统计二叉树中结点个数的算法
     * */
    public int countNode(BiTreeNode T){
        //采用先根遍历的方式对二叉树进行遍历，计算其结点的个数
        int count = 0;
        if(T != null){
            ++ count;
            count += countNode(T.lchild);
            count += countNode(T.rchild);
        }
        return count;
    }
    /**
     * 统计二叉树中结点个数的算法 -- 递归
     * */
    public int countNode1(BiTreeNode T){
        if(T == null)
            return 0;
        else
            return countNode1(T.lchild) + countNode1(T.rchild) + 1;
    }


    /**
     * 求二叉树的深度
     * */
    public int getDepth(BiTreeNode T){
        if(T != null){
            int lDepth = getDepth(T.lchild);
            int rDepth = getDepth(T.rchild);
            return 1 + (lDepth > rDepth ? lDepth : rDepth);
        }
        return 0;
    }
    /**
     * 求二叉树的深度 -- 递归
     * */
    public int getDepth1(BiTreeNode T){
        if(T == null)
            return 0;
        else if(T.lchild == null && T.rchild == null)
            return 1;
        else
            return 1 + (getDepth1(T.lchild) > getDepth1(T.rchild) ? getDepth1(T.lchild) : getDepth1(T.rchild));
    }

    /**
     * 判断两棵二叉树是否相等
     * */
    public boolean isEqual(BiTreeNode T1, BiTreeNode T2){
        if(T1 == null && T2 == null)
            return true;
        if(T1 != null && T2 != null)
            if(T1.data.equals( T2.data))
                if(isEqual(T1.lchild, T2.lchild));
                    if(isEqual(T1.rchild, T2.rchild))
                        return true;
        return false;
    }
    /**
     * 判断两棵二叉树是否相等 -- 递归模型
     * */
    public boolean isEqual1(BiTreeNode T1, BiTreeNode T2){
        if(T1 == null && T2 == null)
            return true;
        else if(T1 != null && T2 != null)
            return (T1.data.equals(T2.data)) && (isEqual1(T1.lchild, T2.lchild)) && (isEqual1(T1.rchild, T2.rchild));
        else
            return false;
    }

}
