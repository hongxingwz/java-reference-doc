# Properties

注解符为: \#或者!

空白字符为: ' ', '\t', '\f'

key/value的分隔符为： '=' 或者 ':'

```
name:jianglei
age=18
```

自然行分隔符为：'\r', '\n', '\r\n'

逻辑行：可能分割到多个自然行中，使用反斜杠'\'来连接多处自然行

```
name = \
```

注释行：使用注释符作为首个非空白字符的自然行

```
#comment
      #comment
```

空白字符的自然行会被认为是空行而被忽略

```
name=jianglei

age=18
```

```
        name     =        jianglei                                \n
```

**这样key为name， value值为'jianglei                                '**

