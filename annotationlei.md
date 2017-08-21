# Annotation
由所有注解类型继承的共同的接口。
注意手动继承此接口不会定义一个注解类型。
也要注意的是此接口本身也不是注解类型

AnnotatedElement接口讨论了注解类型由不可重复变为可重复的兼容性问题。


比较有用的方法,返回此注解的注解类型，由此我们可以通过返回获取注解的名字，方法等。
Class<? extends Annotation> annotationType();