类型除除也会出在泛型方法中。程序员通常认为下述的泛型方法

```java
public static<T extends Comparable> T min(T[] a)
```

是一个完整的方法族，而探险类型之后，只剩下一个方法：

```java
public static Comparable min(Comparable[] a)
```

注意。类型参数T已经被探险了，只留下了限定类型Comparable。

方法的擦除带来了两个复杂问题。看一看下面这个示例：

```java
class DateInterval extends Pair<Date>{
    public void setSecond(Date second){
        if(second.comareTo(getFirst()) >=0){
            super.setSecond(second);
        }
    }
    ...
}
```

一个日期区间是一对Date对象，并且需要覆盖这个方法来确保第二个值永远不小于第一个值。这个类擦除后变成

```java
class DateInterval extends Pair{
    public void setSecond(Date second){... }
    ...
}
```

令人感到奇怪的是，存在另一个从Pair继承的setSecond方法，即

```java
public void setSecond(Object second)
```

这显然是一个不同的方法，因为它有一个不同类型的参数--Object,而不是Date。然而，不应该不一样。考虑下面的语句序列：

```java
DateInterval interval = new DateInterval(..);
Pair<Date> pair = interval;
pair.setSecond(aDate);
```

这里，希望对setSecond的调用具有多态性，并调用最合适的那个方法。由于pair引用DateInterval对象，所以应该调用DateInterval.setSecond。问题在于类型擦除与多态发生了冲突。要解决这个问题，就需要编译顺在DateInterval类中生成一个**桥方法\(bridge method\):**

```java
public void setSecond(Object second){setSecond((Date) second);}
```

要想了解它的式作过程，请仔细地践踏下列语句的执行：

```java
pair.setSecond(aDate)
```

变量pair已经声明为类型Pair&lt;Date&gt;,并且这个类型只有一个简单的方法叫setSecond，即setSecond\(Object\)。虚拟机用pair引用的对象调用这个方法。这个对象是DateInterval类型的，因而将会调用DateInterval.setSecond\(Object\)方法。这个方法是合成的桥方法。它调用DateInterval.setSecond\(Date\),这正是我们所期望的操作效果。

桥方法可能会变得十分奇怪。假设DateInterval方法也覆盖了getSecond方法：

```java
class DateInterval extends Par<Date>{
    public Date getSecond(){return (Date)super.getSecond().clone();}
```

在擦除的类型中，有两个getScond方法：

```java
Date getSecond() // defined in DateInterval
Object getSecond() //overrides the method defined in Pair to call the first method
```

不能这样编写Java代码（在这里，具有相同参数类型的两个方法是不合法的）。它们都没有参数。但是，在虚拟机中，用参数类型和**返回类型**确定一个方法。因此，编译器可能产生两个仅返回类型不同的方法字节码，虚拟机能够正确地处理这一情况。

桥方法不仅用于泛型类型。第5章已经讲过，在一个方法覆盖另一个方法时可以指定一个更严格的返回类型。例如：

```java
public class Employee implements Cloneable{
    public Employee clone() throws CloneNotSupportedException{...}
}
```

Object.clone和Employee.clone方法被说成具有协变的返回类型\(covariant return types\)。

实际上，Employee类有两个克隆方法：

```java
Employee clone() //defined above
Object clone() //synthesized bridge method, overriders Object.clone
```

合成的桥方法调用了新定义的方法。



总之，需要记住有关Java泛型转换的事实：

* 虚拟机中没有泛型，只有普通的类和方法
* 所有的类型参数都用它们的限定类型替换
* 桥方法被合成来保持多态
* 为保持类型安全性，必须时插入强制类型转换



