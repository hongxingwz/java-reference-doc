# 各种吊炸天的toString

## AbstractCollection\#toString\(\)

> 注：这是我见过得最吊的toString，脑洞大开，佩服的裤子都脱了

```
public String toString() {
    Iterator<E> it = iterator();
    if (! it.hasNext())
        return "[]";

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (;;) {
        E e = it.next();
        sb.append(e == this ? "(this Collection)" : e);
        if (! it.hasNext())
            return sb.append(']').toString();
        sb.append(',').append(' ');
    }
}
```

### 相应的变种

> 注：这个就有点垃圾了，效率变得不在那么高

```
private static String toString5(List<?> list) {
        Iterator<?> it = list.iterator();
        if (!it.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (it.hasNext()) {
            Object next = it.next();
            sb.append((next == list ? "(this Collection)" : next));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
}
```

## Arrays\#toString的方法

> 注：这个toString也是比较高效的

```
    public static String toString(Object[] a) {
        if (a == null) {
            return "null";
        }
        int arrLen = a.length - 1;

        if (arrLen == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; ; i++) {
            sb.append(a[i]);
            if (i == arrLen) {
                return sb.append("]").toString();
            }
            sb.append(",");
        }
    }
```

## 先append逗号的，如果不是第一个，这也是一种思路

```
private static String toString6(Object[] obj) {
        if (obj == null) {
            return "null";
        }
        int length = obj.length;
        if (length == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append("{");
            } else {
                sb.append(", ");
            }
            sb.append(obj[i]);
        }
        sb.append("}");
        return sb.toString();
    }
```

## 





