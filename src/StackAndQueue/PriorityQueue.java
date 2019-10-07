package StackAndQueue;

import LinearList.Node;

/**
 * @author liyingdan
 * @date 2019/9/22
 */
public class PriorityQueue implements IQueue {
    private Node front;
    private Node rear;

    public PriorityQueue(){
        front = rear = null;
    }

    @Override
    public void clear() {
        front = rear = null;

    }

    @Override
    public boolean isEmpty() {
        return front == rear;
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

    /**
     * 读取队首元素
     * */
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
        PriorityData pn = (PriorityData) x;
        Node s = new Node(pn);
        if(front == null)
            front = rear = s;
        else {
            Node p = front, q = front;
            while (p != null && pn.priority >= ((PriorityData)p.data).priority){
                q = p;
                p = p.next;
            }
            if(p == null){ //p为空，表示遍历到了队列尾部
                rear.next = s;
                rear = s;
            }else if(p == front){ //p的优先级大于队首结点的优先级
                s.next = front;
                front = s;
            }else {
                q.next = s;
                s.next = p;
            }
        }
    }

    /**
     * 出队
     * */
    @Override
    public Object poll() {
        if(front != null){
            Node p = front;
            front = front.next;
            return p.data;
        }else
            return null;
    }

    public void display(){
        if(!isEmpty()){
            Node p = front;
            while (p != rear.next){
                PriorityData q = (PriorityData) p.data;
                System.out.println(q.elem + " "+q.priority);
                p = p.next;
            }
        }else
            System.out.println("此队列为空");
    }
}
