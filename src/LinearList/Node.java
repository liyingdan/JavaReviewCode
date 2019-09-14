package LinearList;

/**
 * @author liyingdan
 * @date 2019/9/3
 */
public class Node {
    public Object data;
    public Node next;
    public Node(){
        this(null,null);
    }
    public Node(Object data){
        this(data,null);
    }
    public Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }
}
