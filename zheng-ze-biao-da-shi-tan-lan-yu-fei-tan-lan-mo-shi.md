# 正则表达式贪婪与非贪婪模式

之前做程序的时候看一过正则表达式的贪婪与非贪婪模式，今天用的时候就想不起来了，现在这里总结一下，以备自己以后用到时注意。

## 1. 什么是正则表达式的贪婪与非贪婪匹配

如

```
String str = "abcaxc"
Pattern p = Pattern.compile("ab.*c")
```

**贪婪匹配：**正则表达式一般趋向于最大长度匹配，也就是所谓的贪婪匹配。如上面使用模式p匹配的字符串str，结果就是匹配到: **abcaxc**

**非贪婪匹配：** 就是匹配到结果就好，就少的匹配字符。如上面使用模式p匹配字符串str，结果就是匹配到: **abc**

## 2. 编程中如何区分两种模式

默认是贪婪模式；在量词后面直接加上一个问号？就是非贪婪模式。  
**量词：** {m, n}： m到n个

* \*： 表示任意多个
* +: 一个到多个
* ?: 0或一个

## 3. 实用程序

使用Snort的规则一条规则的一部分作为匹配文本，匹配出其中的content部分。

```
    @org.junit.Test
    public void test21() {
        String text = "(content:\"rcpt to root\";pcre:\"word\";)";
        String rule1 = "content:\".+\"";
        String rule2 = "content:\".+?\"";

        Pattern compile = Pattern.compile(rule1);
        Matcher matcher = compile.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(0));    // content:"rcpt to root";pcre:"word"
        }


        Pattern compile1 = Pattern.compile(rule2);
        Matcher matcher1 = compile1.matcher(text);
        while (matcher1.find()) {
            System.out.println(matcher1.group(0));    // content:"rcpt to root"    
        }

    }
```



