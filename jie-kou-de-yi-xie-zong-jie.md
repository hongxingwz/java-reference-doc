# 接口的一些总结

##接口类的getSuperclass是什么
答：null 
参阅 Class#getSuperclass

##接口类的定义的方法都是抽象的吗？
答：不是
在1.8这后，接口可以定义default方法，这些方法不是具有实现，不是抽象的。


##接口类getDeclaredMethods()和getMethods()与正常的有什么区别
答：与正常的没有区别
