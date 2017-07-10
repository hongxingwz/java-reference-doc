# 1.1 获取Class实例的三种形式

## 通过类获取

实际上告诉我们任何一个类都有一个隐含的静态成员变量

```java
Class<Object> clz = Object.class
```

## 通过类的实例获取

```java
Object obj = new Object();
Class<?> clz = obj.getClass();
```

## 通过类的QualifiedName获取

```java
Class<?> clz = null;
try {
    clz = Class.forName("java.lang.Object");
} catch (ClassNotFoundException e) {
    e.printStactTrack();
}

```



