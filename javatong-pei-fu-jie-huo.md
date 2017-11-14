# Java通配符解惑

本以为这会是一篇比较基础的博客，可一旦深究的时候，才发现很多有意思的东西，也发现了很多令人迷惑的地方。通配符是一个有趣的东西，如果你掌握了，会使你的代码更为通用\(健状性更强\)。首先本文是建立在java泛型基础之上的，如果你对泛型并不了解，可以点击这里。同时为了对通配符的了解更为透彻，定义如下几个类。

```
class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(getName() + " can eat.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public void jump() {
        System.out.println(getName() + " can jump.");
    }
}

class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(getName() + " can fly.");
    }
}

class Magpie extends Bird {

    public Magpie(String name) {
        super(name);
    }

    public void sing() {
        System.out.println(getName() + "can not only eat, but sing");
    }
}


class AnimalTrainer {
    public void act(List<Animal> list) {
        for (Animal animal : list) {
            animal.eat();
        }
    }
}
```

测试类

```
public class Test02 {

    public static void main(String[] args) {
        AnimalTrainer animalTrainer = new AnimalTrainer();

        //Test 1
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Cat("cat1"));
        animalList.add(new Bird("bird1"));

        animalTrainer.act(animalList); //可以能过编译

        //Test 2
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("cat2"));
        catList.add(new Cat("cat3"));

        //animalTrainer.act(catList); //无法通过编译
    }
}
```

如上，Test1的执行应该可以理解的，不过顺带提醒一下的是，因为cat1和bird1都是Animal对象，自然可以添加List&lt;Animal&gt;里。对于Test2，无法通过编译是因为List&lt;Cat&gt;并不是List&lt;Animal&gt;子类，传入参数有误，也就无法通过编译了。现在尝试去修改AnimalTraniner.cat\(\)代码，让它变得更为能用一点，即不仅仅是接受List&lt;Animal&gt;参数，还可以接受List&lt;Bird&gt;等参数。那如何更改呢？？

## 一、通配符的上界

即然知道List&lt;Cat&gt;并 是List&lt;Animal&gt;的子类型，那就需要去寻找替代他解决的办法，使AnimalTrianer.cat\(\)方法变得更为通用（即可以接受List&lt;Animal&gt;类型，也可以接受List&lt;Cat&gt;等参数）。在java里解决办法就是使用通配符“?”,具体到AnimalTriancer，就是将方法改为act\(List&lt;? extends Animal&gt; list\), 当中“?”就是通配符，而“? extends Animal”则表示通配“?”的上界为Animal，换句话说是， “? extends Animal”可以代表Animal或其子类，可代表不了Animal的父类（如Object\)，因为通配符的上界是Animal。如下，为改进之后的AnimalTrianer

```
class AnimalTrainer {
//    public void act(List<Animal> list) {
//        for (Animal animal : list) {
//            animal.eat();
//        }
//    }

    public void act(List<? extends Animal> list) {
        for (Animal animal : list) {
            animal.eat();
        }
    }
}
```

再来测试一下，如下，发现Test2可以通过编译了：

```
public class Test02 {

    public static void main(String[] args) {
        AnimalTrainer animalTrainer = new AnimalTrainer();

        //Test 1
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Cat("cat1"));
        animalList.add(new Bird("bird1"));

        animalTrainer.act(animalList); //可以通过编译

        //Test 2
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("cat2"));
        catList.add(new Cat("cat3"));

        animalTrainer.act(catList); //可以通过编译
    }
}
```

经过上述分析，可以知道List&lt;Animal&gt;和List&lt;Cat&gt;都是List&lt;? extends Animal&gt;的子类型，类似有List&lt;Bird&gt;, List&lt;Magpie&gt;也是List&lt;?  exends Animal&gt;的子类型。现总结如下，对于通配符的上界，有以下风条基本规则：（假设给定的泛型类型为G，（如List&lt;E&gt;中的List\)，两个具体的泛型参数X,Y,当中Y是X的子类\(如上的Animal 和Cat\)

* G&lt;? extends Y&gt; 是 G&lt;? extends X&gt;的子类型（如List&lt;? extends Cat&gt; 是 List&lt;? extends Animal&gt;的子类型）。
* G&lt;X&gt;是G&lt;? extends X&gt;的子类型\(如List&lt;Animal&gt;是List&lt;? extends Animal&gt;的子类型\)。
* G&lt;?&gt; 是 G&lt;? extends Object&gt;等同，如List&lt;?&gt; 与 List&lt;? extends Object&gt;等同。

学到这里，可能会遇到一些疑惑的地方，或者说是理解不透的地方，先观察如下两段代码片段，判断一下其是否可行？

```
ist<? extends Animal> list = new ArrayList<>();
        list.add(new Animal("animal"));
        list.add(new Bird("bird"));
        list.add(new Cat("cat"));
```

先分析如下：因为“? extends Animal”可代表Animal或其子类\(Bird, Cat\)，那上面的操作应该是可行的。事实上是“**不行**”，即无法通过编译。为什么呢？？



