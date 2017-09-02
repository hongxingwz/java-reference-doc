# 将静态导入用于enum

```
public enum Spiciness {
    NOT, MILD, MEDIUM, HOT, FLAMING
}
```

```
import static com.jianglei.enum2.Spiciness.*;

public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }
    public String toString() {
        return "Burrito is " + degree;
    }
    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}
/*
Burrito is NOT
Burrito is MEDIUM
Burrito is HOT
*/
```

使用**static import**能够将**enum**实例的标识符带入当前的命令空间，所以无需再用**enum**类型来修饰**enum**实例。这是一个好的想法吗？或者还是显式地修饰**enum**实例更好？这要看代码的复杂程度了。编译器可以确何你使用的正确的类型，所以唯一要担心的是，使用静态导入会不会导致你的代码令人难以理确。多数情况下，使用**static import**还是有好处的，不过，程序员还是应该对具体情况进行具体分析。

注意，在定义**enum**的同一个文件中，这种技巧无法使用；如果是在默认包中定义**enum**,这种技巧也无法使用\(在Sun内部对这一点显然也有不同意见\)

