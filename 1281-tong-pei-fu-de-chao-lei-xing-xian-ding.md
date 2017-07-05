# 12.8.1通配符的超类型限定

通配符限定与类型变量限定十分类似，但是，还有一个附加的能力，即可以指定一个超类型限定（supertype bound\)，如下所示：

```
? super Manager
```

这个通配符限制为Manager的所有超类型。\(已有的super关键字十分准确地描述了这种联系，这一点十分令人感到欣慰。）

为什么要这样做呢？带有超类型限定的通配符的行为与12.8节介绍的相反。要以为方法提供参数，但不能使用返回值。例如，Pair&lt;? super Manager&gt;有方法

```
void setFirst(? super Manager)
? super Manager getFisrt()
```

编译器不知道setFirst方法的确切类型，但是可以用任意Manager对象（或子类型，例如，Executive\)调用它，而不能用Employee对象调用。然而，如果调用getFirst，返回的对象类型就不会得到保证。只能把它赋给一个Object。

![](/assets/屏幕快照 2017-07-06 上午12.43.40.png)



