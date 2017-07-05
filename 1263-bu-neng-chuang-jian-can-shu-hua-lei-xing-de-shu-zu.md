# 12.6.3 不能创建参数化类型的数组

不能实例化参数化类型的数组 ，例如

```
Pair<String>[] table = new Pair<String>[10];
```

这有什么问题呢？擦除之后，table的类型是Pair\[\]。可以把它转换为Object\[\];

```
Object[] objarray = table;
```

数组会记住它的元素类型，如果试图存储其他类型的元素，就会抛出一个ArrayStoreException异常:

```
objectarry[0] = "hello"
```

不过对于泛型数组，擦除会使这种机制无效。以下赋值：

```
objarray[0] = new Pair<Employee>();
```



