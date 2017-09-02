# 基本enum特性

我们已经在以前看到，调用enum的values\(\)方法，可以遍历enum实例。values\(\)方法返回enum实例的数组，而且该数组中的元素严格保持其在enum中声明时的顺序，因此你可以在循环中使用values\(\)返回的数组。

创建enum时，编译器会为你生成一个相关的类，这个类继承自java.lang.Enum。下面的例子演示了Enum提供的一些功能：

```java
enum Shrubbery{GROUND, CRAWLING, HANGING}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWLING));
            System.out.println(s.equals(Shrubbery.CRAWLING));
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("--------");
        }
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }
    }
}
/*
output:
GROUND ordinal: 0
-1
false
class com.jianglei.enummm.Shrubbery
GROUND
--------
CRAWLING ordinal: 1
0
true
class com.jianglei.enummm.Shrubbery
CRAWLING
--------
HANGING ordinal: 2
1
false
class com.jianglei.enummm.Shrubbery
HANGING
--------
HANGING
CRAWLING
GROUND

*/
```

ordinal\(\)方法返回一个int值，这是每个enum实例在声明时的次序，从0开始。可以使用==来比较enum实例，编译器会自动为你提供equals\(\)和hashCode\(\)方法。Enum类实现了Comparable接口，所以它具有compareTo\(\)方法。同时，它还实现了Serializable接口。

如果在enum实现上调用getDeclaringClass\(\)方法，我们就能知道其所属的enum类

name\(\)方法返回enum实例声明时的名字，这与使用toString\(\)方法效果相同。valueOf\(\)是在Enum中定义的static方法，它根据给定的名字返回相应的enum实例，如果不存在给定名字的实例，将会抛出异常。

