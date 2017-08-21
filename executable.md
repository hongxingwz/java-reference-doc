# Executable

* **Class&lt;?&gt;\[\] getParameterTypes\(\): **

返回一个代表正常参数类型\(parameter types\)的数组，以声明时的顺序。如果没有参数返回一个长度为0的数组

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

* **int getParameterCount\(\):**

返回可执行对象参数的数量

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
            System.out.println(method.getParameterCount());
            System.out.println("----------------");
        }

    }
}
/*
1
----------------
4
----------------
*/
```

* Type\[\] getGenericParameterTypes\(\)：

获取泛型参数类型

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
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            for (Type type : genericParameterTypes) {
                sb.append(type.getTypeName())
                        .append(' ');
            }

            System.out.println(sb);
        }

    }
}
/*
T 
java.lang.String java.lang.Integer java.lang.String java.lang.String 
*/
```

* Class&lt;?&gt; getExceptionTypes\(\);

```java
public class MethodA<K extends Object & Serializable, V extends Number & Serializable> {

    public <T extends Number & Serializable> void method(T t) throws
                        ArrayIndexOutOfBoundsException, IllegalStateException{

        System.out.println("I am invoked");
    }

    public void sayHello(String name, Integer age, String love, String yijie, Object... obj)
        throws NullPointerException, IllegalArgumentException{

    }

}

class MethodATest{
    public static void main(String[] args) throws
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<MethodA> methodAClass = MethodA.class;
        Method[] methods = methodAClass.getDeclaredMethods();
        for (Method method : methods) {
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println(exceptionType.getSimpleName());
            }
            System.out.println("--------------");
        }

    }
}
/*
output:

ArrayIndexOutOfBoundsException
IllegalStateException
--------------
NullPointerException
IllegalArgumentException
--------------
*/
```

* Type\[\] getGenericExceptionTypes\(\)

```java
public class MethodA<K extends Object & Serializable, V extends Number & Serializable> {

    public <T extends Number & Serializable> void method(T t) throws
                        ArrayIndexOutOfBoundsException, IllegalStateException{

        System.out.println("I am invoked");
    }

    public void sayHello(String name, Integer age, String love, String yijie, Object... obj)
        throws NullPointerException, IllegalArgumentException{

    }

}

class MethodATest{
    public static void main(String[] args) throws
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<MethodA> methodAClass = MethodA.class;
        Method[] methods = methodAClass.getDeclaredMethods();
        for (Method method : methods) {
            Type[] genericExceptionTypes = method.getGenericExceptionTypes();
            for (Type type : genericExceptionTypes) {
                System.out.println(type.getTypeName());
            }
            System.out.println("-------------");
        }

    }
}
/*
output:

java.lang.ArrayIndexOutOfBoundsException
java.lang.IllegalStateException
-------------
java.lang.NullPointerException
java.lang.IllegalArgumentException
-------------
*/
```

* String toGenericString\(\);

```java
public class MethodA<K extends Object & Serializable, V extends Number & Serializable> {

    public <T extends Number & Serializable> void method(T t) throws
                        ArrayIndexOutOfBoundsException, IllegalStateException{

        System.out.println("I am invoked");
    }

    public void sayHello(String name, Integer age, String love, String yijie, Object... obj)
        throws NullPointerException, IllegalArgumentException{

    }

}

class MethodATest{
    public static void main(String[] args) throws
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<MethodA> methodAClass = MethodA.class;
        Method[] methods = methodAClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.toGenericString());
        }

    }
}
/*
public <T> void com.jianglei.method.MethodA.method(T) throws java.lang.ArrayIndexOutOfBoundsException,java.lang.IllegalStateException
public void com.jianglei.method.MethodA.sayHello(java.lang.String,java.lang.Integer,java.lang.String,java.lang.String,java.lang.Object...) throws java.lang.NullPointerException,java.lang.IllegalArgumentException
*/
```

* Parameter\[\] getParameters\(\)
* boolean isVarArgs\(\)
* Annotation\[\]\[\] getParameterAnnotations\(\);
* AnnotatedType getAnnotatedReturnType\(\);
* AnnotatedType getAnnotatedReceiverType\(\);
* getAnnotatedParameterTypes\(\);
* getAnnotatedExceptionTypes\(\);



