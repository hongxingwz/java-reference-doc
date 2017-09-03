# values\(\)的神秘之处

前面已经提到，编译器为你创建的**enum**类都继承自**Enum**类。然而,如果你研究一下Enum类就会发现，它并没有values\(\)方法。可我们明明已经用过该方法了，难道存在某种“隐藏的”方法吗？我们可以利用反射机制编写一个简单的程序，来查看其中的究竟：

```java
enum Explore {
    HERE, THERE
}
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("--- Analyzing " + enumClass + "-----");
        System.out.println("Interface: ");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> analyze = analyze(Enum.class);

        System.out.println("Explore.containsAll(enumMethods)");
        System.out.println("---" + exploreMethods.containsAll(analyze));

        System.out.println("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(analyze);
        System.out.println(exploreMethods);
    }
}
/*
--- Analyzing class com.jianglei.enum3.Explore-----
Interface: 
Base: class java.lang.Enum
Methods: 
[compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, values, wait]
--- Analyzing class java.lang.Enum-----
Interface: 
java.lang.Comparable<E>
interface java.io.Serializable
Base: class java.lang.Object
Methods: 
[compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, wait]
Explore.containsAll(enumMethods)
---true
Explore.removeAll(Enum): 
[values]
*/
```
答案是，**values()**是由编译器添加的**static**方法。可以看出，在创建**Explore**的过程中，编译器还为其添加了**valueOf()**方法。这可能有点令人迷惑，**Enum**类不是已经有**valueOf()**方法了吗。不过**Enum**中的**valueOf()**方法需要两个参数，而这个新增的方法只需要一个参数。由于这里使用的**Set**只存储方法的名字，而不考虑方法的签名，所以在调用**Explore.removeAll(Enum)**之后，就只剩下**[values]**了。
从最后的输出中可以看到，编译器将Explore标记为**final**类，所以无法继承自**enum**。其中还有一个**static**初始化子句。稍后我们将学习如何定义该句。
由于擦除效应(在第15章中介绍过)，反编译无法得到Enum的完整信息，所以它展示的**Explore**的父类只是一个原始的**Enum**,而非事实上的Enum&lt;Explore&gt;。
由于**values()**方法是由编译器插入到**enum**定义中的**static**方法，所以，中果你将**enum**实例向上转型为**Enum**，那么values()方法就不可访问了。不过，在Class中有一个getEnumConstants()方法，所以即便**Enum**接口中没有**values()**方法，我们仍然可以通过**Class**对象取得所有**enum**实例：


```
public class UpcastEnum {
    public static void main(String[] args) {
        Search[] values = Search.values();
        Enum<Search> hither = Search.HITHER;
        Enum[] enumConstants = hither.getClass().getEnumConstants();
        for (Enum constant : enumConstants) {
            System.out.println(constant);
        }
    }
}
/*
HITHER
YON
*/
```
因为**getEnumConstants()**是**Class**上的方法，所以你甚至可以对不是枚举的类调用此方法：


```
public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for (Object en : intClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/*
output:
java.lang.NullPointerException
*/
```
只不过，此时该方法返回**null**,所以当你试图使用其返回的结果时会发生异常。





