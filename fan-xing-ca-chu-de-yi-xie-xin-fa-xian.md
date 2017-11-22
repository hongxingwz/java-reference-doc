# 泛型擦除的一些新发现

今天在翻看Spring-core的类AbstractEnvironment的源码时时有这样一段代码

```
public Map<String, Object> getSystemProperties() {
    return (Map) System.getProperties();
}
```

为方法声明的返回值是Map&lt;String, Object&gt;但是返回Map确是可以通过编译通过的，这引起了我大大的不解？

猜测：与老代码兼容,因为在Jdk1.4之前是没有泛型的

```
        List list = new ArrayList();
        List<String> list2 = list; //可以通过编译
```

如果把代码改成这样

```
public Map<String, Object> getSystemProperties(){
    Map<Object, String> map = new HashMap<>();
    map.put(new Object(), "1");
    return (Map)map;
}
```

也是可以通过编译，但是在遍历的时候确会报Object can't not cast String的异常

也许这也是为什么返回一个原始类型时会产生unchecked的警告的原因

