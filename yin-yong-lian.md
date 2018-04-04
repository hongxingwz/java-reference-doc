# 引用链

## 描述

A-&gt;B-&gt;C-&gt;D-&gt;E

要求给出A返回E，给出B返回E



## 算法

```java
public class Test01 {

    private Map<String, String> refMap = new HashMap<>();

    @Before
    public void init() {
        refMap.put("A", "B");
        refMap.put("B", "C");
        refMap.put("C", "D");
        refMap.put("D", "E");
        refMap.put("E", "F");
    }

    @Test
    public void test02() {
        String a = conanicalName("A");
        System.out.println(a);
    }

    private String conanicalName(String name) {
        String conanicalName = name;
        String resolvedName;
        do {
            resolvedName = refMap.get(conanicalName);
            if (resolvedName != null) {
                conanicalName = resolvedName;
            }
        } while (resolvedName != null);

        return conanicalName;
    }
}
```



