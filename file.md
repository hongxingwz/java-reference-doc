# Field

## UML图

![](/assets/snapshot37.png)

## 测试类

```java
public class ClassA<E> {
    private String name = "dengyi";

    public static Integer age = 28;

    public List<E> list = new ArrayList<>();

}
```

## 方法摘要

* isEnumConstant\(\):  检测成员是否是枚举的常量
* getType\(\):                返回一个Class对象，它标识了此Field对象所表示字段的声明类型: 如java.util.List的class对象
* getGenericType\(\):   返回带泛型的声明类型如: java.util.List&lt;E&gt;

---

* toString\(\):                 public java.util.List com.jianglei.field.ClassA.list
* toGenericString\(\)     public java.util.List&lt;E&gt; com.jianglei.field.ClassA.list     

---

* **get\(Object obj\)**

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
        Field list = cls.getDeclaredField("list");
        list.get(null); //throw NullPointerException
        list.get(new Object()); //throw IllegalArgumentException
    }

}
```

如果此字段带有private等访问权限，说明此字段不可以被访问，此方法会抛出一个IllegalAccessException

```java
public class ClassA<E> {
    private String name = "dengyi";

    public static Integer age = 28;

    public List<E> list = new ArrayList<>();

}

class ClassATest{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<ClassA> cls = ClassA.class;
        Field name = cls.getDeclaredField("name");
        name.get(new ClassA()); //throw IllegalAccessException

    }
}
```

最后，值会被从实例或静态字段中提取出来。如果字段是基本类型，将会包装成引用类型，否则原封不动的返回

```java
public class ClassA<E> {
    private String name = "dengyi";

    //基本类型
    public static int age = 28;

    public List<E> list = new ArrayList<>();


    public static void main(String[] args) throws
                        NoSuchFieldException, IllegalAccessException {
        Class<ClassA> cls = ClassA.class;
        ClassA classA = new ClassA();

        Field age = cls.getField("age");
        Field list = cls.getField("list");

        Object o = age.get(classA);
        System.out.println(o instanceof Integer); //基本类型返回其包装类

        Object o1 = list.get(classA);
        System.out.println(o1 instanceof List); //引用类型原样返回

    }
}
```

---

* set\(Object obj, Object value\)

这个方法的处理流程如下：

如果字段是静态的，**obj**字段会被忽略，**obj**字段可以为null

```java
public class ClassA<E> {
    private String name = "dengyi";

    public static int age = 28;

    public List<E> list = new ArrayList<>();


    public static void main(String[] args) throws
                        NoSuchFieldException, IllegalAccessException {
        Class<ClassA> cls = ClassA.class;

        Field age = cls.getField("age");
        age.set(null, 18); //obj 参数可以为null
        System.out.println(ClassA.age); //output: 18

    }
}
```

否则此字段是一个实例的字段，如指定的obj参数为null，则会抛出一个NullPointerException。如果指定的obj参数不是此class的实例，则会抛出一个IllegalArgumentException

```java
public class ClassA<E> {
    private String name = "dengyi";

    public static int age = 28;

    public List<E> list = new ArrayList<>();


    public static void main(String[] args) throws
                        NoSuchFieldException, IllegalAccessException {
        Class<ClassA> cls = ClassA.class;

        Field list = cls.getField("list");
        list.set(null, new ArrayList()); //throw NullPointerException

        list.set(new Object(), new ArrayList()); //throw IllegalArgumentException

    }
}
```

如果字段是Java的访问控制之后，且此字段是不可访问的，此方法会抛出一个IllgealAccessException

```java
public class ClassA<E> {
    private String name = "dengyi";

    public static int age = 28;

    public List<E> list = new ArrayList<>();



}
class ClassATest{
    public static void main(String[] args) throws
            NoSuchFieldException, IllegalAccessException {
        Class<ClassA> cls = ClassA.class;

        Field name = cls.getDeclaredField("name");
        name.set(new ClassA(), "jianglei"); //throw IllegalAccessException

    }
}
```



