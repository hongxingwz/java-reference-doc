定义一个注解类

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase{
    public int id();
    public String description() default "no description";
}
```

定义一个使用了该注解的类

```java
public class PasswordUtils{
    @UseCase(id = 47, description = 
        "Passwords must contain at least one numberic")
    public boolean validatePassowrd(String password){
        return (password.matches("\\w*\\d\\w*");
    }
    
    @UseCase(id = 48)
    public boolean encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }


    @UseCase(id = 49, description = 
        "New passwords can't equal prevously used ones")
    public boolean checkForNewPassword(String password){
        return false;
    }
    
```

编写注解处理器类

```java
public class UserCaseTracker2 {
    public static void tracker(List<Integer> list, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            UseCase uc = method.getAnnotation(UseCase.class);
            if (uc != null) {
                int id = uc.id();
                System.out.println(uc.description());
                list.remove(new Integer(id));
            }
        }
        System.out.println("-----------------");
        for (Integer i : list) {
            System.out.println(i + " missing");
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 47, 48, 49, 50);
        tracker(list, PasswordUtils.class);
    }
}
```



