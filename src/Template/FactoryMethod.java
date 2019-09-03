package Template;
/**
工厂方法模式
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Factory circlefactory = new CircleFactory();
        Shape circle = circlefactory.getShape();
        circle.draw();
    }
}

/*增加一个工厂接口*/
interface Factory{
    public Shape getShape();
}
/*增加相关工厂类*/
//圆形工厂类
class CircleFactory implements Factory{
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
//长方形工厂类
class RectangleFactory implements Factory{
    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
//圆形工厂类
class SquareFactory implements Factory{
    @Override
    public Shape getShape() {
        return new Square();
    }
}


