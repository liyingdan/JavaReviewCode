package hashtabledemo;

import java.util.Currency;
import java.util.Scanner;

/**
 * @author liyingdan
 * @date 2019/10/6
 */
public class HashTableDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("delete: 删除雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入id");
                    int idd = scanner.nextInt();
                    hashTab.findEmpById(idd);
                    break;
                case "delete":
                    System.out.println("输入id");
                    int iddd = scanner.nextInt();
                    hashTab.deleteEmpById(iddd);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }

}

//创建HashTab，管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size; //表示共有多少条链表

    //构造器
    public HashTab(int size){
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        //这时不要忘了分别初始化每个链表!!!!
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    //添加雇员
    public void add(Emp emp){
        //根据员工的id，得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }
    //遍历hashtab
    public void list(){
        for (int i = 0; i < size; i++)
            empLinkedListArray[i].list(i);
    }

    //根据输入的id查找雇员
    public void findEmpById(int id){
        int no = hashFun(id);
        Emp empById = empLinkedListArray[no].findEmpById(id);
        if(empById != null)
            System.out.printf("在第%d条链表中找到 雇员id = %d",(no + 1),id);
        else
            System.out.println("在哈希表中，没有找到该雇员哦");
    }

    //根据id删除雇员
    public void deleteEmpById(int id){
        int no = hashFun(id);
        empLinkedListArray[no].deleteEmpId(id);
    }

    //编写散列函数
    public int hashFun(int id){
        return id % size;
    }
}

//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList，表示链表
class EmpLinkedList{
    //头指针，指向第一个Emp
    private  Emp head;

    //添加雇员到链表
    public void add(Emp emp){
        if(head == null){
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while (true){
            if(curEmp.next == null)
                break;
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    //遍历
    public void list(int no){
        if(head == null){
            System.out.println("第"+ (no + 1) +"条链表为空");
            return;
        }
        System.out.print("第"+ (no + 1) +"条链表的信息为：");
        Emp curEmp = head;
        while (true) {
            System.out.printf(" => id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next == null)
                break;
            curEmp = curEmp.next;
        }
        System.out.println();

    }

    //根据id查询雇员
    public Emp findEmpById(int id){
        //判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if(curEmp.id == id)
                break;
            if(curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    //根据id删除雇员
    public void deleteEmpId(int id){
        if(head == null) {
            System.out.println("删除的id不存在");
            return;
        }
        if(head.id == id) //头结点为删除结点
            head = head.next;

        Emp curEmp = head;
        while (curEmp.next != null && curEmp.next.id != id)
            curEmp = curEmp.next;
        if(curEmp.next == null) {
            System.out.println("删除的id不存在");
            return;
        }
        curEmp.next = curEmp.next.next;
        System.out.println("删除成功");

    }

}












