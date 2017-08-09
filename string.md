```
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence{

        private final char value[];

        //转换为字符数组
        public char[] toCharArray(){
            //Cannot use Arrays.copyOf because of class initialization order issues
            char result[] new char[value.length];
            System.arraycopy(value, 0, result, 0, value.length);

            return result;
        }
```



* **startsWith\(String, int\)**

判断字符是否以prefix开始  
"abcde".startsWith\(""\) ==&gt; 返回true

```
public boolean startsWith(String prefix, int toffset){
    char ta[] = value;
    int to = toffset;
    char pa[] = prefix.value;
    int po = 0;
    int pc = prefix.value.length;
    
    //Note: toffset might be near -1 >>> 1 也就是 Integer.MAX_VALUE
    if((toffset < 0) || (toffset > value.length - pc)){
        return false;
    }
    
    while(--pc >= 0){
        if(ta[to++] != pa[po++]){
            return false;
        }
    }
    
    return true;
}    
```



