package LinearList;

import java.util.zip.CRC32;

/**
 * @author liyingdan
 * @date 2019/9/3
 */
public class SqList implements Ilist {
    private Object[] listElem; //线性表存储空间
    private int curLen; //线性表的当前长度

    public SqList(int maxSize){
        curLen = 0;
        listElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        curLen = 0;
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public int length() {
        return curLen;
    }

    /**
     * 读取并返回线性表中的第i个数据元素的值
     * */
    @Override
    public Object get(int i) throws Exception {
        if(i < 0 || i > curLen-1 ){
            throw new Exception("该元素不存在");
        }
        return listElem[i];
    }

    /**
     * 在线性表的第i个数据元素之前插入一个值为x的数据元素
     * */
    @Override
    public void insert(int i, Object x) throws Exception {
        if(curLen == listElem.length)
            throw new Exception("顺序表已满");
        if(i < 0 || i > curLen)
            throw new Exception("插入位置不正确");

        for(int j = curLen; j > i; j--)
            listElem[j] = listElem[j-1];

        listElem[i] = x;
        curLen ++;
    }

    /**
     * 删除并返回线性表中第i个数据元素
     * */
    @Override
    public void remove(int i) throws Exception {
        if(i < 0 || i > curLen-1)
            throw new Exception("删除位置不正确");
        for (int j = i; j< curLen-1; j++)
            listElem[j] = listElem[j+1];
        curLen --;
    }

    /**
     * 返回线性表中首次出现指定数据元素的位序号
     * */
    @Override
    public int indexOf(Object x) {
        int j = 0;
        while (j < curLen && !listElem[j].equals(x)) //依次比较
            j++;
        if(j < curLen)
            return j;
        else
            return -1;
    }

    @Override
    public void display() {
        for (int j = 0; j < curLen; j++) {
            System.out.println(listElem[j]);
        }

    }
}
