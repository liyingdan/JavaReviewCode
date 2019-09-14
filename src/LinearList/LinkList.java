package LinearList;

import org.w3c.dom.NodeList;

import java.util.Scanner;

/**
 * @author liyingdan
 * @date 2019/9/3
 */
/**
 * 单链表
 * */
public class LinkList implements Ilist {
    public Node head; //单链表的头指针

    public LinkList(){ //单链表的构造函数
        head = new Node(); //初始化头结点
    }

    /**
     * 构造一个长度为n的单链表
     * */
    public LinkList(int n) throws Exception {
        this(); //初始化头结点
        Scanner s = new Scanner(System.in);
        for (int j = 0; j < n; j++) {
            //头插法
            insert(0,s.next());
            //尾插法
//            insert(length(),s.next());
        }
    }


    @Override
    public void clear() {
        head.data = null;
        head.next = null;

    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public int length() {
        Node p = head.next;
        int length = 0;
        if(p != null){
            p = p.next;
            ++ length;
        }
        return length;
    }

    /**
     * 读取带头结点的单链表中的第i个结点
     * */
    @Override
    public Object get(int i) throws Exception {
        Node p = head.next;
        int j = 0;
        while (p != null && j< i){
            p = p.next;
            ++ j;
        }
        if(j > i || p == null) {
            throw new Exception("元素不存在");
        }
        return p.data;
    }

    /**
     * 在带头结点的单链表中的第i个结点之前插入一个值为x的新结点
     * */
    @Override
    public void insert(int i, Object x) throws Exception {
        Node p = head;
        int j = -1;
        while (p != null && j < i-1){
            p = p.next;
            ++ j;
        }
        if(j > i-1 || p == null){
            throw new Exception("插入位置不合法");
        }
        Node s = new Node(x);
        s.next = p.next;
        p.next = s;

    }
    /**
     * 在不带头结点的单链表中的第i个结点之前插入一个值为x的新结点
     * */
    public void insert1(int i, Object x) throws Exception{
        Node p = head;
        int j = 0;
        while (p != null && j < i-1){
            p = p.next;
            ++ j;
        }
        if(j > i || p == null){
            throw new Exception("插入位置不合法");
        }
        Node s = new Node(x);
        if(i == 0){
            s.next = head;
            head = s;
        }else {
            s.next = p.next;
            p.next = s;
        }
    }


    /**
     * 删除带头结点的单链表中的第i个结点
     * */
    @Override
    public void remove(int i) throws Exception {
        Node p = head;
        int j = -1;
        while (p.next != null && j < i-1){
            p = p.next;
            ++ j;
        }
        if(j > i-1 || p.next == null){
            throw new Exception("删除位置不合法");
        }
        p.next = p.next.next;

    }
    /**
     * 在带头结点的单链表删除数据域值为x的结点
     * */
    public void remove1(Object x) throws Exception {
        Node p = head;
        while (p.next != null && p.next.data != x){
            p = p.next;
        }
        if(p.next == null){
            throw new Exception("删除结点不存在");
        }
        p.next = p.next.next;

    }


    /**
     * 在带头结点的单链表中查找值为x的结点
     * */
    @Override
    public int indexOf(Object x) {
        Node p = head.next;
        int j = 0;
        while (p != null && !p.data.equals(x)){
            p = p.next;
            ++ j;
        }
        if(p != null)
            return j;
        else
            return -1;
    }

    @Override
    public void display() {
        Node node = head.next;
        while (node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    /**
    * 逆置单链表
    * */
    public void reserve(){
        Node p = head.next;
        Node q;
        head.next = null;
        while (p != null){
            q = p.next;
            p.next = head.next; //将p节点插入到链表的表头
            head.next = p;
            p = q;
        }
    }

    /**
     * 把单链表减半（留1 3 5 ...结点）
     * 主单链表:1,2,3,4,5,6,7,8 ---> 1,3,5,7
     * */
    public void half(){
        Node p = head.next;
        while (p.next != null){
            if(p.next.next != null){
                p.next = p.next.next;
                p = p.next;
            }else {
                p.next = null;
            }
        }
    }

    /**
     * 把单链表分成两个链表，角标双数放一个表X，角标单数放一个表Y。（从0开始计数）
     * 主单链表:1,2,3,4,5,6,7,8
     * X:1,3,5,7
     * Y:2,4,6,8
     * */
    public void split(LinkList X, LinkList Y){
        Node p = head.next;
        Node x = X.head;
        Node y = Y.head;
        //此时X就是整个主链表，把角标为单数的结点干掉就行
        x = p;
        //Y链表是从角标第一个开始的主链表，把角标为双数的结点干掉就行
        y = p.next;
        //当结点x和y的后第三位都不为空时，去掉第二个结点（x为空为y一定为空）
        while (x.next.next.next != null && y.next.next.next != null){
            x.next.next = x.next.next.next;
            y.next.next = y.next.next.next;
            x = x.next;
            y = y.next;
        }
        //当主链表的结点数为单数时，y为空，x不为空，当主链表的结点数为双数时，都为空
        //x.next.next有区别，y.next.next都为null;
        if(x.next.next.next != null)
            x.next.next = x.next.next.next;
        else
            x.next.next = null;
        y.next.next = null;
    }

    /**
     * 单链表的交替。把主单链表和单链表N，交替取数，为一个新单链表
     * A(主)：1,2,3,4,5  N：a,b,c,d,e ---> A:1,a,2,b,3,c,4,d,5,e
     * */
    //???  p为空时？
    public void alternate(LinkList N){
        Node p = head.next;
        Node n = N.head.next;
        while(p.next != null){
            Node q = p.next;
            Node m = n.next;
            p.next = n;
            n.next = q;
            p = q;
            n = m;
        }
        p.next = n;
    }

}
