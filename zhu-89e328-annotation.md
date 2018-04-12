# 注解\(Annotation\)

## 接口简介

所有注解类型都继承的能用接口。  
注意如果一个接口手动继承了此接口的话不会定义一个注解类型。  
也要注意的此接口自己也不会定义一个注解类型

更多的关于注解类型的信息可以在java语言规则中获取。

`java.lang.reflect.AnnotatedElement`接口讨论了把一个不重复的注解类型转换成一个重复的注解类型的兼容性。

## 方法简介：

### `Class<? extend Annotation>annotationType()`

返回此注解的类型

