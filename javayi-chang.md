# Java异常

异常指不期而至的各种状况，如：文件找不到，网络连接失败，非法参数。异常是一个事件，它生在程序运行期间，干扰了正常的指令流程。java通过API中Throwable类的众多子类描述各种不同的异常。因而，Java异常都是对象，是Throwable子类的实例，描述了出现在一段编辑码的错误条件。当条件生成时，错误将引发异常。

## Java异常类层次结构图：

![](/assets/import.png)
在Java中，所有的异常都有一个共同的祖先Throwable(可抛出)。Throwalbe指定代码中可用异常传播机制通过Java应用程序传输的任何问题的共性。

**Throwable:** 有两个重要的子类：Exception（异常）和 Error（错误），二者都是Java异常处理的重要子类，各自都包含大量子类。

**Error(错误)：**是程序无法处理的错误，表示运行应用程序中较严重问题。大多数错误与代码编写者执行的操作无关，而表示代码运行时JVM(Java虚拟机)出现的问题。例如，Java虚拟机运行错误(Virtual MachineError)，当JVM不再有继续执行操作所需的内存资源时，将出现OutOfMemoryError。这些异常发生时，Java虚拟机(JVM)一般会选择线程终止。
这些错误表示故障发生于虚拟机自身，或者发生在虚拟机试图执行应用时，如Java虚拟机运行错误(Virtual MachineError)，类定义错误（NoClassDefFoundError）等。这些错误是不可查的，因为它们在应用程序的控制和处理能力这外，而且约大多数是程序运行时不允许出现的状况。对于设计合理的应用程序来说，即使确实发生了错误，本质上也不应该试图去处理它所引起的异常状况。在Java中，错误通过Error的子类描述。

**Exception(异常)**：是程序本身可以处理的异常
Exception类有一个重要的子类RuntimeException。RuntimeException类及其子类表示"JVM常用操作"引发的错误。例如，若试图使用空值对象引用，除数为零或数组越界，则分别引发运行时异常(NullPointerException, ArithmeticException)和ArrayIndexOutOfBoundException。

> 注意：异常和错误的区别：异常能被程序本身可以处理，错误是无法处理。

通常，Java的异常(包括Exception和Error)分为**可查的异常**(checked exceptions) 和 **不可查的异常**(unchecked exceptions)。

**可查的异常（编译器要求必须处置的异常）**：正确的程序在运行中，很容易出现的，情理可容的异常状况。可查异常虽然是异常状况，但在一定程序上它的发生是可以预计的，而且一旦发生这种异常状况，就必须采取某种方式进行处理。

除了RuntimeException及其子类以外，其他的Exception类及其子类都属于可查异常。这种异常的特点是Java编译器会检查它，也就是说，当程序中可能出现这类异常，要么用try-catch语句捕获它，要么用throws子句声明抛出它，否则编译不会通过。

**不可查异常(编译器不要求强制处置的异常)：**包括运行时异常(RuntimeException与其子类)和错误（Error）。

**运行时异常**：都是RuntimeException类及其子类异常，如NullPointerException(空指针异常)，IndexOutOfBoundsException(下标越界异常)等，这些异常是不检查异常，程序中可以选择捕获处理，也可以不处理。这些异常一般是由程序逻辑错误引起的，程序应该从逻辑角度尽可能避免这类异常的发生。

运行是异常的特点是Java编译器不会检查它，也就是说，当程序中可能出现这类异常，即使没有用try-catch语句捕获它，也没有用throws子句声明抛出它，也会编译通过。

**非运行时异常（编译异常）：**是RuntimeException以外的异常，类型上都属于Exception类及其子类。从程序语法角度是必须进行处理的异常，如果不处理，程序就不能编译通过。如IOException, SQLException等以及用户自定义的Exception异常，**一般情况下不自定义检查异常**。

##处理异常机制
在Java应用程序中，异常处理机制为：抛出异常，捕捉异常。
**抛出异常：**当一个方法出现错误引发异常时，方法创建异常对象并交付运行时系统，异常对象中包含了异常类型和异常出现时的程序状态等异常信息。运行时系统负责寻找处置异常的代码并执行。
**捕获异常：**在方法抛出异常之后，运行时系统将转为寻找合适的异常处理器(exception handler)。潜在的异常处理器是异常发生时依次存留在调用栈的方法的集合。当异常处理器所能处理的异常类型与方法抛出的异常类型相符时，即为合适的异常处理器。运行时系统从发生异常的方法开始，依次回查调用栈中的方法，直至找到含有合适异常处理器的方法并执行。当运行系统遍历调用栈而未找到合适的异常处理器，则运行时系统终止。同时，意味着Java程序的终止。

对于运行时异常，错误或可查异常，Java技术所要求的异常处理方式有所不同。

由于**运行时异常**的不可查性，为了更合理，更容易地实现应用程序，Java规定，运行时异常将由Java运行系统自动抛出，允许应用程序忽略运行时异常。

对于方法运行中可能出现的Error，当运行方法不欲捕捉时，Java允许该方法不做任何抛出声明。因为，大多数Error异常属于永远不能被允许发生的状况，也属于合理的应用程序不该捕捉的异常。

对于所有的可查异常，Java规定：一个方法必须捕捉，或者声明抛出方法之外。也就是说，当一个方法选择不捕捉可查异常时，它必须专声明将抛出的异常。


能够捕捉异常的方法，需要提供相符类型的异常处理器。所捕捉的异常，可能是由于自身语句所引发并抛出的异常，也可能是由某个调用的方法或者Java运行时系统等抛出的异常。也就是说，一个方法所能捕捉的异常，一定是Java代码在某处所抛出的异常。简单地说，异常总是先被抛出，后被捕捉的。

