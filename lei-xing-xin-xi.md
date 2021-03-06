# 类型信息

**运行时类型信息使得你可以在程序运行时发现和使用类型信息。**

它使你从只能在编译其执行面向类型的操作的禁锢中解脱了出来，并且可以使用某些非常强大的程序。对_RTTI \(Run-Time Type Identification\) _的需要，提示了面向对象设计中许多有趣（并且复杂）的问题，同时也提出了如何组织程序的问题。

本章将讨论Java是如何让我们在运行时识别对象和类的信息的。主要有两种方式

* “传统的” RTTI，它假定我们在编译时已经知道了所有的类型；
* 另一种是“反射”机制，它允许我们在运行时发现和使用类的信息



