# 捕获组

捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。
例如，正则表达式(dog)创建了单一分组，组里包含"d", "o", 和"g"。
捕获组是通过从式至右计算其开括号来编号。例如，在表达式((A)(B(C)),有四个这样的组：
* ((A)(B(C))
* (A)
* (B(C))
* (C)
可以通过调用mather对象的groupCount方法来查看表达式有多少个分组。groupCount方法返回一个int值，表示matcher对象当前有多少个捕获组。
还有一个特殊的组(group(0))，它总是代表整个表达式。该组不包括在groupCount的返回值中。

## 实例
下面的例子说明如何从一个给定的字符串找到数字串:



```
	@org.junit.Test
	public void test32() {
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(\\D*)(\\d+)(.*)";

		Pattern r = Pattern.compile(pattern);
		Matcher matcher = r.matcher(line);

		if (matcher.find()) {
			System.out.println("Found Value: " + matcher.group(0));
			System.out.println("Found Value: " + matcher.group(1));
			System.out.println("Found Value: " + matcher.group(2));
			System.out.println("Found Value: " + matcher.group(3));
		}
	}
```

