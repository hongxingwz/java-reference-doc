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





