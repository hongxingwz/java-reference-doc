# 类型变量\(Type Variables\)


一个_类型变量(type variable)_是一个不唯一的标识符。在类，接口，方法和构造器内作为一个类型使用的。

在泛型类，接口，方法或构造器， _类型变量_被介绍为_类型参数_的声明。



```
TypeParameter:
    {TypeParameterModifier} Identifier [TypeBound]
    
TypeParameterModifier:
    Annotation
    
TypeBound:
    extends TypeVariable
    extends ClassOrInterfaceType {AdditionalBound}
    
AdditionalBound:
    &InterfaceType
```
类型变量被声明为类型参数的作用域在§6.3用介绍。
没个作为类型参数声明的类型变量都有一个_上限(bound)_。如果一个类型变量没有声明上限，会假定为`Object`。如果声明了上限，由下面其中一个组成：
* 一个单一的类型变量T, 或
* 一个类或接口类型T后面如果有的话接 接口类型`I1 & ... & In.`

如果`I1 & ... & In.`是一个类变量或类型变量的话则会发生编译错误。

界限的所有成员类型的探除(erasure)(§4.6)必须两两不同，否则就会发生编译错误。

界限中的类型的顺序是唯一重要的因素，这是由于类型变量的擦除是由其界限中的第一个类型确定的，并且类类型或类型变量只可能出现在第一个位置。

对于由相同泛型接口的不同参数化形成两个接口类型，类型变量不可能同时是这两个接口类型的子类型。

具有界限` T & I1 & ... & In `的类型变量X的成员是出现在声明类型变型变量那一点的交集类型` T & I1 & ... & In `的成员。





