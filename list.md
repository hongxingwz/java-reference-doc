### public void list\(PrintStream out\)

打印属性列表到指定的输出流中。这个方法在debugging时很有用

> 注：当value的长度大于40时，会截取37并加上...

当key 和 value不是字符串的形式时，会抛出ClassCastException

```java
public void list(PrintStream out){
    out.println("-- listing properties --");
    Hashtable<String, Object> h = new Hashtalbe<>();
    enumerate(h);
    for(Enumeration(<String> e = h.keys(); e.hashMoreElements();){
    String key = e.nextElement();
    String val = (String)h.get(key);
    if(val.length() > 40){
        val = val.substring(0, 37) + "...";
    }
    out.println(key + "=" + val);
    }
}
```



```java
private synchronized void enumerate(Hashtable<String, Object> h){
    if(defaults != null){
        defaults.enumerate(h);
    }
    for(Enumeration<?> e = keys(); e.hasMoreElements();){
        String key = (String)e.nextElement();
        h.put(key, get(key));
    }
}
```



