# 12.5泛型代码和虚拟机

虚拟机没有泛型对象 －－ 所有对象都属于普通类。在泛型实现的早期版本中，甚至能够将使用泛型的程序编译为在1.0虚拟机上运行的类文件！这个向后兼容性在Java泛型开发的后期被放弃了。

无论何时定义一个泛型类型，都自动提供了一个相应的**原始类型\(raw type\)**。原始类型的名字就是删去类型参数后的泛型类型名。  
**擦除\(erased\)类型变量，并替换为限定类型（无限定的变量用Object\)**。

例如，Pair&lt;T&gt;的原始类型如下所示：

```java
public class Pair{
    private Object first;
    private Object second;

    public Pair(Object first, Object second){
        this.first = first;
        this.second = second;
    }

    public Object getFirst(){
        return first;
    }

    public Object getSecond(){
        return second;
    }

    public void setFirst(Object newValue){first = newValue;}
    public void setSecond(Object newValue){second = newValue;}
}
```

因为T是一个无限定的变量，所以直接用Object替换。  
结果就是一个普通的类，就好像泛型引入Java语言这前已经实现的那样。  
在程序中可以包含不同类型的Pair,例如，Pair&lt;String&gt;, Pair&lt;GregorianCalender&gt;。而探险类型后就变成原始的Pair类型了。

原始类型用第一个限定的类型变量来替换，如果没有给定限定就用Ojbect替换。例如，类Pair&lt;T&gt;中的类型变量没有显式的限定，因此，原始类型用Object替换T。假定声明了一个不同的类型。

```java
public class Interval<T extends Comparable&Serializable> implements Serializable{
    private T lower;
    private T upper;

    ...

    public Interval(T first, T second){
        if(first.compareTo(second) <= 0){
            lower = first;
            upper = second;
        }else{
            lower = second;
            upper = first;
        }
    }
}
```

原始类型Interval如下所示：

```java
public class Interval implements Serializable{
    private Comparable lower;
    private Comparable upper;
    
    ...
    public Interval(Comparable first, Comparable second){...}
}
```



