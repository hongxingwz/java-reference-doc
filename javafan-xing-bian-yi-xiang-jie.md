# Java泛型详解

java泛型应用是java核心基础之一，从Java5开始引进泛型。如果你曾经使用过Java Collection,那么已经算是接触过泛型了。在Java Collection里使用泛型是一件很简单的事情，可泛型还具有很多你意想不到的作用。在深入也解泛型之前，首先来了解一下泛型的一些基本概念与原理。

## 一、java泛型引入
java泛型的应用可以提高代码的复用性，同时泛型提供了类型检查，减少了数据的类型转换，同时保证了类型安全。下面看一下，泛型如何保证了类型安全：



```
List list = new ArrayList();
list.add("abc");
list.add(new Integer(1)); //可以通过编译
for (Object o : list) {
    System.out.println((String)o); 抛出ClassCastException异常
}
```
上面的代码会在运行时抛出ClassCastException，因为它尝试将一个Integer转换为String。接着，来看一下从Java5开始，Collection的用法：


```
List<String> list = new ArrayList<>();
list.add("abc");
//list.add(new Integer(1)); //编译错误
for (String s : list) {
    System.out.println(s); 无需任何强制类型转换
}
```
注意到，List的创建增加了类型参数String，因此只能向list添加String类型对象，添加其他对象会抛出异常；同样可以注意到，foreach循环不需要再添加任何强制类型转换，也就移除了运行时ClassCastException异常。


## 泛型的类与接口
既然是学泛型，自然就要知道如何去使用泛型定义自己的类和接口。同时为了加泛理解泛型的作用，先引进一个原始的类：



```
class Gen {
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        Gen gen = new Gen();
        gen.setObj("abc");

        String str = (String) gen.getObj(); //类型转换，可能会引起运行时ClassCastException
        System.out.println(str);
    }
}
```
原始类的定义，容易引发ClassCastException,和第一大点谈到的类似。现在来看一下泛型类来重亲定义Gen -- 使用<>指定泛型参数，如下：


```
class Gen2<T> {
    T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        Gen2<String> gen = new Gen2<>();
        gen.setObj("abc");
       // gen.setObj(10); //无法通过编译
        String obj = gen.getObj(); //无需类型转换
        System.out.println(obj);

        //-----------
        Gen2 gen2 = new Gen2<>(); // raw type原始类型
        gen2.setObj("abc");
        gen2.setObj(10); //可以通过编译，自动装箱将10转化为Integer对象
        Integer num = (Integer) gen2.getObj(); //使用了强制类型转换
        System.out.println(num);
    }
}
```
细心的你会发现在main()方法里是使用泛型类Gen&lt;String&gt;，便不再需要强制类型转换，也就移除了运行时的ClassCastException。同时为了区别，在此也定义了一个没有使用泛型类型的gen2，这时，编译器会弹出一个警告“Gen is a raw type, References to generic type Gen&lt;T&gt; should be parameterized”。当我们不提供泛型类型时，会默认使用Object会代替，也是因此这样，gen2可以设置String和Integer类型，不过，我们应尽量去避免这种情况出现，如引，便又需要用到强制类型转换，也伴随运行时的ClassCastException异常。

>注：可以使用@SuppressWarnings("rawtypes")来抑制编译器弹出警告。

接口的泛型应用和类的泛型应用很类似，如下：


```
public interface List<E>{
    void add(E x);
    Iterator<E> iterator();
}

public interface Interator<E>{
    E next();
    boolean hasNext();
}
```

类似的，可以将此应用到自定义的接口与类当中。另外再提一下的是，可以使用多个泛型参数来定义接口与类，比如&lt;K, V&gt;;同时，泛型类型也可以作为一个参数来用，如下：new HashMap&lt;String, List&lt;String&gt;&gt;()。








