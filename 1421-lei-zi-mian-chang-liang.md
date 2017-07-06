# 类字面常量

Java还提供了另一种方法来生成对Class对象的引用，好使用_类字面常量。_对上述程序来说就像下面这样：

```
FancyToy.class
```

这样做不仅简单，而且更安全，因为它在编译时就会受到检查（因此不需要置于try语句块中）。并且它根除了对**forName\(\)**方法的调用，所以也更高效。

**类字面常量不仅可以用于普通的类，也可以用于接口，数组及基本数据类型**。另外，对于基本数据数据类型的包装器类，还有一个标准字段TYPE。TYPE字段是一个引用，指向对就的基本数据类型的Class对象，如下所示：

| boolean.class | Boolean.TYPE |
| :--- | :--- |
| char.class | Character.TYPE |
| short.class | Short.TYPE |
| int.class | Integer.TYPE |
| long.class | Long.TYPE |
| float.class | Float.class |
| double.class | Double.class |
| void.class | Void.TYPE |



