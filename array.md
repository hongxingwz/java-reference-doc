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

---

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

---

**public static native int getLength\(Object array\) throws IllegalArgumentException**  
返回指定数组对象的长度， 以int的形式  
如果array为null，则会抛出一个空指针异常

## 如果array不是数组对象，则会抛出一个IllegalArgumentException

**get\(Object array, int index\);**

**set\(Object array, int index, Object value\);**

NullPointerException 如果指定的array对象为null  
IllegalArgumentException 如果指定的对象不是一个数组  
ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，或其超过了指数的数组的长度。

---

## 对源码的一些总结

八种基本类型的数组不是Object\[\].class的子类型

```
Object[].class.isAssignableFrom(int[].class);
```

但其八种基本包装类型，和其他对象的数组是Object\[\].class的子类型

```
Object[].class.isAssignableFrom(Integer[].class);
Object[].class.isAssignableFrom(List[].class);
```

而

```
List[][].class.isAssignableFrom(List[][][].class)); //返回false
```

**因此在判断一个多维度的数组是最好用Object\[\],在JDK和Spring的源码里有体现到**



