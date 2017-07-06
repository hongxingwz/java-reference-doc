# 14.1 为什么需要RTTI

下面看一下我们已经很熟悉了的一个例子，它使用了多态的类层次结构。最通知的类型\(泛型）是基类**Shape**，而派生出的具体类有**Circle, Square和Triangle**

![](/assets/snapshot22.png)

这是一个典型的类层次结构图，基类位于顶部，派生类向下扩展。面向对象编程中基本的目的是：让代码只操纵对基类（这里是**Shape**\)的引用。这样，如果要添加一个新类（比如从**Shape**派生的**Rhomboid**\)来扩展程序，就不会影响到原来的代码。在这个例子的**Shape**接口中动态绑定了**draw\(\)**方法，目的就是让客户端程序员用泛化的Shape引用来调用**draw\(\)**。**draw\(\)**在所有派生类里都会被覆盖，并且由于它是被动态绑定的，所以使用是通过泛化的**Shape**引用来调用，也能产生正确行为。这就是多态。

因此，通常会创建一个具体的对象（Circle, Square, 或者Triangle）,把它向上转型成Shape（忽略对象的具体类型），并在后面的程序中使用匿名（译注：即不知道具体类型\)的Shape引用。

你可以像下面这样对Shape层次结构编码：

```
abstract class Shape{
    void draw(){
        System.out.println(this + ".draw()");
    }
    abstract public String toString();
}

class Circle extends Shape{
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape{
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape{
    @Override
    public String toString() {
        return "Triangle";
    }
}
public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
```



## 原理解释

基类中包含draw\(\)方法，它通过传递this参数给System.out.println\(\)，间接地使用toString\(\)打印类标识符（注意，toString\(\)被声明为abstract，以此强制继承者覆写该方法，并可以防止对无格式的Shpae的实例化）。如果某个对象出现在字符串表达式中（涉及 “＋” 和字符串对象的表达式），toString\(\)方法就会被自动调用，以生成表示该对象的String。每个派生类都要覆盖（从Object继承来的）toString\(\)方法，这样draw\(\)在不同情况下就打印出不同的消息（多态）。



在这个例子中，当把Shape对象放入List&lt;Shape&gt;的数组时会向上转型。但在向上转型为Shape的时候也丢失了Shape对象的具体类型。对于数组而言，它们只是Shpae类的对象。



当从数组中取出元素时，这种容器－－实际上它将所有的事物都当作Object持有－－会自动将结果转型回Shape。这是RTTI最基本的使用形式，因为在Java中，所有的类型转换都是在运行时运行正确性检查的。这也是RTTI名字的含义：在运行时，识别一个对象的类型。



在这个例子中，RTTI类型转换并不彻底：Object被转型为Shape，而不是转型为Circle， Square或者Triangle。这是因为目前我们只知道这个List&lt;Shape&gt;保存的都是Shape。在编译时，将由容器和Java的泛型系统来强制确保这一点；而在运行时，由类型转换操作来确保这一点。



接下来就是多态机制的事情了，Shape对象实际执行什么样的代码，是由引用所指向的具体对象Circle, Square或者Triangle而决定的。通常，也正是这样要求的；你希望大部分代码尽可能少地也解对象的_具本类型_，而是只与对象家族中的一个通知表示打交道（在这个例子中是Shape\)。这样代码会更容易写，更容易读，且更便于维护；设计也更容易实现，理解和改变。所以“多态”是面向对象编程的基本目标



但是，假如你碰到了一个特殊的编程问题－－如果能够知道某个泛化引用的确切类型，就可以使用最简单的方式去解决它，那么此时该怎么办呢？例如，假设我们允许用户将某一具体类型的几何形状全都变成某种特殊的颜色，以突出显示它们。通过这种方法，用户就能找出屏幕上所有被突出显示的三角形。或者，可能要用某个方法来旋转列出的所有图形，但想跳过圆形，因对对圆形进行旋转没有意义。使用RTTI，可以查询某个Shape引用所指向的对象的确切类型，然后选择或者剔除特例。

