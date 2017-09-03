# 实现，而非继承

我们已经知道，所有enum都继承自java.lang.Enum类。由于Java不支持多重继承，所以你的enum不能再继承其他类

```java
enum NotPossible extends Pet {... //Won't work
```

然面，在我们创建一个新的enum时，可以同时实现一个或多个接口：

```java
interface Generator<E> {
    E next();
}
public enum  CartoonCharacter
    implements Generator<CartoonCharacter>{
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random rand = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}
class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.println(rg.next());
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for(int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
```

这个结果有点奇怪，不过你必须要有一个enum实例才能调用其上的方法。现在，在任何接受Generator参数的方法中，例如**printNext\(\)**, 都可以使用**CartoonCharacter**

