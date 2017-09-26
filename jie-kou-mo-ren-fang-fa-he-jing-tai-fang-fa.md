# 接口默认方法和静态方法

## 默认方法

默认方法让我们能给我们的软件库的接口增加新的方法，并且能保证对使用这个接口的老版本代码的兼容性

如Iterator里的remove方法

```java
public interface Iterator<E>{
    boolean hasNext();
    
    E next();
    
    default void remove() {
        throw new UnsupportedOperation();
    }
}
```

## 继承含有默认方法的接口

* 不去管默认方法，继承的接口直接继承默认方法
* 重新声明默认方法，这样会使得这个方法变成抽象方法
* 重新定义默认方法，这样会使得方法被重写



## 静态方法

在Java8的接口中，我们不光能写默认方法，还能写表态方法。下面的例子中正好用到了静态方法

```java
public interface TimeClient{
    static public String getZoneId(String ze){
        return re;
    }
    
    default public String getZoneId2(){
        return getZoneId2();
    }
    
```







