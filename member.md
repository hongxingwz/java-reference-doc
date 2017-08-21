

# Member

Member是一个接口反射辨别一个成员（一个字段，方法）或一个构造器

## 字段摘要

* DECLARED: 标识类或接口的所有已声明成员的集合
* PUBLIC: 标识类或接口的所有公共成员的集合

## 方法摘要

* getDeclaringClass\(\): 返回表示声明由此Member表示的成员或构造方法的类或接口的Class对象
* getModifiers\(\): 返回此Member所表示的成员或构造方法的Java语言修饰符
* getName\(\): 返回此Member表示的底层或构造方法的简单名称
* isSynthetic\(\): 如果此成员是编译器引入的，则返回true; 否则，返回false


#自已的总结
Member是对Executable和Field类的抽象。

此两个类Executable和Field的共同点是
* 都具有名字 ---------------> getName()
* 都具有修饰符 -------------> getModifiers()
* 都定义在一个类型里面 -------> getDeclaringClass()

Executable下面又有Method和Constructor

Field应该有一个方法返回其表示的类型
表示的类型    --------------> getType()

Method应该有一个方法返回其返回的类型
返回的类型    --------------> getReturnType()

而Constructor就没有像此类的方法了

**所以在Member层就没法作类型方法的抽象了**



