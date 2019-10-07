package tree;

import java.util.BitSet;

/**
 * @author liyingdan
 * @date 2019/9/26
 *
 * 二叉链式存储结构的结点
 */
public class BiTreeNode {
    public Object data;
    public BiTreeNode lchild,rchild;

    //线索化二叉树
    //leftType如果是0，则表示指向左子树，是1指向前驱结点
    public int leftType, rightType;

    //构造一个结点
    public BiTreeNode(){
        this(null);
    }
    //构造一个左、右孩子域为空的二叉树
    public BiTreeNode(Object data){
        this(data,null,null);
    }
    //构造一棵数据域和孩子域都不为空的二叉树
    public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild){
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }
}
