# Date

```
public class Date{
    private transient long fastTime;
    
    public Date(){
        this(System.currentMillions());
    }
    
    public Date(long date){
        this(date);
    }
    
    public void setTime(long time){
        ...
    }
    
    public void getTime(){
        ...
    }
```

java.util.Date这个类是在JDK1.0设计的，因为其不适合国际化的需求。所以这个类的好多方法都已经过期，可能在未来的版本删除。

官方给的建议是使用Calener

