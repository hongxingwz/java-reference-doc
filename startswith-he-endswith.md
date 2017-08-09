# startsWith 和 endsWith

**startsWith\(String, int\)**

判断字符是否以prefix开始

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

```java
public boolean endsWith(String suffix){
    return startsWith(suffix, value.length - suffix.value.length);
}
```

## 总结

**“abcde”.endsWith\(""\) ==&gt; 返回true**

**"abcde".startsWith\(""\) ==&gt; 返回true**

**方法参数prefix 和 suffix 为null 时会抛出NullPointerException**

**代码注释的那块代码在次体现出了JDK的严紧，作为coder的我表示汗颜**

```java
//Note: toffset might be near -1 >>> 1 也就是 Integer.MAX_VALUE
boolean result = (toffset > value.length - pc);

//平时我作的判断 在toffset 和 pc 非常大的时候 极有可能发生整数溢出啊！！！！！！！！！
boolean result2 = (toffset + pc) > value.length;
```

**三个方法最核心的方法也就是startsWith\(String, int\) ，真的是很巧妙。我什么时候能构思出这样的代码呢？？？？？？？？？**



