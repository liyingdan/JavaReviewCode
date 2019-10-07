package LinearList;

import java.util.ListIterator;

/**
 * @author liyingdan
 * @date 2019/9/4
 */
public class Test {
    public static void main(String[] args) throws Exception {
        LinkList linkList = new LinkList(4); //input: 4 3 2 1
        linkList.display(); //1 2 3 4

        LinkList list2 = new LinkList();
        list2.alternate(linkList);
        list2.display(); //1 2 3 4

        LinkList list3 = new LinkList(4); //input: d c b a
        list3.display(); //a b c d
        list3.alternate(linkList);

        list3.display(); //a 1 b 2 c 3 d 4
        linkList.display(); // 1 b 2 c 3 d 4

        linkList.insert1(0, 100);
        linkList.display(); //null 1 b 2 c 3 d 4

    }
}
