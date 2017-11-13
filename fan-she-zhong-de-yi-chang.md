# 反射中的异常

## InvocationTargetException
InvocationTargetException 是已检查异常，
包装了由调用方法或构造器抛出的异常

从版本1.4开始，此异常已经更新，符合通用异常链机制。“目标异常”是在构造的时候提供的，可以通过getTargetException()方法访问，这类对象目前被认为是导致异常的原因，可以通过Throwable.getCause()方法以及前面提到的“遗留方法”访问它。

**要点：**
getTargetException()
getCause()