### public native boolean isPrimitive\(\);

决定指定的Class对象是否代表一个原始的类型

有9个重新定义的类对象表示8个原始类型和void。这些类是由JVM创建的，具有与他们代表的原始类型相同的名字，boolean, byte, char,  short, int, long, float, double.

这些对象只能通过下面的公开表态最终的变量访问，只有这些类型对象时此方法才会返回true。

* Boolean.TYPE
* Character.TYPE
* Byte.TYPE
* Short.TYPE
* Integer.TYPE
* Long.TYPE
* Float.TYPE
* Void.TYPE



