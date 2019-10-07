package LinearList;

import java.util.Scanner;

/**
 * @author liyingdan
 * @date 2019/9/4
 *
 * 双向循环链表
 */
public class DulLinkList implements Ilist {
    public DulNode head;
    /**
     * 构造只含一个头结点的双向循环链表
     * */
    public DulLinkList(){
        head = new DulNode();
        head.prior = head;
        head.next = head;
    }
    /**
     * 从表尾到表头逆向创建双向循环链表
     * */
    public DulLinkList(int n) throws Exception {
        this(); //上面的构造函数
        Scanner s = new Scanner(System.in);
        for (int j = 0; j < n; j++) {
            insert(j, s.next()); //顺序创建
//            insert(0, s.next()); //逆向创建
        }
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public Object get(int i) throws Exception {
        return null;
    }

    /**
     * 带头结点的双向循环链表中的插入操作
     * */
    @Override
    public void insert(int i, Object x) throws Exception {
        DulNode p = head.next;
        int j = 0;
        while (!p.equals(head) && j < i){
            p = p.next;
            ++ j;
        }
        if(j != i && !p.equals(head)){
            throw new Exception("插入位置不正确！");
        }
        DulNode s = new DulNode(x);
        p.prior.next = s;
        s.prior = p.prior;
        s.next = p;
        p.prior = s;
    }

    /**
     * 在带头结点的双向循环链表中的删除操作 -------i= 0，head.next = head的情况呢？
     * */
    @Override
    public void remove(int i) throws Exception {
        DulNode p = head.next;
        int j = 0;
        while (!p.equals(head) && j < i){
            p = p.next;
            ++ j;
        }
        if(j != i){
            throw new Exception("删除位置不合法");
        }
        p.prior.next = p.next;
        p.next.prior = p.prior;

    }

    @Override
    public int indexOf(Object x) {
        return 0;
    }

    @Override
    public void display() {
        DulNode node = head.next;
        while (!node.equals(head)){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();

    }
}
