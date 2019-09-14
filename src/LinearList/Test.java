package LinearList;

/**
 * @author liyingdan
 * @date 2019/9/4
 */
public class Test {
    public static void main(String[] args) throws Exception {
        /*DulLinkList dulLinkList = new DulLinkList(5);
        dulLinkList.display();

        dulLinkList.insert(0,"a");
        dulLinkList.display();*/

        LinkList linkList = new LinkList(5);
        linkList.display();
        linkList.reserve();
        linkList.display();


    }
}
