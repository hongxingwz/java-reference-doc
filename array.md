# Array

array类提供静态方法动态创建和访问数组。

Array允许在get/set期间发生扩展转换，但是如果是收缩转换则会抛出一个IllegalArgumentException



创建一个无法实例化的方法

该类不可被继承，构造器私有化

```java
public final class Array{
    private Array(){}
}
```





