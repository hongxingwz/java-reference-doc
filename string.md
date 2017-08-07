```
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence{
        
        private final char value[];
        
        public char[] toCharArray(){
            //Cannot use Arrays.copyOf because of class initialization order issues
            char result[] new char[value.length];
            System.arraycopy(value, 0, result, 0, value.length);
            
            return result;
        }
```



