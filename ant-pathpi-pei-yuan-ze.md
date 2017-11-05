Ant path匹配原则

路径匹配原则\(Path Matching\) Spring MVC中的路径匹配要比标准的web.xml要灵活的多。默认的策略实现了org.springframework.util.AntPathMatcher，就像名字提示的那样，路径模式是使用了Apache Ant的样式路径，Apache Ant样式的路径有三种通配符匹配方法\(在下面的表格中列出\)

这些可以组合出多种灵活的路径模式

| Wildcard | Description |
| :--- | :--- |
| ? | 匹配任何单字符 |
| \* | 匹配0或者任意数量的字符 |
| \*\* | 匹配0或者更多的目录 |

Ant样式路径模式

| Path | Description |
| :--- | :--- |
| /app/\*.x | 匹配所有App路径下的.x文件 |
| /app/p?ttern | 匹配/app/pattern 和 /app/pXttern，但是不包括/app/pttern |
| /\*\*/example | 匹配/app/example, /app/foo/example，和/example |
| /app/\*\*/dir/file | 匹配/app/dir/file.jsp, /app/foo/dir/file, /app/foo/bar/dir/file.pdf, 和 /app/dir/file.java |
| /\*\*/\*.jsp | 匹配任何的.jsp文件 |



## AntPathMatcher

org.springframework.util.AntPathMatcher类

The mapping matches URLs using the following rules:

* ? matches one character
* \* matches zero or more charact
* \*\* matches zero or more directories in a path
* {spring:[a-z]+} matches the regexp [a-z]+ as a path variable named "spring"

###例子
* com/t?st.jsp - matches com/test.jsp but also com/test.jsp or com/txst.jsp
* com/*.jsp - matches all .jsp files in the com directory
* com/**/test.jsp - matches all test.jsp files underneath the com path
* org/springframework/**/*.jsp - matches all .jsp files underneath the org/spring/framework path
* org/**/servlet/bla.jsp - matches org/springframework/servlet/bla.jsp bus also org/springframework/testing/servlet/bla.jsp an org/servlet/bla.jsp 
* com/{filename:\\w+}.jsp will match com/test.jsp and assign the value test to the filename variable


