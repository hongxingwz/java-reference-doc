# 字符串接接与StringBuilder的性能比较



```
    // 拼接 用时90391
    public void stringAdd() {
        long begin = System.currentTimeMillis();
        String str = "";
        for(int i = 0; i < 100000; i++) {
            str += begin;
        }

        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }
    
    // builder 用时6
    public void stringAdd2() {
        long begin = System.currentTimeMillis();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 100000; i++) {
            str.append(begin);
        }

        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

    // buffer 用时7
    public void stringAdd3() {
        long begin = System.currentTimeMillis();
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < 100000; i++) {
            str.append(begin);
        }

        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }
```

通过已上对比，我们已经知道在进行大量的字符串拼接的时候，StringBuilder的性能要远高于字符串拼接。

