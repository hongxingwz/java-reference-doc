### public String getProperty\(String key\)

寻找key在属性列表中，如果没有在此列表中找到，则在defaults中寻找，如果在defaults中没有找到，则在defaults中的defaults中寻找，递归的。如果没有找到，此方法返回null

```java
public String getProperty(String key){
    Object oval = super.get(key);
    String val = (oval instanceof String) ? (String) oval : null;
    return ((sval == null) && (default != null) ? default.getProperty(key) : sval;
}
```

### public String getProperty\(String key, String defaultValue\)

如果调用getProperty\(String\)返回null，则返回defaultValue

```java
public String getProperty(String key, String defaultValue){
    String val = getProperty(key);
    return (val == null) ? defaultValue : val;
}
```