任何Java代码都可以抛出异常，如：自已编写的代码，来自Java开发环境包中代码，或者Java运行时系统。无论是谁，都可以通过Java的throw语句抛出异常。

从方法中抛出的任何异常都必须使用throws子句。
捕捉异常通过try-catch语句或者try-catch-finally语句实现。
总体来说，Java规定：对于可查异常必须捕捉，或者声明抛出。允许忽略不可查的RuntimeException和Error。

## 捕获异常： try catch 和 finally 

1.try-catch语句
在Java中，异常通过try-catch语句捕获。其一般语法形式为：


```
try{
    //可能会发生异常的程序
}catch(Type1 id1){
    //捕获关处置try抛出的异常类型Type1
}catch(Type2 id2){
    //捕获并处置try抛出的异常类型Type2
}

```
关键词try后的一对大括号将一块可能发生异常的代码包起来，称为监控区域。Java方法在运行过程中出现异常，则创建异常对象。将异常抛出监控区域之外，由Java运行时系统试图寻找匹配的catch子句以捕获异常。若有匹配的catch子句，则运行其异常处理代码, try-catch语句结束。

匹配的原则是：如果抛出的异常对象属于catch子句的异常类，或者属于该异常的子类，则认为生成的异常对象与catch块捕获的异常类型相匹配。

#Java核心技术卷
## 捕获多个异常
在一个try语句中可以捕获多个异常类型，并对不同类型的异常做出不同的q处理。可以按照下列方式为每个异常类型使用一个单独的catch子名：


```
try{
    code that might throw exceptions
}catch(FileNotFoundException e){
    emergency action for missing files
}catch(UnknownHostException e){
    emergency action for unknown hosts
}catch(IOException e){
    emergency action for all other I/O problems
}

```

### mutil-catch
在Java SE 7中，同一个catch子句可以捕获多个异常类型。例如，假设对应缺少文件和未知主机异常的动作是一样的，就可以合并catch子句：


```
try{
    code that might throw exceptions
}catch(FileNotFoundException | UnknownHostException e){
    emergency action for missing files and unknown hosts
}catch(IOException e){
    emergency action for all other I/O problems
}
```
**只有当捕获的异常类型彼此之间不存在子类关系时才需要这个特性**

>注释：捕获多个异常时，异常变量隐含为final变量。例如，不能在以下子句体中为e赋不同的值：


```
catch(fileNotFoundException | UnknowHostException e){...}
```
>注释：捕获多个异常不仅会让你的代码看起来更简单，还会更高效。生成的字节码只包含一个对应公共catch子句的代码块。


##finally子句包含return语句
当finally子句包含return语句时，将会出现一种意想不到的结果。假设利用return语句从try语句块中退出。在方法返回前，finally子句的内容将被执行。如果finally子句中也有一个return语句，这个返回值将会覆盖原始的返回值。请看一个例子：


```
private int test14(int n) {
        try {
            int r = n * n;
            return r;
        }finally {
            if (n == 2) {
                return 0;
            }
        }
    }
```
如果调用f(2)，那么try语句块的计算结果为r=4,并执行return语句。然而，在方法真正返回前，还要执行finally子句。finally子句将使得方法返回0，这个返回值覆盖了原始的返回值4。

##带有资源的try语句
对于以下代码模式


```
open a resource
try{
    work with the resource
} finally{
    close the resource
}   
```
假设资源属于一个实现了AutoCloseable接口的类，Java SE 7为这种代码模式提供了一个很有用的快捷方式。AutoCloseable接口有一个方法：


```
void close() throws Exception
```

>注：另外，还有一个Closeable接口。这是AutoCloseable的子接口，也包含一个close方法。不过，这个方法声明为抛出一个IOException。

带资源的try语句(try-with-resources)的最简形式为:


```
try(Resource res = ...)
{
    work with res
}
```
try块退出时，会自动调用res.close()。下面给出一个典型的例子，这里要读取一个文件中的所有单词：


```
try(Scanner in = new Scanner(new FileInputStream("/usr/share/dict/words")))
{
    while(in.hasNext()){
        System.out.println(in.next());
    }
}
```
这个块正常退出时，或者存在一个异常时，都会调用in.close()方法，就好像使用了finally块一样。

还可以指定多个资源。例如：


```
try(Scanner in = new Scanner(new FileInputStream("/usr/share/dict/words")),
PrintWriter out = new PrintWriter("out.txt")){
    while(in.hasNext()){
        out.println(in.next().toUpperCase());
    }
}
```
不论这个块如何退出，in和out都会关闭。如果你用常规方式手动编程，就需要两个嵌套的try/finally语句。

上一节已经看到，如果try块抛出一个异常，而且close方法也抛出一个异常，这就会带来一个难题。带资源的try语句可以很好地处理种情况。原来的异常会重新抛出，而close方法抛出的异常会“被抑制”。这些异常将自动捕获，并由addSuppressed方法增加到原来的异常。如果对这些异常感兴趣，可以调用getSuppressed方法，它会得到从close方法抛出并被抑制的异常列表。

>注释：带资源的try语句自身也可以有catch了句和一个finally子句。这些子句会在关闭资源之后执行。不过在实际中，一个try语句中加入这么多内容可能不是一个好主意。




## 异常的异常链


```
public synchronized Throwable initCause(Throwable cause)

```
构造器


```
public Throwable(Throwable cause) {...
```



```
public Throwable(String message, Throwable cause) {...
```


