在解释之前，再来重新强调一下已经知道的规则：在List&lt;Animal&gt; list里只能添加Animal类对象及其子类对象 \(如Cat和Bird对象\)，在List&lt;Bird&gt;里只能添加Bird类和其子类对旬\(如Magpie\),可不能添加Animal对象\(不是Bird的子类\)，类似的在List&lt;Cat&gt;和List&lt;Magpie&gt;里只能添加Cat和Bird对象\(或其子类对旬，不过这没有列出\)。现在再回头看一下testAdd\(\)方法，我们知道List&lt;Animal&gt;，List&lt;Cat&gt;等都是List&lt;? extends Animal&gt;的子类型。先假设传入的参娄为List&lt;Animal&gt;，则第一段代码的三个“add"操作都是可行的；可如果是List&lt;Bird&gt;呢？则只有第二个”add“可以执行；再假设传入的是List&lt;Tiger&gt;\(Tiger是想象出来的，可认为是Cat的子类\)，则三个”add“操作都不能执行。

现在反过来说，给testAdd传入不同的参数，三个”add“操作都可能引发类型兼容问题，而传入的参数是未知的，所以java为了保护其类型一致，禁止向List&lt;? extends Animal&gt;添加任意对象，不过去可以添加**null**，即list.add\(null\)是可行的。有了上面谈到的基础，再来理解第二段代码就不难了，因为List&lt;? extends Animal&gt;的类型 "？ extends Animal"无法确定，可以是Animal，Bird或者Cat等，所以为了保护其类型的一致性，也是不能往list添加任意对象的，不过去可以添加**null**。



**总结**

先总结如下：不能往List&lt;? extends Animal&gt;添加任意对象，除了null。

另外提醒大家注意的一点是，在List&lt;? extends Animal&gt;可以是Animal类对象或Bird对象等（只是某一类对象），反过来说，在List&lt;? extends Animal&gt; list里的都是Animal对象， 即Bird也是Animal对象，Cat也是Animal对象\(用Java的语言来说就是子类可以指向父类，父类却不能指向子类\)，那么在Animal里的所有方法都是可以调用的，如下：

```
for(Animal animal : list){
    animal.eat();
}
```



## 二、通配符的下界

即然有了通配符的上界，自然有着通配符的下界。可以如此定义通配符的下界List&lt;? super Bird&gt;，其中”Bird“就是通配符的下界。注意：不能同时声明泛型通配符申明上界和下界。

在谈注意细节之前，我们先看一下通配符的使用规则--对于通配符的上界，有以下几条基本规则：\(假设给定的泛型类型为G, \(如List&lt;E&gt; 中的List\), 两个具体的泛型参数X, Y 当中Y是X的子类\(如上的Animal和Cat\)\)

* G&lt;? super X&gt; 是 G&lt;? super Y&gt;的子类型 \(如List&lt;? super Animal&gt; 是 List&lt;? super Bird&gt;的子类型\)。
* G&lt;X&gt;是G&lt;? super X&gt;的子类型\(如List&lt;Animal&gt;是List&lt;? super Animal&gt;的子类型\)。

现在再看如下代码，判断其是否符合逻辑：

```
List<? super Bird> list = new ArrayList<>();
list.add(new Bird("bird"));
list.add(new Magpie("magpie"));
list.add(new Animal("animal"));
```

看第一段代码，其分析如下，因为”? super Bird“代表了Bird或其父类，而Magpie是Bird的子类，所以上诉代码不可通过编译。而事实上是”行“，为什么呢？ 

在解疑之前，再来强调一个知识点，子类可以r指向父类，即Bird也是Animal对象。现在考虑传入的testAdd\(\)的所有可能的参数，可以是List&lt;Bird&gt;，List&lt;Animal&gt;， 或者List&lt;Object&gt;等等，发现这些参数的类型是Bird或其交类，那我们可以这样看，把bird, magpie看成Bird对象，也可以将bird, magpie看成Animal对象，类似的可看成Object对象，最后发现这些添加到List&lt;? super Bird&gt;list里的对象都是同一类对象\(如本文开篇提到的Test1\)，因此testAdd方法是符合逻辑，可以通过编译的。

现在再来看一下第二段代码对于，第二，三行代码的解释和上文一样，至于最后一行"list.add\(new Animal\("animal"\)\)"是无法通过编译的，为什么呢？？为了保护类型的一致性，因为”？super Bird"可以是Animal，也可以是Object或其他Bird的父类，因无法确定其类型，也就不能往List&lt;? super Bird&gt;添加Bird的任意父类对象。

既然无法确定其父类对象，那该如何遍历List&lt;? super Bird&gt; ？因为Object是所有类的根类，所以可以用Object来遍历。如下，不过貌似其意义不大。

```
for(Object object : list){
    //...
}
```

那“? super BoundingType”可以应用在什么地方呢？？“? super BoundingType”应用相对广泛，只不过是混合着用。下面举个简单的例子。先假设有以下两个Student和CollegeStudent, 当中CollegeStudent继承Student，如下：

下面的介绍的不太准确略过

原文链接

[http://www.linuxidc.com/Linux/2013-10/90928p3.htm](http://www.linuxidc.com/Linux/2013-10/90928p3.htm)

