package LinearList;

/**
 * @author liyingdan
 * @date 2019/9/3
 */

/**
 * 线性表的抽象接口
 * */
public interface Ilist {
    //将存在的线性表置成空表
    void clear();
    //判断线性表是否为空
    boolean isEmpty();
    //求线性表中的数据元素个数（求线性表的长度）
    int length();
    //读取并返回线性表中的第i个数据元素的值
    Object get(int i) throws Exception;
    //在线性表的第i个数据元素之前插入一个值为x的数据元素
    void insert(int i, Object x) throws Exception;
    //删除并返回线性表中第i个数据元素
    void remove(int i) throws Exception;
    //返回线性表中首次出现指定数据元素的位序号
    int indexOf(Object x);
    //输出线性表中各个元素的值
    void display();
}
