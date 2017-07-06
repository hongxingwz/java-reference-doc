# Class对象

要理解RTTI在Java中的工作原理，首先必须知道类型信息在运行时是如何表示的。这项工作是由称为Class对象的特殊对象完成的，它包含了与类有关的信息。事实上，Class对象就是用来创建类的所有的“常规”对象的。Java使用Class对象来执行其RTTI，即使你正在执行的是类似转型这样的操作。Class类还拥有大量的使用RTTI的其他方式。

类是程序的一部分，每个类都有一个Class对象。换言之，每当编写并且编译了一个新类，就会生产一个Class对象（更恰当地说，是被保存在一个同名的.class文件中）。为了生成这个类的对象，运行这个程序的Java虚拟机（JVM）将使用被称为“类加载器”的子系统。

类加载器子系统实际上可以包含一条类加载器链，但是只有**一个原生类加载器**，它是JVM实现的一部分。原生类加载器加载的是所谓的**可信类**，包括Java API类，它们通常是从本地盘加载的。在这条链中，通常不需要添加额外的类加载器，但是如果你有特殊需要（例如以某种特殊的方式加载类，以支持Web服务器应用，或者在网络中下载类），那么你有一种方式可以挂接额外的类加载器。

所有的类都是在对其第一次使用时，动态加载到JVM中的。当程序创建第一个对类的静态成员的引用时，就会加载这个类。这个构造器也是类的静态方法，即使在构造器之前并没有使用**static关键字。**因此，使用**new**操作符创建类的新对象也会被当作对类的静态成员的引用。

因此，Java程序在它开始运行之前并非被完全加载，其各个部分是在必需时才加载的。这一点与许多传统语言都不同。动态加载使能的行为，在诸如C＋＋这样的静态加载语言中是很难或者根本不可能复制的。

类加载器首先检查这个类的**Class**对象是否已经加载。如果尚未加载，默认的类加载器就会根据类名查找**.class**文件（例如，某个附加类加载器可能会在数据库中查找字节码）。在这个类的字节码被加载时，它们会接受验证，以确保其没有被破坏，并且不包含不良Java代码（这是Java中用于安全防范目的的措施之一）。

一旦某个类的**Class**对象被载入内存，它就被用来创建这个类的所有对象。下面的示范程序可以证明这一点：

```java
class Candy{
    static {
        System.out.println("Loading Candy");
    }
}

class Gum{
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}
public class SweetShop {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("inside main");
        new Candy();

        System.out.println("After creating Candy");
        Class<?> aClass = Class.forName("com.jianglei.typeinfo.Gum");

        System.out.println("After Class.forName(\"com.jianglei.typeinfo.Gum \") ");
        new Cookie();

        new Candy();
        new Gum();
        new Cookie();
    }

}
/*Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("com.jianglei.typeinfo.Gum ") 
Loading Cookie
```

这里的每个类Candy, Gum, Cookie, 都有一个**static**子句，该子句在类第一次被加载时执行。这时会有相应的信息打印出来，告诉我们这个类什么时候被加载了。在**main\(\)**中，创建对象的代码被置于打印语句之间，以帮助我们判断加载的时间点。



从输出中可以看到，Class对象仅在需要的时候才被加载，static初始化是在类加载时进行的。特别有趣的一行是：

```
Class.forName("Gum");
```

这个方法是Class类（所有Class对象都属于这个类）的一个**static**成员。Class对象就和其他对象一样，我们可以获取并操作它的引用（这也就是类加载器的工作）。**forName\(\)**是取得Class对象引用的一种方法。它是用一个包含目标类的文本名的**String**作为输入参数，返回的是一个**Class**对象的引用，上面的代码忽略了返回值。对**forName\(\)**的调用是为了它产生的“副作用”：如果类**Gum**还没有被加载就加载它。在加载过程中，**Gum**的**static**子句被执行。

在前面的例子里，如果**Class.forName\(\)**找不到你要加载的类，它会抛出异常**ClassNotFoundException**。这里我们只需简单报告问题，但在更严密的程序里，可能要在异常处理程序中解决这个问题。



无论何里，只要你想在运行时使用类型信息，就必须首先获得恰当的**Class**对象的引用。**Class.forName\(\)**就是实现此功能的便捷途径，因为你不需要为了获得**Class**引用而持有该类型对象。但是，如果你已经拥有了一个感兴趣的类型的对象，那就可以通过调用**getClass\(\)**方法来获取**Class**引用了，这个方法属于根类**Object**的一部分，它将返回表示该对象的实际类型的**Class**引用。**Class**包含很多有用的方法，下面是其中的一部分:



