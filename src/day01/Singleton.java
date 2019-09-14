package day01;

/**
 * 懒汉式----双重检查加锁（double-checked locking）
 * */
//public class Singleton {
//    //volatile保证，当uniqueInstance变量被初始化成Singleton实例时，多个线程可以正确处理uniqueInstance变量
//    private volatile static Singleton uniqueInstance;
//    private Singleton() {
//    }
//    public static Singleton getInstance() {
//        //检查实例，如果不存在，就进入同步代码块
//        if (uniqueInstance == null) {
//            //只有第一次才彻底执行这里的代码
//            synchronized(Singleton.class) {
//                //进入同步代码块后，再检查一次，如果仍是null，才创建实例
//                if (uniqueInstance == null) {
//                    uniqueInstance = new Singleton();
//                }
//            }
//        }
//        return uniqueInstance;
//    }
//}

/**
 * 懒汉式（登记式/静态内部类方式）
   静态内部实现的单例是懒加载的且线程安全。
  只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，
  从而实例化 instance（只有第一次使用这个单例的实例的时候才加载，同时不会有线程安全问题）。
 */
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}


/*public class Singleton{}
     //饿汉式
    //1.私有化构造器，使得在类的外部不能够调用此构造器
    private Singleton() {
    }
    //2.在类的内部创建一个类的实例，私有化此对象，通过公共的方法来调用
    private static Singleton instance = new Singleton();

    //3.公共方法设置为static，只能通过类来调用
    public static Singleton getInstance() {
        return instance;
    }
}*/
