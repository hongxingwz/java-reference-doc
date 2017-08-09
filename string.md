```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence{

        private final char value[];

        //转换为字符数组
        public char[] toCharArray(){
            //Cannot use Arrays.copyOf because of class initialization order issues
            char result[] new char[value.length];
            System.arraycopy(value, 0, result, 0, value.length);

            return result;
        }
```

* **startsWith\(String, int\)**

**startsWith\(String, int\)**

判断字符是否以prefix开始  
"abcde".startsWith\(""\) ==&gt; 返回true



代码注释的那块代码在次体现出了JDK的严紧，作为coder的我表示汗颜

```java
//Note: toffset might be near -1 >>> 1 也就是 Integer.MAX_VALUE
boolean result = (toffset > value.length - pc);

//平时我作的判断  在toffset 和 pc 非常大的时候 极有可能发生整数溢出啊！！！！！！！！！
boolean result2 = (toffset + pc) > value.length;
```

```java
public boolean startsWith(String prefix, int toffset){
    char ta[] = value;
    int to = toffset;
    char pa[] = prefix.value;
    int po = 0;
    int pc = prefix.value.length;

    //Note: toffset might be near -1 >>> 1 也就是 Integer.MAX_VALUE
    if((toffset < 0) || (toffset > value.length - pc)){
        return false;
    }

    while(--pc >= 0){
        if(ta[to++] != pa[po++]){
            return false;
        }
    }

    return true;
}
```



**startsWith\(String\)**

```java
public boolean startsWith(String prefix){
    return startsWith(prefix, 0);
}
```



**endsWith\(String\)**

判断字符是否以suffix结尾

“abcde”.endsWith\(""\) ==&gt; 返回true

```java
public boolean endsWith(String suffix){
    return startsWith(suffix, value.length - suffix.value.length);
}
```



