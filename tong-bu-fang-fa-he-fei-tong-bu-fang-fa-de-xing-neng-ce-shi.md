# 同步方法和非同步方法的性能测试

前言：都说同步方法非常的消耗性能，因为实例的同步方法要对对象实例加锁，而静态方法要对类加锁。

但三者之间的性能差距有多大呢？为此，今天作了个测试

对实例同步方法，实例非同步方法，类静态方法 和 类静态同步方法作测试，测试类如下：

```
public class Synchiced {

    // 实例同步方法
    public synchronized void test01() {

        for(int i = 0; i < 10000; i++) {
            int i1 = i + 2;
        }
    }

    // 实例非同步方法
    public void test02() {
        for(int i = 0; i < 10000; i++) {
            int i1 = i + 2;
        }
    }

    // 类静态同步方法
    public synchronized static void test03() {
        for (int i = 0; i < 10000; i++) {
            int i1 = i + 2;
        }
    }

    // 类静态方法
    public static void test04() {
        for (int i = 0; i < 10000; i++) {
            int i1 = i + 2;
        }
    }
}
```

测试方法如下

```
public class Test01 {
     @Test
    public void test03() {
        Synchiced synchiced = new Synchiced();

        long begin = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i ++) {
            synchiced.test01();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

        begin = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i ++) {
            synchiced.test02();
        }
        end = System.currentTimeMillis();
        System.out.println(end - begin);

        begin = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i ++) {
            Synchiced.test03();
        }
        end = System.currentTimeMillis();
        System.out.println(end - begin);

        begin = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i ++) {
            Synchiced.test04();
        }
        end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
/*
output:
25665  // 实例同步方法
4      // 实例非同步方法
15534  // 类静态同步方法
3      // 类静态方法 
*/
```

可以得出以下结论，性能

类静态方法 &gt; 实例非同步方法 &gt; 类静态同步方法 &gt; 实例同步方法

