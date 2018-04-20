# Java基础\(17\)：常用类--Sytem类的标准流重定向与常用方法

System类的作用

* System类提供了标准输入、标准输出和错误输出流。
* 对外部定义的属性和环境变量的访问。
* 加载文件和库的方法。
* 还有快速复制数组的一部分的实用方法。

## 了解System.in、System.out、System.err

它们都属于System类的表态变量。

* System.in 标准输入流\(从键盘输入\)
* System.out 标准输出流\(输出到控制台\)
* System.err 标准错误输出流\(输出的字体颜色是红色\)

代码演示System.in:

```
//把标准输入作为扫描的数据源
Scanner sc = new Scanner(System.in);
//将标准输入作为数据源
BufferedReader bis = new BufferedReader(
                  new InputStreamReader(System.in));
```

代码演示System.out:

```
//简单使用System.out
System.out.print("ABC");//不换行
System.out.println("DEF");//换行
//对System.out进行包装处理
Writer bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write("完成控制台输出");
bw.append("OKOKOKOKOK"); //等效于print()
bw.flush();//刷出缓冲区
```

System.err输出的字体颜色是红色，最常见到的就是打印异常信息时，都是红色，就是使用该流来打印的。

**System对标准流进行重定向：**  
原来的标准默认是键盘输入和输出到控制台，重定向则是分配标准流，表示可以使用别的流作为标准。方法如下：

* static void setIn\(InputStream in\)
* static void setOut\(PrintStream ps\)
* static void setErr\(PrintStream ps\)

**System类的常用方法：**

|方法  | 解释 |
| :--- | :--- |
|static long currentTimeMillis\(\)      |返回以毫秒为单位的当前时间。   |
|static void exit\(int status\)     |终止当前正在运行的 Java 虚拟机。  |
|static Properties getProperties\(\)   |  获取当前系统的所有属性。  |
|static String getProperty\(String key\)   |  获取指定键指示的系统属性。  |
|static int identityHashCode\(Object x\)  |   返回给定对象的原始哈希码Hashcode\(\)  |
|static void load\(String filename\)     | 从动态库的本地文件中以指定的文件名加载代码文件。   |
|static void loadLibrary\(String libname\)  |    加载由 libname 参数指定的系统库。   |
|static void setProperties\(Properties props\)   |   将系统属性设置为 Properties 参数。   |
|static String setProperty\(String key, String value\)   |   设置指定键指示的系统属性。   |
|static void setSecurityManager\(SecurityManager s\)    |  设置系统安全性。   |
|static long nanoTime\(\)     |  返回最准确的可用系统计时器的当前值，以毫微秒为单位  |
|static String getenv\(String name\)  |    获取指定的环境变量值。  |
|static void gc\(\)   |   运行垃圾回收器。|

