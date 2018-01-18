# 正则表达式语法

在其他语言中，`\\`表示：我想要在正则表达式中插入一个普通的\(字面上的\)反斜杠，请不要给它任何特殊的意义。

在Java中, `\\`表示：我要插入一个正则表达式的反斜线，所以其他的字符具有特殊的意义。

所以，在其他的语言中，一个反斜杠`\`就足以具有转义的作用，而在正则表达式中则需要有两个反斜械才能被解析为其他语言中的转义作用。也可以简单的理解在正则表达式中，两个`\`代表其他语言中的一个`\`，这也就是为什么表示一们数字的正则表达式是`\\d`,而表示一个普通的反斜杠是`\\\\`

| 字符 | 说明 |
| :--- | :--- |
| \ | 将下一字符标记为特殊字符、文本、反向引用或八进制转义符。例如，"n"匹配字符"n"。"\n"匹配换行符。序列"\\\\"匹配"\\", "\\\("匹配"\("。 |
| ^ | 匹配输入字符串开始的位置。如果设置了**RegExp**对象的Multiline属性，^还会与"\n"或"\r"之后的位置匹配。 |
| $ | 匹配输入字符串结尾的位置。如果设置了**RegExp**对象的**Multiline**属性，$还会与"\n"或"\r"之前的位置匹配。 |
| \* | 零次或多次匹配前面的字符或子表达式。例如, zo\*匹配"z"和"zoo"。\*等效于{0,}。 |
| + | 一次或多次匹配前面的字符或子表达式。例如, "zo+"与"zo"和"zoo"匹配，但与"z"不匹配。+等效于{1, }。 |
| ？ | 零次或一次匹配前面的字符或子表达式。例如, "do\(es\)?"匹配"do"或"dose"中"do"。?等效于{0, 1}。 |
| {n} | n是非负整数。正好匹配n次。例如, "o{2}"与"Bob"中的"o"不匹配，但与"food"中的两个"o"匹配。 |
| {n, } | n是非负整数。至少匹配n次。例如, "o{2, }"不匹配"Bob"中的"o",而匹配"foooood"中的所有o。"o{1,}"等效于"o+"。"o{0,}"等效于"o\*"。 |
| {n, m} |  |



## Matcher类的方法

## 索引方法

索引方法提供了有用的索引值，精确表明输入字符串中在哪能找到匹配：

| 序号 | 方法及说明 |
| :--- | :--- |
| 1 | public int start\(\) 返回以前匹配的初始索引。 |
| 2 | public int start\(int group\) 返回在以前的匹配操作期间，由给定组所捕获的子序列的初始索引。 |
| 3 | public int end\(\) 返回最后匹配字符之后的偏移量。 |
| 4 | public int end\(int group\) 返回在以前的匹配操作期间，由给定组所捕获子序列的最后字符之后的偏移量。 |



## 研究方法

研究方法用来检查输入字符串并返回一个布尔值，表示是否找到该模式：

| 序号 | 方法及说明 |
| :--- | :--- |
| 1 | public boolean lookingAt\(\) 尝试将从区域开头的输入序列与该模式匹配。 |
| 2 | public boolean find\(\) 尝试查找与该模式匹配的输入序列的下一个子序列。 |
| 3 | public boolean find\(int start\) 重围此匹配器，然后尝试查找匹配该模式、从指定索引开始的输入序列的下一个子序列。 |
| 4 | public boolean matches\(\) 尝试将整个区域与模式匹配。 |



## 替换方法

替换方法是替换输入字符串里文本的方法：

| 序号 | 方法及说明 |
| :--- | :--- |
| 1 | public Matcher appendReplacement\(StringBuffer sb, String rreplacement\) 实现非终端添加和替换步骤 |
| 2 | public StringBuffer appendTail\(StringBuffer sb\) 实现终端添加和替换步骤 |
| 3 | public String replaceAll\(String replacement\) 替换模式与给定替换字符串相匹配的输入序列的每个子序列。 |
| 4 | public String replaceFirst\(String replacement\) 替换模式与给定替换字符串匹配的输入序列的第一个子序列。 |
| 5 | public static String quoteReplacement\(String s\) 返回指定字符串的字面替换字符串。这个方法返回一个字符串，就像传递给Matcher类的appendReplacement方法一个字面字符串一样工作。 |



### matches和lookingAt方法

matches和looingAt方法都用来尝试匹配一个输入序列模式。它们的不同是matches要求整个序列都匹配。而lookingAt不要求。lookingAt方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配。

这两个方法经常在输入字符串的开始使用。我们通过下面这个例子，来解释这个功能：

```
@org.junit.Test
public void test34() {
	Pattern foo = Pattern.compile("foo");
	Matcher m1 = foo.matcher("foooooooooooooooooooooooooo");
	Matcher m2 = foo.matcher("ooooooofooooooooooooooooooooooooooo");

	System.out.println("lookingAt():" + m1.lookingAt());
	System.out.println("matches():" + m1.matches());
	System.out.println("lookingAt():" + m2.lookingAt());

}
```



