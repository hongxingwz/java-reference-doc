### public boolean equals\(Object obj\)

此方法与指定的object相比较。如果一样的话返回true。如果两个方法的声明类一样并且具有相同的名字，参数的类型和顺序一样，返回的类型一样，则这两个方法一样

```java
public boolean equals(Object obj){
    if(obj != null && obj instanceof Method){
        Method other = (Method)obj;
        if((getDeclaringClass() == other.getDeclaringClass())
            && (getName() == other.getName())){
            if(!returnType.equals(other.getReturnType())){
                return false;
            }
            return equalParamsTypes(parameterType, other.parameterTypes);
        }
    }
    return false;
}
        
```

**Executable抽象类**

```java
boolean equalsParamTypes(Class<?>[] params1, Class<?>[] params2){
    /*Avoid unnecessary cloning */
    if(params1.length == params2.length){
        for(int i = 0; i < params1.length){
            if(params1[i] != params2[i]){
                return false;
            }
        }
        return true;
    }
    return false;
}
```



