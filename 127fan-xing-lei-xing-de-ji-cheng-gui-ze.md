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



