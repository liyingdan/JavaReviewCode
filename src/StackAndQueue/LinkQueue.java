package StackAndQueue;

import LinearList.Node;

/**
 * @author liyingdan
 * @date 2019/9/17
 *
 * 链队列
 */
public class LinkQueue implements IQueue {
    private Node front;
    private Node rear;

    public LinkQueue(){
        front = rear = null;
    }

    @Override
    public void clear() {
        front = rear = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int length() {
        Node p = front;
        int length = 0;
        while (p != null){
            p = p.next;
            ++ length;
        }
        return length;
    }

    @Override
    public Object peek() {
        if(front != null)
            return front.data;
        else
            return null;
    }

    /**
     * 入队
     * */
    @Override
    public void offer(Object x) throws Exception {
        Node s = new Node(x);
        if(front != null){
            rear.next = s;
            rear = s;
        }else
            front = rear = s;

    }

    /**
     * 出队
     * */
    @Override
    public Object poll() {
        if(front != null){
            Node p = front;
            front = front.next;
            if(p == rear)
                rear = null;
            return p.data;
        }else
            return null;
    }
}
