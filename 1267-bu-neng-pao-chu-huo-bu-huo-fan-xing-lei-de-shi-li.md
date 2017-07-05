# 不能抛出或捕获泛型类的实例

即不能抛出也不能捕获泛型类对象。实际上，甚至泛型类扩展Throwable都是不合法的。

例如，以下定义就不能正常编译

```java
public class Problem<T> extends Exception{
    /* ... */
}//ERROR -- cant't extend Throwable
```

catch子句中不能使用类型变量。例如，以下方法将不能编译：

```
public static <T extends Throwable> void doWork(Class<T> t){
    try{
        do work
    }catch(T e) //ERROR -- can't catch type variable
    {
        Logger.global.info(...)
    }
}
```

不过，在异常规范中使用类型变量是允许的。以下方法是合法的：



