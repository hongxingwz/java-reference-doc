# Objects

为了防止该类被实例化，构造器私有化，并在内部抛出一个异常\(经典\)

```java
private Objects() {
    throw new AssertionError("No java.util.Objects instances for you");
```

**public static boolean equals\(Object a, Object b\)**

如果两个对象是同一个实例或两个对象都为null，则返回true

如果一个对象为null，一个对象不为null,则返回false

到最后会返回a.equals\(b\)方法的返回值

```java
public static boolean equals(Object a, Object b){
    return (a == b) || (a != null && a.equals(b));
}
```

**public static boolean deepEquals\(Object a, Object b\)**  
检测两个对象是否深度相等

---

**public static int hashCode\(Object o\)**  
如果为null返回0

```java
public static int hashCode(Object o){
    return o == null ? 0 : o.hashCode();
}
```
**public static int hash(Object... values)**
返回一组对象的hash值，如果参数为null返回0,如果参数为空数组返回1



```java
public static int hash(Object... values){
    return Arrays.hashCode(values);
}

```

---

**public static String toString(Object o)**
如果参数为null返回"null"，否则返回o.toString()


```java
public static String toString(Object o){
    return String.valueOf(o);
}
//String.valueOf(Object obj)方法实现
public static String valueOf(Object obj){
    return (obj == null) ? "null" : obj.toString();
}
```

**public static String toString(Object o, String nullDefault)**
如果o为null返回nullDefault。否则返回o.toString()


```java
public static String toString(Object o, String nullDefault){
    return (o == null)? nullDefault : o.toString();
}
```

---


**public static <T> T requireNonNull(T obj)**
如果为null 抛出NullPointer异常


```java
public static <T> T requireNonNull(T obj){
    if(obj == null){
        throw new NullPointerException();
    }
    return obj;

```


**public static <T> T requireNonNull(T obj, String message)**
如果为null 抛出message的异常


```java
public static <T> T requireNonNull(T obj, String message){
    if(obj == null){
        throw new NullPointerException(message);
    }
    retrun obj;   
}
```

---

**public static boolean isNull(Object obj)**
判断此指定参数是否为null


```java
public static boolean isNull(Object obj){
    return obj == null;
}

```

**public static boolean nonNull(Object obj)**
判断指定参数是否非null


```java
public static boolean nonNull(Object obj){
    return obj != null;
}
```

---
**public static <T> int compare(T a, T b, Comparator<? super T> c**


```java
public static <T> int compare(T a, T b, Comparator<? super T> c){
    return (a == b) ? 0 : c.compare(a, b);
}

```











