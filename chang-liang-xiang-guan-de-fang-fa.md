# 常量相关的方法

Java的**enum**有一个非常有趣的特性，即它允许程序员为**enum**实例编写方法，从而为每个**enum**实例赋予各自不同的行为。要实现常量相关的方法，你需要为**enum**定义一个或多个**abstract**方法，然后为每个enum实例实现该抽象方法。参考下面的例子：

```java
public enum ConstantSpecificMethod {
    DATE_TIME{
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH{
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION{
        String getInfo() {
            return System.getProperty("java.version");
        }
    }
    ;
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }
}
```

通过相应的enum实例，我们可以调用其上的方法。这通常也称为_**表驱动的代码**_\(table-driven code, 请注意它与前面提到的命令模式的相似之处\)。

在面向对象的程序设计中， 不同的行为与不同的类关联。而通过常量相关的方法，每个enum实例可以具备自己独特的行为，这似乎说明每个**enum**实例就像一个独特的类。在上面的例子中，enum实例似乎被当作其"超类"**ConstantSpecificMethod**来使用，在调用**getInfo\(\)**方法时，体现出多态的行为。

然而，enum实例与类的相似之处也仅限于此了。我们并不能真的将enum实例作为一个类型来使用：

```java
enum LikeClasses {
    WINKEN {
        void behavior() {
            System.out.println("Behavior1");
        }
    },
    BLINKEN{
        void behavior(){
            System.out.println("Behavior2");
        }
    },
    NOD{
        void behavior() {
            System.out.println("Behavior3");
        }
    };

    abstract void behavior();
}
/*
jiangxuedeMacBook-Pro:enum5 jianglei$ javap -c LikeClasses.class
Compiled from "NotClasses.java"
abstract class com.jianglei.enum5.LikeClasses extends java.lang.Enum<com.jianglei.enum5.LikeClasses> {
  public static final com.jianglei.enum5.LikeClasses WINKEN;

  public static final com.jianglei.enum5.LikeClasses BLINKEN;

  public static final com.jianglei.enum5.LikeClasses NOD;

*/
```

在方法**f1\(\)**中，编译器不允许我们将一个**enum**实例当作**class**类型。如果我们分析一下编译器生成的代码，就知道这种行为也是很正常的。因为每个**enum**元素都是一个**LinkClasses**类型的**static final**实例。

同时，由于它们是**static**实例，无法访问外部类的非**static**元素或方法，所以对于内部的enum的实例而言，其行为与一般的内部类并不相同。

再看一个更有趣的关于洗车的例子。每个顾客在洗车时，都有一个选择菜单，每个选择对应一个不同的动作。可以将一个常量相关的方法关联到一个选择上，再使用一个EnumSet来保存客户的选择：

```
public class CarWash {
    public enum Cycle {
        UNDERBODY{
            @Override
            void action() {
                System.out.println("Spraying the underbody");
            }
        },
        WHEELWASH{
            @Override
            void action() {
                System.out.println("Washing the wheels");
            }
        },
        PREWASH{
            @Override
            void action() {
                System.out.println("Loosening the dirt");
            }
        },
        BASIC{
            @Override
            void action() {
                System.out.println("The basic wash");
            }
        },
        HOTWAX{
            void action() {
                System.out.println("Applying hot wax");
            }
        },
        RINSE{
            @Override
            void action() {
                System.out.println("Rinsing");
            }
        },
        BLOWDRY{
            void action() {
                System.out.println("Blowing dry");
            }
        };

        abstract void action();
    }

    EnumSet<Cycle> cycles =
            EnumSet.of(Cycle.BASIC, Cycle.RINSE);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }
    public void washCar() {
        for (Cycle cycle : cycles) {
            cycle.action();
        }
    }
    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash wash = new CarWash();
        System.out.println(wash);
        wash.washCar();
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOTWAX);
        System.out.println(wash);
        wash.washCar();
    }
}
/*
[BASIC, RINSE]
The basic wash
Rinsing
[BASIC, HOTWAX, RINSE, BLOWDRY]
The basic wash
Applying hot wax
Rinsing
Blowing dry

*/
```
与使用匿名内部类相比较，定义常量相关方法语法更高效，简洁。
这个例子也展示了**EnumSet**了一些特性。因为它是一个集合，所以寻于同一个元素而言，只能出现一次，因此对同一个参数重复地调用**add()**方法会被忽略掉(这是正确的行为，因为一个bit位开关只能"打开"一次)。同样地，向**EnumSet**添加**enum**实例的顺序并不重要，因为其输出的次序决定于**enum**实例定义时的次序。
除实现abstract方法以外，程序员是否可以覆盖常量相关的方法呢？答案是肯定的，参考下面的程序：


```
public enum  OverrideConstantSpecific {
    NUT, BOLT,
    WASHER{
        void f() {
            System.out.println("Overriden method");
        }
    };

    void f() {
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            System.out.println(ocs + ": ");
            ocs.f();
        }
    }
}
```
虽然enum有些限制，但是一般而言，我们还是可以将其看作是类。





