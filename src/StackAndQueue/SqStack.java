package StackAndQueue;

import sun.reflect.annotation.ExceptionProxy;

/**
 * @author liyingdan
 * @date 2019/9/15
 */
public class SqStack implements IStack {
    private Object[] stackElem;
    private int top;

    public SqStack(int maxSize){
        top = 0;
        stackElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int length() {
        return top;
    }

    /**
     * 取栈顶元素并返回其值，若为空，则返回null
     * */
    @Override
    public Object peek() {
        if(!isEmpty())
            return stackElem[top - 1];
        else
            return null;
    }

    /**
     * 入栈
     * */
    @Override
    public void push(Object x) throws Exception {
        if(top == stackElem.length)
            throw new Exception("栈满！");
        else
            stackElem[top ++] = x;
    }

    /**
     * 出栈
     * */
    @Override
    public Object pop() {
        if(top == 0)
            return null;
        else
            return stackElem[--top];
    }

    @Override
    public void display() {
        for (int i = top - 1; i >= 0 ; i--) {
            System.out.print(stackElem[i].toString() + " ");
        }
    }
}
