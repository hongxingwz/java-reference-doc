# 12.6.6 泛型类的静态上下文中类型变量无效

不能在静态域或方法中引用类型变量。例如，下列高招将无法施展：

```
public class SingleTon<T>{
    private static T singleInstance; //ERROR
    
    public static T getSIngleInstance(){
        if(singleInstance == null){
            ...
            constructor
            ....
        }
        return singleInstance
    }
}
```

如果这个程序能够运行，就可以声明一个Singleton&lt;Random&gt;共享随机数生成器，声明一个Singleton&lt;JFileChooser&gt; 共享文件选择器对话框。但是，这个程序无法工作。类型擦除之后，只剩下Singleton类，它只包含一个singleInstance域。因此，禁止使用带有类型变量的静态域和方法。

