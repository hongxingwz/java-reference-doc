# switch语句中的enum

在**switch**中使用**enum**, 是**enum**提供的一项非常便利的功能。一般来说，在**switch**中只能使用整数值，而枚举实例天生就具备整数值的次序，并且可以通过**ordinal\(\)**方法取得其次序\(显然编译器帮我们做了类似的式作\)，因此我们可以在**switch**语句中使用**enum。**

虽然一般情况下我们必须使用**enum**类型来修饰一个**enum**实例，但是在**case**语句中却不必如此。下面的例子使用**enum**构造了一个小型状态机：

```

enum Signal {
    GREEN, YELLOW, RED
}
public class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for(int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
```

编译器并没有抱怨**switch**中没有**default**语句，但这并不是因为每一个**Signal**都有对应的**case**语句。如果你注释掉其中的某个**case**语句，编译器同样不会抱怨什么。这意味着，你必须确保自己覆盖了所有的分支。但是，如果在**case**语句调用**return,**那么编译器就会抱怨缺少**default**语句了。这与是否覆盖了**enum**的所有实例无关。

