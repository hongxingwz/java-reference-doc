# Java中正则表达式Matcher类的matches()， lookAt()和find()的区别

在Matcher类中的matches, lookingAt和find都是匹配目标的方法，但容易混淆，整理它们的区别如下：
* matches：整个匹配，只有整个字符序列完全匹配成功，才返回True，否则返回False。但如果前部分匹配成功，将移动下次匹配的位置。

* lookingAt: 部分匹配，总是从第一个字符进行匹配，匹配成功了不再继续匹配，匹配失败了，也不继续匹配。

* find：部分匹配，从当前位置开始匹配，找到一个匹配的子串，将移动下次匹配的位置。

* reset：给当前的Matcher对象配上个新的目标，目标就是该方法的参数；如果不给参数，reset会把Matcher设到当前字符串的开始处。使用示例代码来展示他们的区别更清晰明了：



```
	@org.junit.Test
	public void test29() {
		Pattern pattern = Pattern.compile("\\d{3,5}");
		String charSequence = "123-34345-234-00";
		Matcher matcher = pattern.matcher(charSequence);

		System.out.println(matcher.matches());	// false

		System.out.println(matcher.find());		// true
		System.out.println(matcher.group());	// 34345
		System.out.println(matcher.start());	// 4

		matcher.reset();						// 当前的位置置为0

		System.out.println(matcher.find());		// true
		System.out.println(matcher.group() + " - " + matcher.start() + " - " + matcher.end());		//123 - 0 - 3
		System.out.println("------------");

		System.out.println(matcher.find());		// true
		System.out.println(matcher.group() + " - " + matcher.start());		//34345 - 4



		System.out.println(matcher.lookingAt());	// true
		System.out.println(matcher.group() + "---" + matcher.start());		//123--0

		System.out.println(matcher.lookingAt());	//true
		System.out.println(matcher.group() + "---" + matcher.start());		//123--0
	}
```

