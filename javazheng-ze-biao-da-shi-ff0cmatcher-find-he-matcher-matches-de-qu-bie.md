# Java正则表达式，matcher.find\(\)和matcher.matches\(\)的区别

## 区别

find\(\)方法是**部分匹配**，是查找输入串中与模式匹配的子串，如果该匹配的串有组还可以使用group\(\)函数

matches\(\)是全部匹配，是将整个输入串与模式匹配，如果要验证一个输入的数据是否为数字类型或其他类型，一般要用matches\(\)。

## find\(\)的用法

```
Pattern pattern = Pattern.compile(".*?,(.*)");
Matcher matcher = pattern.matcher(result);
while(matcher.find()){
    System.out.println(matcher.group(0))
}
```

## 详细

### matches

public static boolean matches\(String regex, CharSequence input\)

编译给定正则表达式并尝试将给定输入与其匹配

调用此便捷方法的形式

```
Pattern.matches(regex, input);
Pattern.compile(regex).matcher(input).matches();
```

如果要多次使用一种模式，编译一次后重用此模式比每次都调用此方法效率更高。

**参数：**

* regex - 要编译的表达式
* input - 要匹配的字符序列

**抛出：**

PatternSyntaxException - 如果表达式的语法无效

### find

public boolean find\(\) 尝试查找与该模式匹配的输入序列的下一个子序列。

此方法从匹配器匹配的开头开始，如果该方法的前一次调用成功了并且从那时开始匹配器没有被重置，则从以前匹配操作没有匹配的第一个字符开始。

如果匹配成功，则可以通过start,  end 和 group方法获取更多信息

matcher.start\(\) 返回匹配到的字符串在字符串中的索引位置  
matcher.end\(\) 返回匹配到的字符串的最后一个字符在字符串中的索引位置  
matcher.group\(\) 返回匹配到的子字符串

**返回：**  
当且仅当输入序列的子序列匹配此匹配器的模式时才返回true

## 部分Java表达式实例

**字符串匹配**

```
Pattern p = Pattern.compile(expression); //正则表达式
Matcher m = p.matcher(str); // 操作的字符串
boolean b = m.matches() //返回是否匹配的结果
System.out.println(b);

Pattern p = Pattern.compile(expression); //正则表达式
Matcher m = p.matcher(str); //操作的字符串
boolean b = m.lookingAt(); //返回是否匹配的结果
System.out.println(b)

Pattern p = Pattern.compile(expression); //正则表达式
Matcher m = p.matcher(str); // 操作的字符串
boolean b = m.find();  // 返回是否匹配的结果
System.out.println(b);
```

**分割字符串**

```
Pattern pattern = Pattern.compile(expression); //正则表达式
String[] strs = pattern.split(str); //操作字符串 得到返回的字符串数组
```

**分割字符串**

```
Pattern pattern = Pattern.compile(expression) //正则表达式
String[] strs = pattern.split(str); // 操作字符串 得到返回的字符串数组
```

**替换字符串**

```
Pattern p = Pattern.compile(expression); //正则表达
Matcher m = p.matcher(text); // 操作的字符串
String s = m.replaceAll(str) // 替换后的字符串
```

**查找替换指定字符串**

```
Pattern p = Pattern.compile(expression); //正则表达式
Matcher m = p.matcher(text); // 操作的字符串
StringBuffer sb  = new StringBuffer();
int i = 0;
while(m.find()){
    m.appendReplacement(sb, str);
    i++
}
m.appendTail(sb)// 从截取点将后面的字符串接上
```

**查找输出字符串**

```
Pattern p = Pattern.compile("\\d");
Matcher m = p.matcher("a111b222c33d4f5aaaa");
while (m.find()) {
    System.out.println(m.group() + " " + "start: " + m.start() + "end: " + m.end());
}
```



