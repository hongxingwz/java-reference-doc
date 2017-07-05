# 泛型类型的继承规则

在使用泛型类时，需要了解一些有关继承和子类型的准则。下面先从许多程序员感觉不太直观的情况开始。考虑一个类和一个子类，如Employee和Manager。Pair&lt;Manager&gt;是Pair&lt;Employee&gt;的一个子类吗？答案是“不是”。或许人们会感到奇怪。例如，下面的代码将不能编译成功：

```
Manager[] topHonchos = ...;
Pair<Employee> result = ArrayAlg.minmax(topHonchos); //ERROR
```

minmax方法返回Pair&lt;Manager&gt;，而不是Pair&lt;Employee&gt;，并且这样的赋值是不合法的。无论S与T有什么联系，通常，Pair&lt;S&gt;与Pair&lt;T&gt;没有什么联系。

![](/assets/屏幕快照 2017-07-05 下午9.30.10.png)

这一限制看起来过于严格，但对于类型安全非常必要。假设允许将Pair&lt;Manager&gt;转换为Pair&lt;Employee&gt;。考虑下面代码：

```
Pair<Manager> managerBuddies = new Pair<>(ceo, cfo);
Pair<Employee> employeeBuddies = managerBuddies; //illegal, but suppose it wan't
employeeBuddies.setFirst(lowlyEmployee);
```

显然，最后一句是合法的。但是employeeBuddies和managerBuddies引用了同样的对象。现在将CFO和一个普通员工组成一对，这对于Pair&lt;Manager&gt;来说应该是不可能的。

> 注释：必须注意泛型与Java数组之间的重要区别。可以将一个Manager\[\]数组赋给一个类型为Employee\[\]的变量：
>
> Manager\[\]  managerBuddies = {ceo, cfo};
>
> Employee\[\] employeeBuddies = managerBuddies;

然而，**数组带有特别的保护**。如果试图将一个低级别的雇员存储到employeeBuddies\[0\]，虚拟机将会抛出ArrayStoreException异常。

永远可以将参数化类型转换为一个原始类型。例如，Pair&lt;Employee&gt;是原始类型Pair的一个子类型。在与遗留代码街接时，这个转换非常必要。



转换成原始类型之后会产生类型错误吗？很遗憾，会！看一看下面这个示例：

```
Pair<Manager> managerBuddies = new Pair<>(ceo, cfo);
Pair rawBuddies = managerBuddies;//OK
rawBuddies.setFirst(new File("...")); //only a compile-time warning
```

听起来有点吓人。但是，请记住现在的状态不会再比旧版Java的情况糟糕。虚拟机的安全性还没有到生死悠关的程序。当使用getFirst获得外来对象并赋给Manager变量时，与通常一样，会抛出ClassCastException异常。这里失去的只是泛型程序设计提供的附加安全性。

最后，泛型类可以扩展或实现其他的泛型类。就这一点而言，与普通的类没有什么区别。例如，ArrayList&lt;T&gt;类实现List&lt;T&gt;接口。这竟味着，一个ArrayList&lt;Manager&gt;可以被转换为一个List&lt;Manager&gt;。但是，如前面所见，一个ArrayList&lt;Manager&gt;不是一个ArrayList&lt;Employee&gt;或List&lt;Employee&gt;。

![](/assets/屏幕快照 2017-07-05 下午10.34.06.png)



