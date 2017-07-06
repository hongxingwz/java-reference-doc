# 类字面常量

Java还提供了另一种方法来生成对Class对象的引用，好使用_类字面常量。_对上述程序来说就像下面这样：

```
FancyToy.class
```

这样做不仅简单，而且更安全，因为它在编译时就会受到检查（因此不需要置于try语句块中）。并且它根除了对**forName\(\)**方法的调用，所以也更高效。

**类字面常量不仅可以用于普通的类，也可以用于接口，数组及基本数据类型**。另外，对于基本数据数据类型的包装器类，还有一个标准字段TYPE。TYPE字段是一个引用，指向对就的基本数据类型的Class对象，如下所示：

| boolean.class | Boolean.TYPE |
| :--- | :--- |
| char.class | Character.TYPE |
| short.class | Short.TYPE |
| int.class | Integer.TYPE |
| long.class | Long.TYPE |
| float.class | Float.TYPE |
| double.class | Double.TYPE |
| void.class | Void.TYPE |

我建议使用“**.class**”的形式，以保持与普通类的一致性。

**注意，有一点很有趣，当使用**“**.class**”来创建对**Class**对象的引用时，不会自动地初始化该**Class**对象。为了使用类而做的准备工作实际包含三个步骤：

* **加载**，这是由类加载器执行的。该步骤将查询字节码（通常在classpath所指定的路径中查找，但这并非是必需的），并从这些字节码中创建一个**Class对象。**
* **链接**。在链接阶段将验证类中的字节码，为静态域分配存储空间，并且如果必须的话，将解析这个类创建的对其他类的所有引用。
* **初始化**。如果该类具有超类，则对其初始化，执行静态初始化器和静态初始化块。



初始化被延迟到了对静态方法（构造器隐式地是静态的）或者非常数静态域进行首次引用时才执行：

```java
class Initable{
    public static final int staticFinal = 47;
    public static final int staticFinal2 =
            ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initabl2{
    public static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initabl3{
    public static int staticNonFinal = 74;

    static {
        System.out.println("Initailizing Initable3");
    }
}
public class ClassInitialization {
    public static Random rand = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws ClassNotFoundException {
        Class<Initable> initableClass = Initable.class;
        System.out.println("After creating Initable ref");
        //Does not trigger initialization;
        System.out.println(Initable.staticFinal);
        //Does trigger initialization;
        System.out.println(Initable.staticFinal2);

        //Does trigger initialization;
        System.out.println(Initabl2.staticNonFinal);

        Class<?> initabl3 = Class.forName("com.jianglei.typeinfo.Initabl3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initabl3.staticNonFinal);
    }
}
```

初始化有效地实现了尽可能的“惰性”。从对**initable**引用的创建中可以看到，仅使用**.class**语法来获得对类的引用不会引发初始化。但是，为了产生**Class**引用,**Class.forName\(\)**立即就进行了初始化**，**就像在对**initable3**引用的创建中所看到的**。**

如果一个**static final**值是“编译期常量”，就像**Initable.staticFinal**那样，那么这个值不需要对**Initable**类进行初始化就可以被读取。但是，如果只是将一个域设置为**static**和**final**的，还不足以确保这种行为，例如，对**Initable.staticFinal2**的访问将强制进行类的初始化，因为它不是一个编译期常量。

如果一个**static**域不是**final**的，那么在对它访问时，总是要求在它被读取之前，要先进行链接（为这个域分配存储空间）和初始化（初始化该存储空间），就像在对**Initable2.staticNonFinal**的访问中所看到的那样。





