# Collections容器工具类

## emptyList\(\) emptySet\(\) emptyMap\(\)的使用场景

**优势**

* 方便编程，在返回一个空列表时

```
return Collections.emptyList()
```

* 些省cpu，内存。因为该方法每次调用都返回一个不可变的单例的空容器

**劣势**

* 返回的空列表是不可变的
  因此必须要在方法中声明返回的空列表是不可变的，如果没有声明客户端在调用时可以调用add等方法，千万不必要的异常和错误

## singleton, singletonList\(\), singletonMap\(\)的用法及使用场景

返回一个仅包含一个元素的容器，不支持添加，删除等行为

移除集合中为null的元素

```
list.removeAll(Collections.singleton(null));
```

## rotate

一个很好玩的偏移方法

