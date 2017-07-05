# 12.8 通配符类型

固定的泛型类型系统使用起来并没有那么令人愉快，类型系统的研究人员知道这一点已经有一段时间了。Java的设计者发明了一种巧秒的（仍然是安全的）“解决方案”:通配符类型。

例如，通配符类型

```
Pair<? extends Employee>
```

表示任何泛型Pair类型，它的类型参数是Employee的子类，如Pair&lt;Manager&gt;，但不是Pair&lt;String&gt;。

假设要编写一个打印雇员对的方法，像这样：

```java
public static void printBuddies(Pair<Employee> p){
    Employee  first = p.getFirst();
    Employee  second = p.getSecond();
    System.out.println(first.getName() + "and" + second.getName() + "are buddies");
}
```

正如前面讲到的，不能将Pair&lt;Manager&gt;传递给这个方法，这一点很受限制。解决的方法很简单：使用通配符类型：

```java
public static void printBuddies(Pair<? extends Employee> p)
```

类型Pair&lt;Manager&gt;是Pair&lt;? extends Employee&gt;的子类型

![](/assets/屏幕快照 2017-07-06 上午12.15.10.png)使用通配符会通过Pair&lt;? extends Employee&gt;的引用破坏Pair&lt;Manager&gt;吗？

```
Pair<Manager> managerBuddies = new Pair<>(ceo, cfo);
Pair<? extends Employee> wildcardBuddies = managerBuddies;
wildcardBuddies.setFirst(lowlyEmployee);
```

这可能不会引起破坏。对setFirst的调用有一个类型错误。要了解其中的缘由，请仔细看一看Pair&lt;? extends Employee&gt; 其方法似乎是这样的：

```
？ extends Employee getFirst()
void setFirst(? extends Employee)
```

这样将不可能调用setFisrt方法。编译器只知道需要某个Employee的子类型，但不知道具体是什么类型。它拒绝传递任何特定的类型。毕竟？不能用来匹配

使用getFirst就不存在这个问题：将getFirst的返回值赋给一个Employee的引用完全合法。

这就是引入有限定的通配符的关键这外。现在已经有办法区分安全的访问器方法和不安全的更改器方法了。

