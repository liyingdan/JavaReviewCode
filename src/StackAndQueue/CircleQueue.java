package StackAndQueue;

import javafx.scene.shape.Circle;

/**
 * @author liyingdan
 * @date 2019/9/15
 *
 * 循环顺序队列
 */
public class CircleQueue implements IQueue {
    private Object[] queueElem;
    private int front;
    private int rear;

    public CircleQueue(int maxSize){
        front = rear = 0;
        queueElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        front = rear = 0;

    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int length() {
        return (rear - front + queueElem.length) % queueElem.length;
    }

    /**
     * 读取队首元素
     * */
    @Override
    public Object peek() {
        if(front == rear)
            return null;
        else
            return queueElem[front];
    }

    //入队  出队和入队的时间复杂度都为O(1)
    @Override
    public void offer(Object x) throws Exception {
        if((rear + 1) % queueElem.length == front)
            throw new Exception("队列已满");
        else{
            queueElem[rear] = x;
            rear = (rear + 1) % queueElem.length;
        }
    }

    //出队
    @Override
    public Object poll() {
        if(front == rear)
            return null;
        else {
            Object t = queueElem[front];
            front = (front + 1) % queueElem.length;
            return t;
        }
    }

    public void display(){
        if(!isEmpty()){
            for (int i = front; i != rear; i = (i + 1)% queueElem.length)
                System.out.print(queueElem[i].toString()+" ");
        }else
            System.out.println("此队列为空");

    }
}
