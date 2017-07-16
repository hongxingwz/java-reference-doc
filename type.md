# Type

此接口是Java所有类型\(types\)的共同的父接口

包括原始类型\(raw types\)，参数类型\(parameterized types\)，数组类型\(array types\)，类型变量\(type variables\)，基本类型\(primitive types\)

此接口就定义了一个方法,返回一个描述此类型的字符串，包括任何类型参数\(type parameters\)的信息

默认实例是调用toString\(\)方法

* getTypeName\(\)

## UML类图

![](/assets/屏幕快照 2017-07-16 上午6.45.20.png)

## raw type\(原始类型\)

我们知道虚拟机没有泛型类型对象－－所有对象都属于普通类。

无论何时定义一个泛型类，都自动提供一个相应的_原始类型\(raw type\)。_原始类型的名字就是删去类型参数后的泛型类型名。_擦除\(erased\)_类型变量，并替换为限定类型\(无限定的变量用Object\)

例如，定义一个泛型类Pair&lt;T&gt;

```java
public class Pair<T> {
    private T first;

    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
```

对应的原始类型

```java
public class Pair{
    private Object first;

    private Object second;

    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public Object getSecond() {
        return second;
    }

    public void setSecond(Object second) {
        this.second = second;
    }
}
```

**带有限定的泛型类型**

```java
public class Pair<T extends Comparable<T>&Serializable> {
    private T frist;

    private T second;

    public Pair(T frist, T second) {
        this.frist = frist;
        this.second = second;
    }

    public T getFrist() {
        return frist;
    }

    public void setFrist(T frist) {
        this.frist = frist;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
```

对应的原始类型如下

```java
public class Pair{
    private Comparable frist;

    private Comparable second;

    public Pair(Comparable frist, Comparable second) {
        this.frist = frist;
        this.second = second;
    }

    public Comparable getFrist() {
        return frist;
    }

    public void setFrist(Comparable frist) {
        this.frist = frist;
    }

    public Comparable getSecond() {
        return second;
    }

    public void setSecond(Comparable second) {
        this.second = second;
    }
}
```

获取指定字段的原始类型和泛型类型的示例

```java
Class<Pair> cls = Pair.class;
Field first = cls.getDeclaredField("frist");

//获取原始类型
Class<?> type = first.getType();
System.out.println(type.getSimpleName()); //output: Comparable

//获取泛型类型
Type genericType = first.getGenericType();
String name = ((TypeVariable) genericType).getName();
System.out.println(name); //output: T
```

## 参数类型\(Parameterized Type\)

```java
public class ParameterizedTypeReflection<T> {

    List<? extends Number> list;
    List<?> list2;
    List<? super Comparable<T>> list3;

    public static void main(String[] args) {
        Class<?> cls = ParameterizedTypeReflection.class;
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            field.getGenericType().getClass(); //return: ParameterizedTypeImpl
            //反射获取
            Type genericType = field.getGenericType();
            System.out.println(genericType.getTypeName());
        }
    }

}
/*
java.util.List<? extends java.lang.Number>
java.util.List<?>
java.util.List<? super java.lang.Comparable<T>>

*/
```

## 数组类型\(Array Type\)

包括基本类型数组，引用类型数组，泛型数组

基本类型数组:**int\[\]**

引用类型数组:**Integer\[\]**

泛型数组:**T\[\]**

```java
public class ArrayReflection<T> {

    //基本类型数组
    private int[] primitArr;

    //引用类型数组
    private Integer[] referenceArr;

    //泛型数组
    private T[] GenericArr;

    public static void main(String[] args) {
        Class<ArrayReflection> cls = ArrayReflection.class;
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            //反射获取
            Type genericType = field.getGenericType();
            System.out.println(genericType.getTypeName());
        }
    }

}
/*
output:
    int[]
    java.lang.Integer[]
    T[]
*/
```

## 类型变量\(Type Variables\)

```java
public class PrimitiveTypeReflection<T, D, Y> {

    T name;

    D age;

    Y love;

    public static void main(String[] args) {
        Class<?> cls = PrimitiveTypeReflection.class;
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            //反射获取类型变量
            Type genericType = field.getGenericType();
            genericType.getClass(); //return TypeVariable
            System.out.println(genericType.getTypeName());
        }
    }
}
/*
T
D
Y

*/
```

## 基本类型\(Primitive Type\)

```java
public class PrimitiveTypeReflection<T> {

    private int age;

    private boolean isTall;

    private char c;

    public static void main(String[] args) {
        Class<?> cls = PrimitiveTypeReflection.class;
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            //反射获取基本类型
            Class<?> type = field.getType();
            String name = type.getName();
            System.out.println(name);
        }
    }
}
/*
int
boolean
char

*/
```



