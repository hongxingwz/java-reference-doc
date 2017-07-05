#定义简单泛型类
一个泛型类(generic class)就是具有一个或多个类型变量的类。本章使用一个简单的Pair类作为例子。对于这个类来说，我们只关注泛型，而不会为数据存储的细节烦恼。下面是Pair类的代码：

    public class Pair<T>{
        private T first;
        private T second;
        
        public Pair(){
            first = null;
            second = null;
        }
        
        public T getFirst(){
            return first;
        }
        public T getSecond(){
            return second;
        }
        
        public void setFirst(T newValue){
            first = newValue;
        }
        public vid setSecond(T newValue){
            second = newValue;
        }
    }

##泛型类可以有多个类型变量

    public class Pair<T, U>{...}     
               
##类字义中的类型变量指定方法的返回类型以及域和局部变量的类型。例如,
    
    private T first;

>注释：类型变量使用大写形式，且比较短，这是很常见的。在Java库中，使用变量E表示集合的元素类型，K和V分别表示表的关键字与值的类型。T(需要时还可以临近的字母U和S）表示"任意类型"。

用具体的类型替换类型变量就可以实例化泛型类型，例如：
    
    Pair<String>

可以将结果想象成带有构造器的普通类：
    
    Pair<String>
    Pair<String>(String, String)

和方法：
    
    String getFirst()
    String getSecond()
    void setFirst(String)
    void setSecond(String)
    
换句话说，泛型类可看作普通类的工厂。