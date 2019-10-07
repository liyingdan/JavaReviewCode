package StackAndQueue;

import LinearList.Node;

/**
 * @author liyingdan
 * @date 2019/9/15
 */
public class LinkStack implements IStack {
    private Node top;

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 求栈长度
     * */
    @Override
    public int length() {
        Node p = top;
        int length = 0;
        while (p != null){
            p = p.next;
            ++ length;
        }
        return length;
    }

    /**
     * 取栈顶元素
     * */
    @Override
    public Object peek() {
        if(top != null){
            return top.data;
        }else
            return null;
    }

    /**
     * 入栈
     * */
    @Override
    public void push(Object x) throws Exception {
        Node s = new Node(x);
        s.next = top;
        top = s;
    }

    /**
     * 出栈
     * */
    @Override
    public Object pop() {
        if(top == null){
            return null;
        }else {
            Node p = top;
            top = top.next;
            return p.data;
        }
    }

    @Override
    public void display() {
        Node p = top;
        while (p != null){
            System.out.print(p.data.toString()+" ");
            p = p.next;
        }
    }
}
