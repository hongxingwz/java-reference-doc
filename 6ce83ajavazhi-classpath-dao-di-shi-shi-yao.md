# java之classpath到底是什么

如果你输入一个命令，比如
java
那么系统是如何找到这个命令的呢?
按照顺序，系统先在当前目录搜索是否有java.ext, java.bat等。如果没有，就得到系统的PATH(不区分大小写)里面查找。

比如你的环境变量的PATH里面有C:\program files\java\jdk1.6\bin
那么系统会尝试在这个目录下面查找，并且找到java.exe那么就会执行它。

所以path就是系统为了搜索某个资源而配置的一个参数。多个目录之间用分号(linux里面用冒号)分割。

那么CLASSPATH呢?同样的道理，当我们需要某个class时，系统会自动在CLASSPATH里面搜索，如果是jar，就自动从jar里面查找，如果是普通的目录，则在目录下面按照package进行查找。
但与PATH不同的是，默认的CLASSPATH是不包含当前目录的，这也是CLASSPATH里面要包含一个点的道理了。

Tomcat下的Web应用有两个预置的classpath: WEB-INF/classes 和 WEB-INF/lib启动项目，项目就会加载这两个目录里的数据。这是war包的堆满。要改变预置的classpath比较麻烦，在Tomcat的预置文件里没有发现类似的配置，要实现自己的classloader才能达到目的。

一个tomcat中运行的web应用。它的classpath都包括如下目录：
%tomcat%/lib
web-inf/lib
web-inf/classes
环境变量里的classpath
总结:classpath这是一个定位资源的入口.classpath下lib的优先级大于classes;