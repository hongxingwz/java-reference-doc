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



### 实例化一个指定长度的一维数组

使用指定的组件类型和长度创建一个新数组。

调用此方法等价于下面这样创建一个数组：

```
int[] x = {length};
Array.newInstance(componentType, x);
```

新数组的维度一定不能超过**255**。



如果指定的componentType 为null, 则抛出NullPointerException

如果组件类型是Void.TYPE 或数组的维度超出了255, 则抛出了IllegalArgumentException

如果指定的长度是负数则抛出NegativeArraySizeException

**public static Object newInstance\(Class&lt;?&gt; componentType, int length\)**



### 实例化一个指定组件类型和维度的数组

创建一个新的具有指定组件类型和维度的新数组。

如果componentType代表一个非数组或接口，新数组具有dimensions.length的维度，componentType作为其组件，如果componentType表示一个数组类，新数组的维度等价于dimensions.length + componentType的维度。在这种情况下，新数组的类型是componentType的组件类型。

新数组的维度一定不能超过255

componentType 类对象表示新数组的组件类型

dimensions 表示新数组的维度

如果指定的componentType参数为null，则抛出NullPointerException

如果指定的dimensions参数是一个0维度的数组，如果componentType是Void.TYPE,或需要的维度超过255，则抛出IllegalArgumentException

如果指定的任何组件维度是负数则抛出NegativeArraySizeException



**public static Object newInstance\(Class&lt;?&gt; componentType, int... dimensions\)**



