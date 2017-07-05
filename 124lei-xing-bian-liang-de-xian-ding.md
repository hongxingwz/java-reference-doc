#12.4类型变量的限定
有时，类或方法需要对类型变化加以约束，下面是一个典型的例子。我们要计算数组中的最小元素：

    class ArrayAlg{
        public static <T> T min(T[] a){
            if(a == null || a.length == 0) return null;
            T smallest = a[0];
            for(int i = 1; i < a.length; i++)
                if(smallest.compareTo(a[i]) > 0) smallest = a[i];
            return smallest;
        }
    }
    
但是，这里有一个问题。请看一下min方法的代码内部。变量smallest类型为T,这意味着它可以是任何一个类的对象。怎么才能确信T所属的类有compareTo方法呢？

解决这个问题的方案是将T限制为实现了Comparable接口(只含一个方法compareTo的标准接口)的类。可以通过对类型变量T设置限定(bound)实现这一点：
    
    public static <T extends Comparable> T min(T[] a)...
    
实际上Comparable接口本身就是一个泛型类型。目前,我们忽略其复杂性以及编译器产生的警告。

现在，泛型的min方法只能被实现了Comparalbe接口的类（如String, Date等）的数组调用。由于Rectangle类没有实现Comparable接口，所以调用min将会产生一个编译错误。

##限定类型用"&"分隔，而逗号用来分隔类型变量
一个类型变量或通配符可以有多个限定，例如：
    
    T extends Comparable & Serializable
    
在Java的继承中，可以根据需要拥有多个接口超类型，**但限定中至多有一个类。如果用一个类作为限定，它必须是限定列表中的第一个**