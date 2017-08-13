# public String replace\(CharSequence target, CharSequece replacement\)

会替换所有的字符

```java
className = "a.b.c.A$B$$CC";
String replace = className.replace(".", "+");
System.out.println(replace); //output: a+b+c+A$B$$CC
```



