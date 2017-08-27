# java之classpath到底是什么

如果你输入一个命令，比如  
java  
那么系统是如何找到这个命令的呢?  
按照顺序，系统先在当前目录搜索是否有java.ext, java.bat等。如果没有，就得到系统的PATH\(不区分大小写\)里面查找。

比如你的环境变量的PATH里面有C:\program files\java\jdk1.6\bin  
那么系统会尝试在这个目录下面查找，并且找到java.exe那么就会执行它。

所以path就是系统为了搜索某个资源而配置的一个参数。多个目录之间用分号\(linux里面用冒号\)分割。

那么CLASSPATH呢?同样的道理，当我们需要某个class时，系统会自动在CLASSPATH里面搜索，如果是jar，就自动从jar里面查找，如果是普通的目录，则在目录下面按照package进行查找。  
但与PATH不同的是，默认的CLASSPATH是不包含当前目录的，这也是CLASSPATH里面要包含一个点的道理了。

Tomcat下的Web应用有两个预置的classpath: WEB-INF/classes 和 WEB-INF/lib启动项目，项目就会加载这两个目录里的数据。这是war包的堆满。要改变预置的classpath比较麻烦，在Tomcat的预置文件里没有发现类似的配置，要实现自己的classloader才能达到目的。

一个tomcat中运行的web应用。它的classpath都包括如下目录：  
%tomcat%/lib  
web-inf/lib  
web-inf/classes  
环境变量里的classpath  
总结:classpath这是一个定位资源的入口.classpath下lib的优先级大于classes;



# 浅析JAVA\_HOME, CLASSPATH和PATH的作用

**1.设置JAVA\_HOME:java的目录**

一，**为了方便引用**，比如，你JDK安装在C:\ProgramFiles\Java\jdk1.7.0目录里，则设置JAVA\_HOME为该目录路径，那么以后你要使用这个路径的时候，只需要输入%JAVA_HOME%即可，避免每闪引用都输入很长的路径串；

二，**归一原则**，当你JDK路径被迫改变的时候，你仅需要更改JAVA\_HOME的变量值即可，否则，你就要更改任何用绝对路径引用JDK目录的文档，要是万一你没有改全，某个程度找不到JDK，后果是可想而知的----系统崩溃！

三，第三方软伯会引用JAVA\_HOME变量，不然，你将不能正常使用该软件，以后用JAVA久了就会知道，要是某个软件不能正常使用，不妨想想是不是这个问题。

2.**设置CLASSPATH：**
为了找到执行目标，java不同于linux上的可执文件，linux的可执文件提前都编译链接好了，最终是一个打包好的文件。java有一堆可执文件：\*.class文件。CLASSPATH就是约定class文件的查找路径。
这是一个比较折磨初学者的问题，这个变量设置的目的是为了程序能找到相应的".class"文件，不妨举个例子:你编译一个JAVA程序--A.java,会得到一个A.class的类文件，你在当前目录下执行java A,将会得到相应的结果(前提是你已经设置CLASSPATH为".")。现在，你把A.class移到别的目录下(例如:"e:\"),执行java A，将会有NoClassDefFindError的异常，原因就是找不到.class文件，现在你把CLASSPATH增加为:".;e:\"再在任何目录下运行java A,看看会有什么结果 ~~:)~~~,一切正常，java命令通过CLASSPATH找到了.class文件！

classpath=c:\test就表示执行运行命令时去c:\test文件夹去找需要被执行的class文件在java5之前该路径是不能指定当前路径的，除非这样设置:classpath=.;c:\test，就表示在当前目录找class文件，要是没找到就到c:\test去找;(当一个变量有多个值时，多个值之间是有英文的分号隔开)
设置从当前所在目录找(java1.5后默认):set classpath=.

**3,设置PATH:(必须设置)**
道理很简单，你想在任何时候使用%JAVA_HOME%\bin\java等来执行java命令吗，当然不会，于是，你可选择把%JAVA_HOME%\bin添加到PATH路径下，这样，我们在任何路径下就可以仅用java来执行命令了。
(当你在命令提示符窗口输入你的代码时，操作系统会在当前目录和PATH变量目录里查找相应的应用程序，并且执行。)



