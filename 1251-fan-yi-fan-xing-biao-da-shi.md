# 翻译泛型表达式

当程序调用泛型方法时，如果擦除返回类型，编译器插入强制类型转换。例如，下面这个语句序列

```
Pair<Employee> buddies = ...;
Employee buddy = buddies.getFirst();
```

擦除getFirst的返回类型后将返回Object类型。编译器自动插入Employee的强制类型转换。也就是说，编译器把这个方法调用翻译为两条虚拟机指令：

* 对原始方法Pair.getFirst的调用
* 将返回的Object类型强制转换为Employee类型

当存取一个泛型域时也要插入强制类型转换。假设Pair类的first域和second域都是公有的（也许这不是一种好的编程风格，但在Java中合法）。表示式

```
Employee buddy = buddies.first;
```

也会在结果字节码中插入强制类型转换。





