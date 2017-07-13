# TypeVariable 类型变量

## 测试类

```java
public class MethodA<K extends Object & Serializable, V extends Number & Serializable> {

    public <T extends Number & Serializable> void method(T t) {
    }

}
```

## 源码

```java
public interface TypeVariable<D extends GenenricDelaration> extends Type, AnnotatedElement{

    Type[] getBounds();

    D getGenericDeclaration();

    String getName();

    //1.8 added
    AnnotatedType[] getAnnotatedBounds();
}
```

## Type\[\] getBounds\(\)

返回表示此类型变量上边界的Type对象数组。注意，如果未显式声明上边界，则上边界为Object。

```java
public class MethodA<K extends Object & Serializable, V extends Number & Serializable> {

    public <T extends Number & Serializable> void method(T t) {
    }

    public static void main(String[] args) {
        Class<MethodA> clz = MethodA.class;
        TypeVariable<?>[] typeParameters = clz.getTypeParameters();
        for (TypeVariable<?> typeParam : typeParameters) {
            Type[] bounds = typeParam.getBounds();
            for (Type bound : bounds) {
                System.out.println(bound.getTypeName());
            }
            System.out.println("----------");
        }

    }
}
```

## D getGenericDeclaration\(\)

返回定义此泛型的类

```
class com.jianglei.method.MethodA
```



