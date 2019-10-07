package LinearList;

/**
 * @author liyingdan
 * @date 2019/9/15
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        DulLinkList dulLinkList = new DulLinkList(5); //input: 1 2 3 4 5
        dulLinkList.display(); //1 2 3 4 5

        dulLinkList.insert(10, 100);
        dulLinkList.display(); //1 2 3 4 5 100

        DulLinkList dulLinkList1 = new DulLinkList();
        dulLinkList1.display(); //     (空的)
        dulLinkList1.insert(-1 ,222);
        dulLinkList1.display(); //222

        DulLinkList dulLinkList2 = new DulLinkList();
        dulLinkList2.display(); //     (空的)
        dulLinkList2.insert(10 ,555);
        dulLinkList2.display();//555

        DulLinkList dulLinkList3 = new DulLinkList();
        dulLinkList3.remove(0); //不会没有异常
        dulLinkList3.display();

    }
}
