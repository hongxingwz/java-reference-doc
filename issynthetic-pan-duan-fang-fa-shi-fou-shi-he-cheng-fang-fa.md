### public boolean isSynthetic\(\);

判断方法是否是合成方法

> 注：桥方法必是合成方法，因为其是由JDK编译时生成的

下面这段代码就生成了一个合成方法

```java
public class TestSynthetic {
    @Test
    public void testSynthetic() {
        Method
        [] methods = User.class.getDeclaredMethods();
        //这里实现化user对象时调用了私有构造器
        User user = new User();
        //这里也访问了私有变量
        user.age = 1;
        for (Method method : methods) {
            System.out.println(method.toString() + "," + method.isSynthetic() + method.isBridge());
        }
    }
    class User {
        private int age;
        private String name;

        private User() {

        }

        private User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        private int getAge() {
            return age;
        }

        private void setAge(int age) {
            this.age = age;
        }

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }
    }
}
/*
private java.lang.String com.jianglei3.bean.TestSynthetic$User.getName(),falsefalse
private void com.jianglei3.bean.TestSynthetic$User.setName(java.lang.String),falsefalse
static int com.jianglei3.bean.TestSynthetic$User.access$102(com.jianglei3.bean.TestSynthetic$User,int),truefalse
private void com.jianglei3.bean.TestSynthetic$User.setAge(int),falsefalse
private int com.jianglei3.bean.TestSynthetic$User.getAge(),falsefalse
*/
```



