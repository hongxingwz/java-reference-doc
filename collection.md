# Collection





关于Collection接口中，没有带有索引定义的方法的一些思考

如boolean add\(int i, E val\), boolean remove\(int i\)的这类带有索引的方法

思考：因为Collection是一个较为抽象的接口，其下的实现接口还有Set，因为Set的是没有存储顺序的，所以没有定义如上所示的方法。而是在List接口里定义了这些方法

其接口中的注释也体现了这一点：

```
//Positional Access Operations
E get(int index);
E set(int index E element);
void add(int index, E element);
E remove(int index);

// Search Operations
int indexOf(Object o);
int lastIndexOf(Object o);
```



