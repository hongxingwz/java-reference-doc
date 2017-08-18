### public native boolean isInstance\(Object obj\)

决定指定的Object与此Class代表的对象是assignment-compatible。此方法与Java语言中的instanceof是动态等价的操作。如果指定的Object参数不为null并且可以被转换成此Class对象代表的引用且不会引发一个ClassCastException则会引发一个ClassCastException。相反会返回false。

特别的是，如果此Class对象代表的是声明的类，此方法也会返回true。此方法反回true，如果指定的Object参数是此Class对象或其子类代表的对象，否则返回false。

如果此Class对象代表一个**数组类**，此方法返回true如果指定的Object参数可以被转换为数组类型通过身份转换或扩展转换，否则返回false。

如果此Class对象代表一个**接口类，**此方法将返回true如果指定Object参数的类或超类实现了此接口；相反返回false。

如果此Class对象代表一个**基本类型**，此方法返回false



