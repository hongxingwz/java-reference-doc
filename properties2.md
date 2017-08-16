# Properties

Properties类代表一系列持久化的属性。Properties从以保存到流或从流中加载。在属性列表中的每一个键和其相关联的值都是字符串。

属性列表可以包含另一个属性列表作为其“defaults”;如果从原始的属性列表中没有找到属性的key，会从第二个属性列表中寻找。

因为Properties继承自Hashtable, put 和 putAll 方法也适用于Properties对象。强烈不鼓励使用这两个方法因为其可以插入键值对不为String的值。而应该是使用setProperty方法。如果在一个没有包含键值对的Properties对象上调用store和save方法将会失败。聪明的，在一个空的（没有饮食键值对的Properties对象）上调用propertyNames 或 list方法将会失败。

load\(Reader\)/store\(Writer, String\)方法按下面所指定的，简单的面向行的格式在基于字符的流中加载和存储属性。除了输入/输出流使用ISO 8859-1字符编码外, load\(InputStream\) / store\(OutputStream, String\) 方法与load\(Reader\) / store\(Writer, String\)对的工作方法完全相同。可以使用Unicode转义来编写此编码中无法直接表示的字符；转义序列中只允许单个‘u’字符。可使用native2ascii工具对属性文件和其他字符编码进行相互转换。

loadFromXML\(InputStream\) 和 storeToXML\(OutputStream, String, String\)方法按简单的XML格式加载和存储属性。默认使用UTF-8字符编译，但如果需要，可以指定某种特定的编码。XML属性文档具有以下DOCTYPE声明：

```
<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
```

注意，导入或导出属性时，不访问系统URI\(http://java.sun.com/dtd/properties.dtd\);该系统URI仅作为一个唯一标识DTD的字符串；



