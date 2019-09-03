package Template;

import org.junit.Test;
/*简单工厂模式*/
public class SimpleTemplate {
    @Test
    public void test(){
        // 获取 Circle 的对象，并调用它的 draw 方法
        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();

        // 获取 Rectangle 的对象，并调用它的 draw 方法
        Shape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        // 获取 Square 的对象，并调用它的 draw 方法
        Shape square = ShapeFactory.getShape("SQUARE");
        square.draw();
    }
}


/*创建Shape接口*/
interface Shape {
    void draw();
}

/*创建实现该接口的具体图形类*/
//圆型
class Circle implements Shape {
    public Circle() {
        System.out.println("Circle");
    }
    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}
//长方形
class Rectangle implements Shape {
    public Rectangle() {
        System.out.println("Rectangle");
    }
    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }
}
//正方形
class Square implements Shape {
    public Square() {
        System.out.println("Square");
    }
    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}


/*创建工厂类：*/

class ShapeFactory {
    // 使用 getShape 方法获取形状类型的对象
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

/**
 * 利用反射解决简单工厂每次增加新了产品类都要修改产品工厂的弊端

 */

class ShapeFactory2 {
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;

        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
