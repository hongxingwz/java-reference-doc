# Varargs警告

上一节中已经了解到，Java不支持泛型数组的数组。这一节中我们再来讨论一个相关的问题：向参数个数可变的方法传递一个泛型类型的实例

考虑下面这个简单的方法，它的参数个数是可变的：

```
public static <T> void addAll(Collection<T> coll, T... ts){
    for(t : ts) coll.add(t);
}
```

应该记得，实际上参数ts是一个数组，包含提供的所有实参。

现在考虑以下调用：

```
Collection<Pair<String>> table = ...;
Pair<String> pair1 = ...;
Pair<String> pair2 = ...;
addAll(table, pair1, pair2);
```

为了调用这个方法，Java虚拟机必须建立一个Pair&lt;String&gt;数组，这就违反了前面的规则。不过，对于这种情况，规则有所放松，你只会得到一个警告，而不是错误。

可以采用两种方法来抑制这个警告。一种方法是包含addAll调用的方法增加标注@SuppressWarnings\("unchecked"\)。或者在Java SE 7中，还可以用＠SafeVarargs直接标注addAll方法：

```
@SafeVarargs
public static <T> void addAll(Collection<T> coll, T... ts)
```

现在就可以提供泛型类型来调用这个方法了。对于只需要读取参数数组元素的所有方法，都可以使用这个标注，这仅限于最常见的用例。





