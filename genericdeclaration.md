# GenericDeclaration 泛型声明接口

声明类型变量\(type variables\)的所有实体的公共接口

```java
public interface GenericDeclaration extends AnnotatedElement{
    /**
    * 返回声明顺序的TypeVariable对象的数组，这些对象表示由此GenericDeclaration对象表示的一般声明声明的类型变量。
    * 如果底层的一般声明未声明任何类型变量，则返回一个0长度的数组。
    **/
    public TypeVariable<?>[] getTypeParameters();
    
```





