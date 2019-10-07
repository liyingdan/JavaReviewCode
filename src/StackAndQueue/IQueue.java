package StackAndQueue;

/**
 * @author liyingdan
 * @date 2019/9/15
 */
public interface IQueue {
    void clear();
    boolean isEmpty();
    int length();
    //取队首元素
    Object peek();
    //入队
    void offer(Object x) throws Exception;
    //出队
    Object poll();
}
