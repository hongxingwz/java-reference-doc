# 泛化的Class引用

**Class**引用总是指向某个**Class**对象**，**它可以制造类的实例，并包含可作用于这些实例的所有方法代码。它还包含该类的静态成员，因此，Class引用表示的就是它所指向的对象的确切类型，而该对象便是Class类的一个对象。

但是，Java SE5 的设计者们看准机会，将它的类型变得更具体了一些，而这是通过允许你对**Class**引用指向的**Class**对象的类型进行限定而实现的，这里用到了泛型语法。在下面的实例中，两种语法都是正确的：

```java
public class GenericClassReferences{
    public static void main(String[] args){
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intClass = double.class;
        // genericIntClass = double.class;
    }
}
```

普通的类引用不会产生警告信息，你可以看到，尽管泛型类引用只能赋值为指向其声明的类型，但是普通的类引用可以被重新赋值为指向任何其他的Class对象。通过使用泛型语法，可以让编译器强制执行额外的类型检查。

如果你希望稍微放松一些这种限制，应该怎么办呢？乍一看，好像你应该能够执行类似下面这样的操作：

```
Class<Number> genericNumberClass = int.class
```

这看起来似乎是起作用的，因为Integer继承自Number。但是它无法工作，因为Integer Class对象不是Number Class对象的子类（这种差异看起来可能有些诡异）



为了在使用泛化的Class引用时放松限制，我使用了通配符，它是Java泛型的一部分。通配符就是"?"，表示“任何事物“。因此，我们可以在上例的普通Class引用中添加通配符，并

