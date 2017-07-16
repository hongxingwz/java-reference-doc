
* **Calender.YEAR 设置 年份**


```java
Calender c = Calender.getInstance();
c.set(Calender.YEAR, 2018);
int year = c.get(Calender.YEAR); //return: 2018

```


* **Calender.MONTH 设置 月份**

Calender.JANUARY = 0
Calender.FEBRUARY = 1
Calender.MARCH = 2
Calender.APRIL = 3
Calender.MAY = 4
Calender.JUNE = 5
Calender.JULY = 6
Calender.AUGUST = 7
Calender.SEPTEMBER = 8
Calender.OCTOBER = 9
Calender.NOVEMBER = 10
Calender.DECEMBER = 11


```java
Calender c = Calendar.getInstance();
c.set(Calender.MONTH, Calender.JUNE);
int month = c.get(Calender.MONTH); //return: 5

```
* **Calender.DATE, Calender.DATE_OF_MONTH**



```java
Calender c = Calender.getInstance();
c.set(Calender.DATE, 0);
c.get(Calender.DATE); //return: 返回上个月的最后一天

```


* **Calender.AM\_PM 设置上午和下午**
Calender.AM  上午
Calender.PM  下午

```java
Calender c = Calender.getInstance();
c.set(Calender.AM_PM, Calender.AM);
int am_pm = c.get(Calender.AM_PM); //return: 0

c.set(Calender.AM_PM, Calener.PM);
am_pm = c.get(Calender.AM_PM); //return: 1


```


 
* **Calender.HOUR 12小时制设置小时设置小时**

* **Calender.HOUR_OF_DAY 24小时设制设置小时**

* **Calender.MINUTE 设置分钟** 


```java
Calender c = Calender.getInstance();
c.set(Calender.MINUTE, 30);
int minute = c.get(Calender.MINUTE); //return: 30

```
* **Calener.SECOND设置秒**
```java
Calender c = Calender.getInstance();
c.set(Calender.SECOND, 23);
c.get(Calender.SECOND); //return: 23

```

* **WEEK_OF_YEAR设置一年的第几周**

* **DAY_OF_WEEK一周的第几天**
* **DAY_OF_MONTH一月的第几天**
* **DAY_OF_YEAR一年的第几天**

* **WEEK_OF_MONTH一个月的第几周**
* **WEEK_OF_YEAR一年的第几周**

* **ZONE_OFFSET**
**疑问Calender.DATE 与 Calender.DATE\_OF\_MONTH的区别？
**没有区别，他们两是同意词，其表示的数值都是5


## 方法
* **Date getTime()**
* **setTime setTime(Date date)**
* **Date getTimeInMillis()**
* **setTimeInMillis()**
* **getTimeInMillis()**

* **get(int field)**

* **set(int field, int value)**
* **set(int year, int month, int date)**
* **set(int year, int month, int date, int hourOfDay, int minute)**
* **set(int year, int month, int date, int hourOfDay, int minute, int second)**




 

