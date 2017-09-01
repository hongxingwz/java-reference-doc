# 基本enum特性

我们已经在以前看到，调用enum的values()方法，可以遍历enum实例。values()方法返回enum实例的数组，而且该数组中的元素严格保持其在enum中声明时的顺序，因此你可以在循环中使用values()返回的数组。

创建enum时，编译器会为你生成一个相关的类，这个类继承自java.lang.Enum。下面的例子演示了Enum提供的一些功能：