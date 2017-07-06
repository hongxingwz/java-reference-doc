# 新的转型语法

Java SE 5 还添加了用于**Class**引用的转型语法，即**cast\(\)**方法：

```
class Building{}
class House extends Building{}

public class ClassCasts{
    public static void main(String[] args){
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House)b;  // ... or just do this;
    }
}
```

**cast\(\)**方法接受参数对象，并将其转型为**Class**引用的类型。当然，如果你观察上面的代码，则会发现，与实现了相同功能的**main\(\)**中最后一行相比，这种转型好像做了很多额外的工作。新的转型语法对于无法使用普通转型的情况显得非常有用，在你编写泛型的代码时，如果你存储了**Class**引用，并希望以后通过这个引用来执行转型，这种情况就会时有发生。这被证明是一种罕见的情况－－我发现在整个Java SE 5类库中，只有一处使用了**cast\(\) \(在com.sun.mirror.util.DeclarationFilter中）。**

在Java SE 5中另一个没有任何用处的新特性就是**Class.asSubclass\(\)，**该方法允许你将一个类对象转型为更加具体的类型。

