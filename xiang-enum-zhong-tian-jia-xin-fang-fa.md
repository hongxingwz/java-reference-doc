# 向enum中添加新方法

除了不能继承自一个**enum**之外，我们基本上可以将**enum**看作一个常规的类。也就是说，我们可以向**enum**中添加方法。**enum**甚至可以有**main\(\)**方法。

一般来说，我们希望每个枚举实例能够返回对自身的描述，而不仅仅是默认的**toString\(\)**实现，这只能返回枚举实例的名字。为此，你可以提供一个构造器，专门负责处理这个额外的信息，然后添加一个方法，返回这个描述信息。看一看下面的示例：

```
public enum OzWitch {
//    Instances must be defined first, before methods;
    WEST("Miss Gulch, aka the wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");
    private String description;

//    Constructor must be package or private access;
     OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }
}
/*
WEST: Miss Gulch, aka the wicked Witch of the West
NORTH: Glinda, the Good Witch of the North
EAST: Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house
SOUTH: Good by inference, but missing
*/
```
注意，如果你打算定义自己的方法，那么必须在**enum**实例序列的最后添加一个分号。同时，Java要求你必须先定义**enum**实例。如果在定义**enum**实现之前定义了任何方法或属性，那么在编译时就会得到错误信息。
**enum**中的构造器与方法和普通的类没有区别，因为除了少许限制之外，**enum**就是一个普通的类。所以，我们可以使用**enum**做许多的事情(虽然，我们一般只使用普通的枚举类型)。
在这个例子中，虽然我们有意识地将**enum**的构造器声明为**private**，但对于它的可访问性而言，其实并没有什么变化，因为(即使不声明为**private**)我们只能在**enum**定义的内部使用其构造器创建**enum**实例。一旦**enum**的定义结束，编译器不允许我们再使用其构造器来创建任何实例了。



