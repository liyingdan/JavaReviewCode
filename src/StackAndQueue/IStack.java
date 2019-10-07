package StackAndQueue;

/**
 * @author liyingdan
 * @date 2019/9/15
 */
public interface IStack {
    void clear();
    boolean isEmpty();
    int length();
    //取栈顶元素并返回其值，若为空，则返回null
    Object peek();
    //入栈
    void push(Object x) throws Exception;
    //出栈
    Object pop();
    void display();
}
