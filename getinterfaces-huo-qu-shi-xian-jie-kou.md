### public Class&lt;?&gt;\[\] getInterfaces\(\)

确定此对象表示的接口或类实现的接口（只限于此类，不包括此类的父类）

如果此对象代表一个类，返回的直是一个包含表示由此类实现的所有的接口对象的数组。数组中接口的顺序与此类声明实现的接口的顺序有关。例如，给出声明：

```
class Shimmer implements FloorWax, DessertTopping{...}
```

假设s是Shimmer的一个实例；下面表达式的值

```
s.getClass().getInterfaces()[0]
```

是代表FloorWax接口的对象；

```
s.getClass().getInterfaces()[1]
```

的值是代表DesseertTopping接口的对象



如果此对象表示一个接口，那么返回的数组包含代表此接口继承的所有接口的对象。数组中的接口对象的顺序与在此接口声明实extends后面的接口顺序相关。

如果此对象表示的类或对象没有实现任何接口，此方法返回一个长度为0的数组。

如果此对象表示一个原始的类型或void，此方法返回一个长度为0的数组。

如果此Class对象表示一个数组类型，会返回一个包含Cloneable和Serializable接口类对象的数组

