# 12.6.2 运行时类型查询只适用于原始类型

虚拟机中的对象总有一个特定的非泛型类型。因此，所有的类型查询只产生原始类型。

例如：

```java
if( a instanceOf Pair<String>) //ERROR
```

实际上仅仅测试a是否是任意类型的一个Pair。下面的测试同样如此：

```java
if( a instanceOf Pair<T>) //ERROR
```

或强制类型转换：

```java
Pair<String> p = (Pair<String>) a;
```

要记住这一风险，无论何时使用instanceof或涉及泛型的强制转换表达式都会看到一个编译器警告。

同样的道理， getClass方法总是返回原始类型。例如：

```java
Pair<String> stringPair = ...;
Pair<Employee> employeePair = ...;
if(StringPair.getClass() == employeePair.getClass()) //they are equal
```



