Throwable类是Java语言中所有错误(**Errors**)和异常(**Exceptions**)的超类。仅当对象是此类(或其子类)的实例时才可以被**JVM**抛出或可以被Java的**throw**语句抛出。同样，仅当是此类或其子类的一个实现时才可以作为**catch**语句的参数。

为了编译检查异常的意图，不是**RuntimeException**或**Error**子类的**Throwable**的子类被视为检查异常。