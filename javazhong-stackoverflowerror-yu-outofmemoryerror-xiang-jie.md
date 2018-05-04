# Java中StackOverflowError与OutOfMemoryError详解
使用Java开发，经常会遇到内存异常的情况，而StackOverflowError和OutOfMemoryError便是最常见的错误。首先，看看这两种错误的解释：

**如果当前线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常。 **

**如果虚拟机在扩展栈时无法申请到足够的内存空间，则抛出OutOfMemoryError异常。**



## StackOverflowError演示
```
@Test
public void test02() {
    recursion();
}

private void recursion() {
    recursion();
}
```

## OutOfMemoryError演示


```
@Test
public void test03() {
    List<Object> list = new ArrayList<>();
    while (true) {
        list.add(new Object());
    }
}
```








