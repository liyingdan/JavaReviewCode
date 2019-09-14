package LinearList;

/**
 * @author liyingdan
 * @date 2019/9/4
 */
/**
 * 双向链表的结点类
 * */
public class DulNode {
    public Object data;
    public DulNode prior;
    public DulNode next;
    public DulNode(){
        this(null);
    }
    public DulNode(Object data){
        this.data = data;
        this.prior = null;
        this.next = null;
    }
}
