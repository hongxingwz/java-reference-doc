# Java动态代理用法与实现过程

## 首先看看jdk动态代理的用法

动态代理涉及到两个类：  
`Proxy`类和`InvocationHandler`接口

* 编写被代理类实现的接口

```
public interface User{
    void add();
}
```

* 被代理类实现类

```
public class UserImpl implements User {

    @Override
    public void add() {
        System.out.println("*************add***********");
    }
}
```

* 编写自己的InvocationHandler

```
public class MyInvocation implements InvocationHandler {

    private Object target;

    public MyInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("******before method executor**********");
        Object invoke = method.invoke(target, args);
        System.out.println("******* after method executor*********");
        return invoke;
    }
}
```

* 使用

```
public class App{
    public static void main(String[] args){
        User user = new UserImpl();
        Class<?>[] clz = user.getClass().getInterfaces();
        MyInvocation invocation = new MyInvocation(user);
        User proxyUser = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), clz, invocation);
    }
}
```

在该实现中

* 重写InvocationHandler的invoke方法，并添加需要的前置和后置处理。
* 使用Proxy类的静态方法newProxyInstance\(\)生成代理对象，其中该方法的接收参数：

## 来看看动态代理的具体过程
* 使用被代理对象创建InvocationHandler对象实例
* 生成代理对象实例
    * 生成proxy代理对象的字节码文件，并创建proxy的类对象
    * 根据proxy的类对象使用反射创建proxy对象实例
* 在代理对象上调用目标方法(就是调用invoke的过程)

**源代码可参考Proxy.newProxyInstance方法**





