#12.3泛型方法
前面已经介绍了如何定义一个泛型类。实际上，还可以定义一个带有类型参数的简单方法。

    class ArrayAlg{
        public static <T> T getMiddle(T... a){
            return a[a.length / 2];
        }
    }

这个方法是在普通类中定义的，而不是在泛型类中定义的。然而，这是一个泛型方法，可以从尖括号和类型变量看出这一点。注意，类型变量放在修饰符(这里是public static)的后面，返回类型的前面。

泛型方法可以定义在普通类中，也可以定义在泛型类中。

当调用一个泛型方法时，在方法名前的尖括号中放入具体的类型：
    
    String middle = ArrayAlg.<String>getMiddle("John", "Q.", "Public");