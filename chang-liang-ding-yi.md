# 常量定义
* 【强制】不允许任何魔法值(即未经定义的常量)直接出现在代码中。

 反列：String key = "Id#taobao_" + tradeId; cache.put(key, value);
 
* 【强制】long或者Long初始赋值时，使用大写的L，不能是小写的l，小写容易跟数字1混淆，造成误解
 说明：Long a = 2l; 写的是数字的21，还是Long型的2?

* 【推荐】不要使用一个常量类维护所有的常量，按常量功能进行归类，分开维护。
 说明：大而全的常量类，非得使用查找功能才能定位到修改的常量，不利于理解和维护。
 正例：缓存相关常量放在类CacheConsts下；系统配置相关常量放在类ConfigConsts下。
 
* 【推荐】常量的复用层次有五层：跨应用共享常量，应用内共享常量，子工程内共享常量，包共享常量，类内共享常量。
1）跨应用共享常量：放置在二方库中，通常是client.jar中的constant目录下。
2）应用内共享常量：放置在一方库中，通常是modules中的constant目录下。
反倒：易懂变量也要统一定义成应用内共享常量，两位攻城师在两个类中分别定义了表示“是”的变量：
类A中：public static final String YES = "yes";
类B中：public static final String YES = "y";
A.YES.equals(B.YES),即期是true，但实际返回为false，导致线上问题。
3）子工程内部共享常量：即在当前子工程的constant目录下。
4）包内共享常量：即在当前包下单独的constant目录下。
5）类内共享常量：直接在类内部private static final定义。

* 【推荐】如果变量值仅在一个范围内变化，且带有名称之外的延伸属性，定义为枚举类。下面正例中的数字就是延伸信息，表示星期几。
正例: public Enum {MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4)}