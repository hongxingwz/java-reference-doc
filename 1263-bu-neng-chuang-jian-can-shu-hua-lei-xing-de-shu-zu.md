# 12.6.3 不能创建参数化类型的数组

不能实例化参数化类型的数组 ，例如

```java
Pair<String>[] table = new Pair<String>[10];
```

这有什么问题呢？擦除之后，table的类型是Pair\[\]。可以把它转换为Object\[\];

```java
Object[] objarray = table;
```

数组会记住它的元素类型，如果试图存储其他类型的元素，就会抛出一个ArrayStoreException异常:

```java
objectarry[0] = "hello"
```

不过对于泛型数组，擦除会使这种机制无效。以下赋值：

```java
objarray[0] = new Pair<Employee>();
```

## 可以声明通配类型的数组，然后进行类型转换

```
Pair<String>[] table = (Pair<String>[])new Pair<?>[10];
```

## 自己的实验

**泛型数组**

```java
Pair<String>[] table = new Pair<String>[10] //Error
Pair<String>[] table = new Pair[10] //Yes

Pair<String> pair = new Pair<>();
table[0] = pair;

Pair<Object> pair1 = new Pair<>();
table[1] = pair1; //incompatible types: com.jianglei.raw.Pair<java.lang.Object> cannot be converted to com.jianglei.raw.Pair<java.lang.String>


Object[] objects = table;
objects[1] = pair1; //可以通过，造成了数组里存储的类型不一致
```

**普通数组**

```java
 String[] strs = {"a", "b", "c", "d", "e"};
 Object[] objs = strs;

 objs[0] = new Object(); //java.lang.ArrayStoreException: java.lang.Object
```



