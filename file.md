# Field

![](/assets/snapshot37.png)

## 方法摘要

* isEnumConstant\(\):  检测成员是否是枚举的常量
* getType\(\):                返回一个Class对象，它标识了此Field对象所表示字段的声明类型: 如java.util.List的class对象
* getGenericType\(\):   返回带泛型的声明类型如: java.util.List&lt;E&gt;

---

* toString\(\):                 public java.util.List com.jianglei.field.ClassA.list
* toGenericString\(\)     public java.util.List&lt;E&gt; com.jianglei.field.ClassA.list     

---

* get\(Object obj\)

如果是基本类型 -&gt; 返回包装类型  
如果此字段是static，那么参数obj会被忽略，所也obj可以是null

```java
public class ClassA<E> {
    private String name = "dengyi";

    public static Integer age = 28;

    public List<E> list = new ArrayList<>();


    public static void main(String[] args) throws 
        NoSuchFieldException, IllegalAccessException {

        Class<ClassA> cls = ClassA.class;
        Field age = cls.getDeclaredField("age");
        Object o = age.get(null);
        System.out.println(o);
    }

}
```

如果此字段不是static，那么其是一个实例字段。如果指定的obj为null，则会抛出一个NullPointerException。如果指定的obj不是此class的实例将会抛出IllegalArgumentException

```java
public class ClassA<E> {
    private String name = "dengyi";

    public static Integer age = 28;

    public List<E> list = new ArrayList<>();


    public static void main(String[] args) throws 
    NoSuchFieldException, IllegalAccessException {
        Class<ClassA> cls = ClassA.class;
        Field age = cls.getDeclaredField("list");//throw NullPointerException
    }

}
```

如果此字段带有private等访问权限，说明此字段不可以被访问，此方法会抛出一个IllegalAccessException

最后，值会被从实例或静态字段中提取出来。如果字段是基本类型，将会包装成引用类型，否则原封不动的返回

```java
public class ClassA<E> {
    private String name = "dengyi";

    public static Integer age = 28;

    public List<E> list = new ArrayList<>();

}
```



