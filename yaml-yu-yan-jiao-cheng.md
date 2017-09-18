# YAML语言教程

编程免不了要写配置文件，怎么写配置也是一门学问。

YAML是专门用来写配置文件的语言，非常简洁和强大，远比JSON格式方便。

## 简介

YAML语言\(发音/ˈjæməl/\)的设计目标，就是方便人类读写。它实质上是一种能用的数据串行化格式。它的基本语法规则如下。

* 大小写敏感
* 使用缩进表示层级关系
* 缩进时不允许使用Tab键，只允许使用空格
* 缩进的空格数目不重要，只要相同层级的元素左侧对齐即可

YAML支持的数据结构有三种

* 对象： 键值对的集合，又称为映射\(mapping\) / 哈希\(hashes\) / 字典\(dictionary\)
* 数组：一级按次序排列的值，又称为序列\(sequence\) / 列表\(list\)
* 纯量\(scalars\): 单个的、不可再分的值

以下分别介绍这三种数据结构。

## 对象

对象的一组键值对，使用冒号结构表示

```
animal: pets
```

转换为JavaScript 如下

```
{animal: 'pets'}
```

Yaml允许别一种写法，将所有键值对写成一个行内对象。

```
hash: {name: Steve, foo: bar}
```

转换为JavaScript如下

```
{hash: {name: Steve, foo: bar}}
```

## 数组

一组连词线开头的行，构成一个数组。

```
- Cat
- Dog
- Goldfish
```

转换为javaScript如下。

```
['Cat', 'Dog', 'Goldfish']
```

数据结构的子成员是一个数组，则可以在该项下面缩进一个空格。

```
-
 - Cat
 - Dog
 - Goldfish
```

转换JavaScript如下。

```
[['Cat', 'Dog', 'Goldfish']]
```

数组也可以采用行内表示法

```
animal: [Cat, Dog]
```

转为JavaScrip如下

```
{animal: ['Cat', 'Dog']}
```

## 复合结构

对象和数组可以结合使用，形成复合结构。

```
languages:
 - Ruby
 - Perl
 - Python
websites:
 YAML: yaml.org
 Ruby: ruby-lang.org
 Python: python.org
 Perl: user.perl.org
```

转为JavaScript如下。

```
{
languages:['Ruby', 'Perl', 'Python']
websites:{
        YAML: 'yaml.org',
        Ruby: 'ruby-lang.org',
        Python: 'python.org',
        Perl: 'user.perl.org'
    }
}
```

## 纯量

纯量是最基本的、不可再分的值。以下数据类型都属于JavaScript的纯量

* 字符串
* 布尔值
* 整数
* 浮点数
* Null
* 时间
* 日期

### 数值

数值直接以字面量的形式表示。

```
number: 12.30
```

转为JavaScript 如下

```
{number: 12.30}
```

### 布尔值

布尔值用true和false表示

```
isSet: true
```

转换为JavaScript如下。

```
{isSet: true}
```

### null

null用~表示

```
parent: ~
```

### 时间

时间采用ISO8601格式

```
iso8601: 2001-12-14t21:59:43.1008:00
```

转换为JavaScript如下

```
{iso8601=Sat Dec 15 13:59:43 CST 2001}
```

### 日期

日期采用复合iso8601格式的年，月，日表示

```
date: 1976-07-31
```

转为JavaScript如下

```
{date: new Date('1976-07-31')}
```

## 强制类型转换

 

| !!null | null |
| :--- | :--- |
| !!bool | Boolean |
| !!int | Integer, Long, BigInteger |
| !!float | Double |
| !!binary | String |
| !!timestamp | java.util.Date, java.sql.Date, java.sql.Timestap |
| !!omap, !!pairs | List of Object\[\] |
| !!set | Set |
| !!str | String |
| !!seq | List |
| !!map | Map |

集合的默认实现是

| List | ArrayList |
| :--- | :--- |
| Map | LinkedHashMap |



