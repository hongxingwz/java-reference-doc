# 基本语法

下面的例子中，使用@Test对testExecute\(\)方法进行注解。该注解本身并不做任何事情，但是编译器要确保在其构造路径上必须有@Test注解的定义。

```java
public class Testable{
    public void execute(){
        System.out.println("Executing...");
    }
    
    @Test
    void testExecute(){
        execute();
    }
}
```

注解的使用方式几乎与修饰符的使用一模一样

