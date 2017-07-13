# Executable

* getParameterTypes\(\): 返回一个代表正常参数类型\(parameter types\)的数组，以声明时的顺序。如果没有参数返回一个长度为0的数组

```java
public class MethodA<K extends Object & Serializable, V extends Number & Serializable> {

    public <T extends Number & Serializable> void method(T t) {

        System.out.println("I am invoked");
    }

    public void sayHello(String name, Integer age, String love, String yijie) {

    }

}

class MethodATest{
    public static void main(String[] args) throws
             NoSuchMethodException, InvocationTargetException, IllegalAccessException {
             
        Class<MethodA> methodAClass = MethodA.class;
        Method[] methods = methodAClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder sb = new StringBuilder();
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                sb.append(parameterType.getSimpleName())
                        .append(' ');
            }

            System.out.println(sb);
            System.out.println("----------------");
        }

    }
}
/*
output:

Number 
----------------
String Integer String String 
----------------
*/
```

* getParameterCount\(\);



