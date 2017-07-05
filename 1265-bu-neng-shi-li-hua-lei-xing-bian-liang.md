# 不能实例化类型变量

不能使用像new T\(...\)， new T\[...\] 或 T.class这样的表达式中的类型变量。例如，下面Pair&lt;T&gt;构造器就是非法的：

```
public Pair(){first = new T(); second = new T();}
```

类型擦除将T改变成Object，而且，本意肯定不希望调用new Object\(\)。但是，可以通过反射调用Class.newInstance方法来构造泛型对象。

遗憾的是，细节有点复杂。不能调用：

```
first = T.class.newInstance(); //ERROR
```

表达式T.class是不合法的。必须像下面这样设计API以便可以支配Class对象



