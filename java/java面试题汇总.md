# Java面试题汇总

## 基本概念

### 面向对象的三个特征

封装、继承和多态是面向对象的三大特征

### 多态的好处

多态定义：允许不同对象对同一消息（发送消息也就是函数调用）做出响应，也就是同一个消息可以根据发送对象的不同而采用不同的行为方式

优点：

- 可替换性：多态对已经存在的代码具有可替换性
- 可扩充性：增加新的子类不会影响已存在的类结构
- 接口性：多态是超类通过方法签名向子类提供一个公共接口，有子类来完善或者重写来实现的。
- 灵活性以及简化性

#### 代码中实现多态

1. 接口实现
2. 继承父类重写方法
3. 同一个类中进行重载

#### 虚拟机中实现多态方式

通过动态把绑定技术（dynamic binding），执行期间判断引用对象的实际类型，根据实际类型调用对应的方法。

### 接口的意义

规范、扩展、回调

### 抽象类的意义

- 为其他子类提供一个公共的类型
- 封装子类中重复定义的内容
- 定义抽象方法，子类虽然有不同的实现但是定义时是一致的

### 接口和抽象类的区别

| 比较           | 抽象类                                                       | 接口                                                       |
| -------------- | ------------------------------------------------------------ | ---------------------------------------------------------- |
| 默认方法       | 抽象类中可以有默认的方法实现                                 | Java8之前不存在方法的实现                                  |
| 实现方式       | 子类使用extends关键字继承抽象类，如果子类不是抽象类则子类需要提供抽象类中所声明的方法实现 | 子类使用implements来实现接口，需要提供接口中所有声明的实现 |
| 构造器         | 抽象类中可以有构造器                                         | 接口不能存在构造器                                         |
| 与正常类的区别 | 抽象类不能被实例化                                           | 接口是完全不同的类型                                       |
| 访问修饰符     | 抽象方法可以有public，protected以及default等修饰符           | 接口中默认是public修饰符，并且不能使用其他修饰符           |
| 多继承         | 一个子类只能存在一个父类                                     | 一个子类可以实现多个接口                                   |
| 添加新的方法   | 在抽象类中添加新的方法，也可以提供默认的实现，也就是说不需要修改子类中现有的代码 | 如果要往接口中添加新的方法，则子类中需要实现该方法         |

### 父类的静态方法能否被子类重写

不能！重写只适用于实例方法，不能用于静态方法，而子类当中含有和父类相同签名的静态方法一般称为隐藏。

### 什么是不可变对象

不可变对象指的是对象一旦被创建，状态就不能再改变，任何的修改都会创建一个新的对象，比如string、Integer以及其他的封装类。

### 静态变量和实例变量的区别

静态变量存储在方法区，属于类所有；实例变量存储在堆里面，其引用存在于当前线程栈。

### 能否创建一个包含可变对象的不可变对象？

可以，可以创建一个包含可变对象的不可变对象，但是不能共享可变对象的引用，如果需要变化的时候，需要返回源对象的一个拷贝。最常见的例子就是对象中包含一个日期对象的引用。

### Java创建对象的几种方式

- 采用new关键字
- 通过反射
- 采用clone
- 通过序列化的机制

前面两个是显示的调用构造方法。造成耦合性最高的是new关键字，所以解耦必须要减少new的使用。

### switch 中能否使用string做参数

在jdk1.7之前，switch只能支持byte、short、char、int或者对应的封装类和enum类型，9种

在jdk1.7之后，开始支持string了，10种

### switch能否作用在byte，long上

可以作用在byte上，不能作用在long上（可以理解为在基本类型中int可默认类型转换的行）

### String s1=”ab”, String s2=”a”+”b”, String s3=”a”, String s4=”b”, s5=s3+s4 请问s5==s2 返回什么？
返回：false，在编译过程中，编译器会将s2优化为"ab"，也就是会放入常量池中，但是s5则是创建在堆区，相当于string s5 = new string("ab")。

### string对象的intern()

intern()方法会首先从常量池中查找是否存在该常量值，如果存在的话直接返回，不存在的话则现在在常量池中创建。

比如：

```java
String ss1 = "aa";
        String ss2 = ss1.intern();
        System.out.println("ss1 == ss2:" + (ss1 == ss2));//true

        String ss3 = new String("bb");
        String ss4 = ss3.intern();
        System.out.println("ss3 == ss4:" + (ss3 == ss4));//false,此时不是在常量池中的，所以会不相等
```

### object中的公共方法

equals:

clone:
getClass:

notify,notifyAll,wait

toString

### java 中的四种引用

强引用，软引用，弱引用，虚引用，不同的引用类型主要体现在GC上面：

- 强引用：如果一个对象具有强引用，就不会被垃圾回收期回收。即时当前内存空间不足，jvm也不会回收他而是抛出outofmemoryError错误，使程序异常终止。如果想要中断强引用和某个对象之间的关联，可以显示的将引用赋值为null，这样一来jvm就会在合适的时间回收该对象。
- 软引用：在使用软引用的时候，如果内存的空间足够，软引用就会继续被使用，而不会被垃圾回收器回收，只有在内存不足的时候，软引用才会被垃圾回收器回收。
- 弱引用：具有弱引用的对象拥有的生命周期更加短暂。因为JVM会进行垃圾回收，一旦发现弱引用对象，无论当前内存空间是否充足，都会将弱引用回收（下一次垃圾回收时）。不过由于垃圾回收是一个优先级低的线程，所以并不一定会迅速发现弱引用对象。
- 虚引用：虚引用形同虚设，如果一个对象仅仅持有虚引用，那么它相当于没有引用，任何时候都可能被垃圾回收器回收。

### WeakReference和SoftReference区别

虽然两种引用都有利于提高GC和内存的效率，但是WeakReference（弱引用）一旦失去最后一个强引用就会被GC回收，而软引用虽然不能阻止被回收，但是可以延迟到JVM内存不足的时候。

### 为什么要有不同的引用类型？

因为Java不像c语言可以控制内存的申请和释放，在Java中有时候需要控制对象被回收的时机，因此就诞生了不同的引用类型，可以说不同的引用类型实际上是对GC回收时机不可控的妥协，下面场景：

- 利用软引用和弱引用可以解决OOM问题：用一个HashMap来保存图片的路径和相应图片对象关联的软引用之间的映射关系，当内存不足的时候，JVM会自动回收这些缓存图片对象所占用的空间，从而有效避免OOM的问题。
- 通过软引用实现Java对象的高速缓存：比如说创建了一系列Person的类，如果每次需要查询一个人的信息，哪怕是几秒钟之前查询过的，都需要重新构建一个实例，这样会引起大量Person对象的消耗，并且由于这些对象的生命周期相对较短，会引起多次GC影响性能。此时通过软引用和HashMap的结合可以构造高速缓存，提高性能。

### Java中的 == 和equals区别，equals和'hashCode'区别

== 是一个运算符，用于比较两个变量是否相等，而equals是Object类的方法，用于比较两个对象是否相等。默认Object类的equals方法是比较两个对象的地址，此时和==的效果一样。换句话说：基本类型比较用 == ，比较而是他们的值。默认下对象使用==比较的时候比较的是内存地址，如果需要比较对象内容，需要重写equals方法。

- equals和hashCode的区别：

  hashCode是Object类的一个方法，返回的是一个哈希值。如果两个对象根据equals方法比较相等，那么这俩个对象中任意一个对象的hashCode方法必须产生相同的哈希值。如果两个对象根据equals方法比较不相等，那么产生的哈希值不一定会相等（存在碰撞的情况下会相等）

- a.hashCode有什么用？与a.equals(b)有什么关系？

  hashCode方法是相应对象整形的hash值，通常基于hash的集合类，与equals方法关系密切。根据Java的规范，使用equals方法判断两个相等的对象必须具有相同的hashcode。

  将对象放入到集合中，首先判断要放入对象的hashCode是否已经在集合中存在，不存在的话就直接放入集合中，如果hashCode相等就通过equals方法判断要放入对象与集合中的任何对象相等，如果equals不相等直接将元素放入集合中，否则不放入。

- 不相等对象具有相同的hashCode

  有可能，两个不相等的对象可能会有相同的hashCode值，也就是hashmap产生冲突的原因，如果两个对象相等，必须有相同的hashcode值，反之不成立。

- 可以在hashCode中使用随机数字吗？

  不能，因为同一对象的hashcode值必须是相同的

- a == b 与a.equals(b)有什么区别？如果a和b都是对象，则a == b是比较两个对象的引用，只有当a和b指向的是堆中的同一个对象才会返回true，而a.equals(b)是进行逻辑比较，所以通常需要重写该方法来提供一致性的比较。

### 3*0.1 == 0.3返回值是什么？

  false，因为有些浮点数不能完全精确表示出来

### a = a+b 与a+=b有什么区别吗？

+=操作符会进行隐式的自动类型转换，此处a+=b隐式的将+操作的结果强制转换为持有结果的类型，但是a=a+b则不会自动进行类型转换。如：

byte a = 127;
byte b = 127;
b = a + b; // error : cannot convert from int to byte （这里a+b会被自动提升为int类型）
b += a; // ok

short s1= 1; s1 = s1 + 1; 该段代码是否有错,有的话怎么改？
有错误，short 类型在进行运算时会自动提升为int 类型，也就是说s1+1 的运算结果是int
类型。
short s1= 1; s1 += 1; 该段代码是否有错，有的话怎么改？
+=操作符会自动对右边的表达式结果强转匹配左边的数据类型，所以没错。

### & 和&&的区别

一个是位操作一个是逻辑运算。逻辑运算具有短路的特征，&不具有短路特征

### 一个Java文件内的类

只能有一个public公共类，但是可以有多个default修饰的类

### 内部类的作用

内部类可以有多个实例，每个实例都有自己的状态信息，并且与其他外围对象的信息相互独立，在单个外围类当中，可以让多个内部类以不同的方式实现同一个接口或者继承同一个类，创建内部类对象的时刻不依赖于外部类对象的创建。内部类是一个独立的实体。

内部类提供了更好的封装除了该外围类，其他的类都不能访问。

### final , finalize , finally的不同之处

final是一个修饰符，可以用于修饰变量、方法、和类。如果修饰的是变量，说明该变量的值在初始化之后不能被改变。finalize方法是在对象被回收之前调用的方法，给对象自己最后一个复活的机会，但是什么时候调用finalize没有保证。finally是一个关键字，和try以及catch一起用于处理异常。finally块一定会被执行，无论try块中是否发生了异常。

### clone是哪个类的方法？

java.lang.Cloneable是一个标识性的接口，不包含任何的方法，clone方法在object类中定义。并且clone方法是一个本地方法，也就是由其他语言实现的。

### 深拷贝和浅拷贝的区别是什么？

- 浅拷贝：被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。换言之，浅拷贝仅仅复制所考虑的对象，而不是复制他引用的对象。
- 深拷贝：被复制对象的所有变量都含有与原来的对象相同的值，而那些引用其他对象的变量将指向被复制过的新对象而不是原有的那些被引用的对象。换言之，深拷贝需要把要复制对象所引用的对象也都复制一遍。

### static都有哪些用法？

1. 静态方法（被static修饰的所有变量以及方法都是类的静态资源，被类的实例所共享）

   

2. 静态变量

3. 静态代码块：多用于初始化操作

4. 静态内部类：修饰内部类

5. 静态导包：import static *** ，可以用来指定导入某个类中的静态资源，并且不需要使用类名。资源名，可以直接使用。

### final的用法

1. 被final修饰的类不可以被继承

2. 被final修饰的方法不可以被重写

3. 被final修饰的变量不可以被改变。如果修饰引用，则表示引用不可变，引用指向的内容可变

4. 被final修饰的方法，JVM会尝试将其内联以提高运行效率

5. 被final修饰的常量，在编译期间会存入常量池中

   编译器对final域需要遵守的两个重排序规则：

   1. 在构造函数内对一个final域的写入，与随后把这个被构造对象的引用赋值给一个引用变量，这两个操作之间不可以重排序。
   2. 初次读一个包含final域的对象的引用，与随后初次都这个final域俩个操作之间不能重排序。

## 数据类型相关

### Java中的int,char,long等数据类型各占多少个字节？



| 类型   | 位数 | 字节数 |
| ------ | ---- | ------ |
| short  | 16   | 2      |
| int    | 32   | 4      |
| long   | 64   | 8      |
| float  | 32   | 4      |
| double | 64   | 8      |
| char   | 16   | 2      |

  在不同位数的jvm虚拟机中，类型变量的长度是一个固定值，与平台无关。

### int与Integer的区别

Integer是int的包装类型，在拆箱与装箱中，二者自动转换。int是基本类型，直接存数值，而Integer是一个对象，用一个引用指向这个对象。

### int与Integer哪个占用的内存更多

Integer对象会占用更多的内存 。Integer是一个对象，需要存储对象的元数据。但是int是一个原始类型的数据，所以占用的空间更少。

### String , StringBuffer , StringBuilder区别

String是字符串常量，final修饰；StringBuffer是字符串变量（线程安全）；StringBuilder是字符串变量（线程不安全）

### String和StringBuffer

string和string buffer主要区别是性能，因为string是不可变对象，所以每次对string类型进行操作都等同于产生了一个新的string对象，然后指向新的string对象。所以尽量不在对string进行大量的拼接操作，否则会产生很多临时对象，导致GC开始工作从而影响性能。

string buffer本身是对对象进行操作，而不是产生新的对象，因此有大量拼接的情况下建议使用string buffer。

但是需要注意JVM会对string拼接做出一定的优化：

String s=“This is only ”+”simple”+”test”会被虚拟机直接优化成String s=“This
is only simple test”，此时就不存在拼接过程。

### string buffer和string builder

string buffer是线程安全的可变字符串，其内部实现是可变数组。string builder是JDK1.5新增的，功能与string buffer类似，但是非线程安全。因此，在没有多线程问题的前提下，使用string builder会取得更好的性能。

### 什么是编译器常量？使用他有什么风险？

公共静态不可变（public static final）变量也就是我们所说的编译器常量，这里的public可选。实际上这些变量在编译时会被替换掉，因为编译器知道这些变量的值，并且知道这些变量在运行时不能改变，这种方式存在的一个问题就是一旦使用了一个内部的或者第三方的公有编译时常量，但是这个值后面被其他人改变了，但是你的客户端仍然使用的是老的值，甚至已经部署了新的jar，为了避免这种情况，在更新依赖的时候，需要重新编译程序。

### Java当中使用什么类型表示价格比较好？

如果不是特别关心内存和性能的话，使用bigdecimal，否则使用预定义精度的double类型。

### 如何将byte转为string？

可以使用string接收byte[]参数的构造器来进行转换，但是需要注意使用正确的编码，否则会使用平台默认编码，这个编码可能与原来的编码相同，也可能不同。

### 可以将int强转为byte类型吗？会产生什么问题？

可以进行强制转换，但是进行强制转换的话，高位会被丢弃，byte类型的范围是-128-127

## 关于垃圾回收

### 垃圾回收算法

1. 标记-清除
2. 标记-复制
3. 标记-整理
4. 分代回收

### 如何判断一个对象是否应该被回收？

通过对象存活性判断，常用的方法有俩种：

1. 引用计数法
2. 对象可达性分析

由于引用计数法存在互相引用导致无法进行GC的问题，所以目前的JVM虚拟机多使用对象可达性分析算法。

### 简单解释一下垃圾回收

Java垃圾回收机制最基本的做法是分代回收。内存中的区域被划分为不同的世代，对象根据其存活的时间被保存在对应的世代区域内。一般的实现是划分成三个世代：年轻、年老和永久。内存的分配是发生在年轻世代中的，当一个对象存活时间足够长的时候，它就会被复制到老年代中。对于不同的世代可以使用不同的垃圾回收算法。进行世代划分的出发点是对应用中对象存活时间进行研究后得到的统计规律。一般来说，一个应用中大部分对象存活的时间都很短。比如说局部变量的存活时间就只在方法的执行过程中。基于这一点，对于年轻世代的垃圾回收算法就很有针对性。

### 调用System.gc()会发生什么？

通知GC开始工作，但是GC真正开始的时间不确定。

## 进程线程相关

### 进程，线程，协程的区别

简而言之，进程是程序运行和资源分配的基本单位，一个程序至少有一个进程，一个进程至少有一个线程。进程在执行的过程中拥有独立的内存单元。而多个线程共享内存资源，减少切换次数，从而效率更高。线程是进程的一个实体，是CPU调度和分配的基本单位，是比程序更小的能够独立运行的基本单位。同一个进程中的多个线程之间可以并发执行。

协程不是被操作系统内核所管理，而完全是由程序所控制（也就是在用户态执行）。

这样带来的好处就是性能得到了很大的提升，不会像线程切换那样消耗资源。

### 守护线程？与非守护线程有什么区别？

程序在运行完毕后，jvm会等待非守护线程完成后关闭，但是JVM不会等待守护线程。守护线程最典型的例子就是GC线程。

### 什么是多线程的上下文切换？

多线程的上下文切换是指CPU控制权由一个已经正在运行的线程切换到另外一个就绪并等待获取CPU执行权的线程的过程。

### 创建线程的方式？有什么区别？

通过实现Runnable接口或者通过拓展Thread类。相比扩展Thread，实现Runnable接口更优：

- Java不支持多继承，因此继承Thread类就代表这个子类不能扩展其他类。而实现Runnable接口的类还可以在扩展一个类。
- 类可能只需要可执行即可，因此继承整个Thread类的开销过大

### Thread类的start和run方法有什么区别

start方法被用来启动新创建的线程，而且其内部调用了run方法，这和直接调用run方法的效果不一样。当调用run方法的时候，只会在原来的线程中调用，没有新的线程启动，start方法才会启动新线程。

### 怎么检测一个线程是否持有对象监视器？

Thread类提供了一个holdLock(Object)方法，当且仅当obj的监视器被某条线程持有的时候才会返回true，注意这是一个static方法，所以意味着某条线程指的是当前线程。

### Runnable和Callable的区别

Runnable接口中的run方法的返回值是void，他做的事情只是纯粹的去执行run方法中的代码；Callable接口中的call方法是由返回值的，是一个泛型，和Future,FutureTask配合可以用来获取异步执行的结果。

这其实是一个很有用的特称，因为多线程相比单线程更难、更复杂的一个重要原因就是多线程充满着未知性，某线程是否执行了？某线程执行了多久？某线程执行的时候期望的数据是否已经赋值完毕？无法得知，我们能够做的仅仅是等待线程的任务执行完毕而已。但是Callable+Future/FutureTask配合可以方便获取多线程的结果，可以在等待时间太长没获取到需要的数据的情况下取消该线程的任务。

### 什么导致线程阻塞？

阻塞指的是暂停一个线程的执行以等待某个条件发生（如某资源就绪），Java提供了多个方法来支持阻塞：

| 方法                | 说明                                                         |
| ------------------- | ------------------------------------------------------------ |
| sleep()             | sleep()允许指定以毫秒为单位的一段时间作为参数，它使得线程在指定的时间内进入阻塞状态，不能够得到CPU时间，指定的时间一过，线程重新回到可执行的状态。典型的，sleep()被用在等待某个资源就绪的情形；测试发现条件不满足后，让线程阻塞一段时间后重新测试，直到条件满足为止。 |
| suspend()和resume() | 两个方法配套使用,suspend()使得线程进入阻塞状态并且不会自动恢复，必须其对应的resume()被调用，才能使得线程重新进入到可执行状态。典型的，suspend()和resume()被用在等待另一个线程产生的结果的情形。测试发现结果还没有产生就等待，当另一个线程产生了结果后，调用resume()使其恢复。 |
| yield()             | yield()使得当前线程放弃已经分得的CPU时间，但不使当前线程阻塞，即线程仍处于可执行状态，随时可能再次分的CPU时间，调用yield()的效果等价于调度程序认为该线程已执行了足够的时间从而转到另一个线程。 |
| wait()和notify()    | 两个方法配套使用，wait()使得线程进入到阻塞状态，他有两种形式，一种允许指定以毫秒为单位的一段时间作为参数，另一种没有参数，前者当对notify()被调用或者超出指定时间线程重新进入到可执行状态，后者则必须对应的notify()被调用。 |

### wait(),notify()和suspend(),resume()之间的区别

wait()在阻塞的时候会释放锁。

wait()属于object类，也就是说，所有的对象都拥有这一对方法。因为这一对方法阻塞时要释放占用的锁，而琐是所有的对象都具有的，调用任意对象的wait()方法导致线程阻塞，并且该对象上的锁被释放。而调用任意对象的notify()方法则导致从调用该对象wait()方法而阻塞的线程中随机选择一个解除阻塞（但是要等到获得锁后才会真正执行）

其次，前面叙述的所有方法都可以在任意位置调用，但是wait()和notify()方法需要在synchronized方法或者块中调用，理由也很简单，因为只有在synchronized方法或者块中当前线程才占用锁，才有锁可以被释放。同样的道理，调用这一对方法的对象上的锁必须为当前线程所拥有，这样才有锁可以释放。因此，这一对方法调用必须放入synchronized中，该方法或者块上的上锁对象就是调用这一对方法的对象。若不满足这一条件，程序虽然可以编译，但是在运行的时候会抛出illegalmonitorstateexception异常。

wait()和notify()方法的上述特征决定了他们经常和synchronized和关键字一起使用，将他们和操作系统进程间通信机制做一个比较就会发现其相似性，synchronized方法或块所提供了类似于操作系统原语的功能，它们的执行不会受到多线程机制的干扰，而这一对方法则相当于block和weakup原语（这一对方法均声明为synchronized）。他们的结合使得我们可以实现操作系统上一系列精妙的进程间通信的算法，比如信号量算法，并且用于解决各种复杂的线程间通信问题。

关于wait()和notify():

1. 调用Notify()方法导致解除阻塞的线程是从因调用该对象的wait()方法而阻塞的线程中随机抽取的，我们无法预料哪一个线程会被选择，所以需要特别小心，避免因此不稳定性产生的问题。
2. 除了notify()之外，还有一个notifyAll()方法，唯一的区别在于notifyAll()方法将把因调用该对象的wait()方法而阻塞的所有线程一次性全部解除阻塞。当然，只有获得锁的那一个线程才会进入可执行状态。

谈到阻塞，死锁也就不可避免了，suspend()方法和不指定超时期限的wait()方法都可能产生死锁。但是Java在语言级别不能避免死锁。所以需要特别小心。

### 产生死锁的条件

1. 互斥条件：一个资源每次只能被一个进程使用
2. 请求与保持条件：一个进程因请求资源而阻塞时，对已经获取到的资源保持不放
3. 不剥夺条件：进程已经获取到的资源，在未使用完之前，不能强行剥夺。
4. 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系

### 为什么wait()方法和notify()以及notifyAll()方法要在同步块中调用

这是JDK 强调的，wait()方法和notify()方法在调用前都必须获得对象的锁

### wait()和notify()方法在放弃对象监视器时有什么区别

wait()方法和notify()方法在放弃对象监视器时候的区别在于：wait()会立即释放对象监视器，notify()方法则会等待线程剩余代码执行完毕才会放弃对象监视器

### wait()和sleep()的区别

- sleepe()来自Thread类，而wait()来自Object类。调用sleep()方法的过程中，线程不会释放对象锁。但是调用wait()方法会释放对象锁。
- sleep()睡眠后不会让出系统资源，但是wait()让其他线程可以占用CPU
- sleep(millseconds)需要指定一个睡眠时间，时间一到就会自动唤醒，而wait()需要配合notify()或者notifyAll()使用

### 为什么wait,notify和notifyAll这些方法不放在Thread类中

首先，Java提供的锁时对象级别的而不是线程级别的，每个对象都有锁，通过线程获得。如果线程需要等待某些锁那么调用对象中的wait()方法就有意义了。如果wait()方法在Thread类中，线程正在等待的是哪个锁就变得不明显了，简单的说，由于wait和notify都是锁级别的操作，所以把他们定义在Object类中是因为锁属于对象。

### 怎么唤醒一个阻塞的线程

如果线程调用了wait(),sleep()或者join()方法而导致的阻塞，可以通过中断线程并且通过抛出interruptedexception来唤醒他；如果线程遇到了IO阻塞，无能为力，因为IO操作时系统实现的，Java代码并没有办法直接接触到操作系统。

### 什么是线程的上下文切换？

多线程的上下文切换是指CPU控制权有一个已经正在运行的线程切换到另外一个就绪并等待获取CPU执行权的线程的过程。

### synchronized和ReentrantLock的区别

synchronized是和if ,else ,for,while一样的关键字，ReentrantLock是一个类，这是二者的本质区别。既然ReentrantLock是一个类，那么就提供了比synchronized更加灵活的特性，可以被继承、可以有方法等等，ReentrantLock比synchronized的扩展性体现在几点上：

1. ReentrantLock可以对获取锁的等待时间进行设置，避免了死锁
2. ReentrantLock可以获取各种锁的信息
3. ReentrantLock可以灵活实现多路通知

另外，二者的锁机制不一样，ReentrantLock底层调用的是Unsafe的park方法加锁，而synchronized操作的时对象头中的markword

### FutureTask是什么

FutureTask表示一个异步运算的任务。FutureTask里面可以传入一个Callable的具体实现类，可以对这个异步运算的任务的结果等待获取，判断是否已经完成、取消任务等操作。当然，由于FutureTask也是Runnable接口的实现类，所以FutureTask也可以放入线程池中。

### 一个线程如果出现了运行时异常怎么办

如果这个异常没有被捕获的话，这个线程就停止执行了。另外重要的一点是：如果这个线程持有某个对象的监视器，那么这个对象监视器就会被立即释放。

### Java当中有哪几种锁

- 自旋锁：自旋锁在JDK1.6以后默认开启了。共享数据的锁定状态只会持续很短的时间 ，为了这一小段时间而去挂起和恢复线程有点浪费，所以这里做了一个处理，让后面请求锁的线程稍等一会，但是不放弃处理器的执行时间，看看持有锁的线程能否快速释放。为了让线程等待，所以需要让线程执行一个忙循环也就是自旋操作。在JDK6以后，引入了自适应的自旋锁，也就是等待的时间变得不固定了 ，而是有上一次在同一个锁上的自选时间及锁的拥有者状态来决定。
- 偏向锁：目的是消除数据在无竞争情况下的同步原语。进一步提升程序的运行性能。偏向锁就是偏心的锁，意思是这个锁会偏向第一个获得他的线程，如果接下来的执行过程中，该锁没有被其他线程获取，则偏向锁的线程永远不会再进行同步。偏向锁可以提高带有同步但是无竞争的程序性能，也就是说并不一定总是对程序有利，如果程序中大多数的锁都是被多个不同的线程访问，那偏向模式就是多余的，在具体问题具体分析的前提下，可以考虑是否使用偏向锁。
- 轻量级锁：为了减少获得锁和释放锁带来的性能消耗，引入了“偏向锁”和“轻量级锁”，所以在JDK1.6里面锁一共有四种状态：无锁状态，偏向锁状态，轻量级锁状态和重量级锁状态，他会随着竞争情况逐渐升级。锁可以升级但是不能降级，意味着偏向锁升级成为轻量级锁后就不能降级成为偏向锁了。

### 如何在两个线程之间共享数据

通过在线程之间共享对象就可以了，然后通过wait/notify/notifyAll,await/signal.signalAll进行等待和唤醒，比方说阻塞队列BlockingQueue就是为线程之间共享数据而设计的。

### 如何正确使用wait()?使用if还是while?

wait()方法应该在循环里面调用，因为当线程获取到CPU开始执行的时候，其他条件可能还没有满足，所以在处理前，循环检测条件是否满足会更好。如下：

### 什么时线程局部变量ThreadLocal

线程局部变量是局限于线程内部的变量，为线程自身所有，不在多个线程之间共享。Java提供了ThreadLocal类来支持线程局部变量，是一种实现线程安全的方式。但是在管理环境下使用线程局部变量需要小心，在这种情况下，工作线程的生命周期比任何的变量生命周期都长。任何线程局部变量一旦在工作完成之后没有释放，Java应用就存在内存泄漏的风险。

### ThreadLocal的作用是什么

简单说ThreadLocal就是一种以空间换取时间的做法在每个Thread里面维护一个ThreadLocal，ThreadLocalMap把数据进行隔离，数据不共享，自然就没有线程安全方面的问题。

### 生产消费者模型的作用

1. 通过平衡生产者的生产能力和消费者的消费能力来提升整个系统的运行效率，这是生产消费者最重要的作用
2. 解耦：这是生产消费者附带的作用，解耦意味着生产者和消费者之间的联系少，联系越少越可以独自发展而不需要收到相互的制约。

### 写一个生产者-消费者队列

1. 通过阻塞队列实现

   ```java
   package com.jichu.duoxaincheng;
   
   import java.util.Random;
   import java.util.concurrent.ArrayBlockingQueue;
   import java.util.concurrent.BlockingQueue;
   
   //使用阻塞队列实现生产消费队列
   public class SCXFByBlokingQueue {
       public static void main(String[] args) {
           BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
           Producer producer = new Producer(queue);
           Consumer consumer = new Consumer(queue);
           Consumer consumer1 = new Consumer(queue);
           new Thread(producer).start();
           new Thread(consumer).start();
           new Thread(consumer1).start();
       }
   }
   
   //生产者类
   class Producer implements Runnable {
       private final BlockingQueue<Integer> queue;
   
       public Producer(BlockingQueue<Integer> queue) {
           this.queue = queue;
       }
   
       @Override
       public void run() {
           try {
               while (true) {
                   Thread.sleep(1000);//模拟耗时
                   queue.put(produce());
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   
       private Integer produce() {
           int n = new Random().nextInt(10000);
           System.out.println("Thread:" + Thread.currentThread().getId() + "" +
                   " produce:" + n);
           return n;
       }
   }
   
   //消费者
   class Consumer implements Runnable {
       private final BlockingQueue<Integer> queue;
   
       public Consumer(BlockingQueue<Integer> queue) {
           this.queue = queue;
       }
   
       @Override
       public void run() {
           while (true) {
               try {
                   //模拟耗时
                   Thread.sleep(2000);
                   consume(queue.take());
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   
       private void consume(Integer take) {
           System.out.println("Thread:" + Thread.currentThread().getId() + " comsume:" + take);
       }
   }
   ```

   

2. 通过wait/notify来实现

   ```java
   //通过wait/notify来实现
   public class SCXFByWaitAndNotify {
    public static void main(String[] args) {
           List<Integer> queue = new ArrayList<>();
           ProducerW producerW = new ProducerW(queue);
           ConsumerW consumerW = new ConsumerW(queue);
           ConsumerW consumerW1 = new ConsumerW(queue);
           new Thread(producerW).start();
           new Thread(consumerW1).start();
           new Thread(consumerW).start();
       }
   }
   
   //生产者类
   class ProducerW implements Runnable {
       private final List<Integer> queue;
   
       public ProducerW(List<Integer> queue) {
           this.queue = queue;
       }
   
       @Override
       public void run() {
           try {
               while (true) {
                   produce();
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   
       private void produce() throws InterruptedException {
           int capacity = 5;//产品容器容量
           synchronized (queue) {
               //当容器满了停止生产
               while (queue.size() == capacity) {
                   System.out.println("容器已满暂停生产...");
                   queue.wait();
               }
               Random r = new Random();
               int p = r.nextInt(50);
               //模拟一秒生产一个产品
               Thread.sleep(1000);
               System.out.println("生产产品");
               queue.add(p);
               queue.notifyAll();
           }
       }
   }
   
   //消费者
   class ConsumerW implements Runnable {
       private final List<Integer> queue;
   
       public ConsumerW(List<Integer> queue) {
           this.queue = queue;
       }
   
       @Override
       public void run() {
           while (true) {
               try {
                   consume();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   
       private void consume() throws InterruptedException {
           synchronized (queue){
               while (queue.isEmpty()){
                   //停止消费
                   System.out.println("...容器为空，暂停消费...");
                   queue.wait();
               }
               Integer p = queue.remove(0);
               //模拟耗时
               Thread.sleep(1000);
               System.out.println("消费产品："+p);
               queue.notifyAll();
           }
       }
   }
   
   ```
   
   

### 如果你提交任务时，线程池队列已满，这时会发生什么

1. LinkedBlokingQueue:无界队列，继续添加任务到阻塞队列等待执行，因为linkedBlokingQueue可以近乎为一个无穷大的队列，可以无限存放任务
2. ArrayBlockingQueue:等有界队列：任务首先被添加到ArrayBlockingQueue中，ArrayBlockingQueue满了，则会拒绝使用策略RejectedExecutionHandler处理满了的任务，默认是AbortPolicy

### 为什么要使用线程池

避免频繁的创建和销毁线程，达到线程对象的重用。另外，使用线程池还可以根据项目的灵活的控制并发的数目。

### Java中用到的线程调度算法是什么

抢占式。一个线程用完CPU之后，操作系统会根据线程优先级、线程饥饿情况等数据算出一个总的优先级并且分配给下一个时间片给某个线程执行。

### Thread.sleep(0)的作用

由于Java是抢占式的线程调度算法，因此可能会出现某条线程常常获取到CPU控制权的情况，为了让某些优先级比较低的线程也能获取到CPU的控制权，可以使用Thread.sleep(0)手动触发一次操作系统分配时间片的操作，这也是平衡CPU控制权的一种操作。

### 什么是CAS

CAS,全称compare and swap，即比较-替换。

假设有三个操作数：内存V  旧的预期值A 要修改的值B。当且仅当预期值A和内存值V相同时，才会将内存值修改为B 并返回true。

否则什么都不做并返回false。当然CAS一定需要volatile配合，这样才能保证每次拿到的变量是主内存种最新的那个值，否则旧的预期值A对于某条线程来说，永远是一个不会变的值A，只要某次CAS失败，永远都不可能成功。

### ConcurrentHashMap的工作原理

- jdk1.6：ConcurrentHashMap是线程安全的，但是与HashTable相比，实现线程安全的方式不同。HashTable是通过对hash表结构进行锁定，是阻塞式的，当一个线程占有这个锁时，其他线程必须阻塞等待其释放锁。ConcurrentHashMap时采用分离锁的方式，他并没有对整个hash表进行锁定，而是局部锁定，也就是说当一个线程占有这个局部锁时，不影响其他线程对hash表其他地方的访问。具体是其内部有一个segment
- jdk1.8：ConcurrentHashMap不再使用segment分离所，而是采用了一种乐观锁CAS算法来实现同步问题，但是底层依然是数组+链表->红黑树的实现。

### CyclicBarrier和CountDownLatch区别

两个类非常相似，位于同一个包下面，都可以用来表示代码运行到某个点上，二者的区别在于：

- CyclicBarrier的某个线程运行在某个点上之后，该线程即停止运行，知道所有线程都运行到了这个点才会重新运行所有的线程；CountDownLatch则不是，某线程运行到某个点上之后，只是给某个数值-1而已，该线程继续执行
- CyclicBarrier只能唤起一个任务，CountDownLatch可以唤起多个任务
- CyclicBarrier可以重用，CountDownLatch不可重用，计数值为0，该CountDownLatch就不可以再用了。

### Java中的++操作符线程安全吗？

不是线程安全的操作。因为它涉及到多个指令，如读取变量值、增加然后存储回内存，这个过程可能会出现多个线程交叉。

### 多线程开发实践

- 给线程进行命名
- 最小化同步的范围
- 优先使用volatile
- 尽可能使用更高层次的并发工具而不是wait/notify来实现线程的通信，如BlockingQueue,Semeaphore
- 优先使用并发容器而不是非同步的容器
- 考虑使用线程池

## 关于volatile关键字

### 可以创建volatile数组吗？

Java中可以创建volatile类型数组，不过只是一个指向数组的引用而不是整个数组。如果改变引用指向的数组，将会收到volatile的保护，但是如果多个线程同时改变数组的元素，volatile标识符就不能起到之前的保护作用了。

### volatile能使得一个非原子操作变成原子操作吗？

一个典型的例子就是类中有一个long类型的成员变量。如果该成员变量会被多个线程访问，如计数器、价格等，最好就设置为volatile。

因为Java中读取long类型的变量不是原子的，需要分成两步。如果一个线程正在修改该long变量的值，另一个线程可能只能看到该值的前32位，但是对于一个volatile的long或者double变量来说，他们的读写是原子性的。

实践：用volatile修饰long和double变量，使其按照原子类型来进行读写。double和long都是64位宽，因此对这两种类型的读是分为两部分的。第一次只会读取第一个32位，然后再去读剩下的32位，这个过程不是原子的。但是Java中volatile型的long以及double的读写时原子的。volatile修饰符的另外一个作用是提供内存屏障（memory barrier）例如在分布式的框架中的应用，简单来说，就是当你写一个volatile变量之前会插入一个读屏障（read barrier）。意思是说，在你写一个volatile域的时候，能够保证任何线程都能看到你写的值，同时在写之前也能保证任何数值的更新对所有的线程是可见的，因为内存屏障会将其他所有写的值更新到缓存。

### volatile类型变量提供了什么保障

volatile主要有两个方面的作用

1. 避免指令重排
2. 可见性的保障

例如，JVM或者JIT为了获得更好的性能会对语句进行重排序，但是volatile类型变量即使在没有同步块的情况下赋值也不会与其他语句重排序。volatile提供happens-before的保证，确保一个线程的修改能对其他线程是可见的。某些情况下，volatile还能提供原子性，比如说读64位的数据类型。

## 关于集合

### Java中的集合及其继承关系

![集合框架](java-jichu-image\集合框架.png)

### poll()方法和remove()方法区别？

poll()都是从队列当中取出一个元素，但是poll()在获取元素失败的时候返回空，而remove()失败会抛出异常。

### LinkedHashMap和PriorityQueue的区别

PriorityQueue是一个优先级队列，保证最高或者最低优先级的元素总在队列头部，但是LinkedHashMap维持的顺序是插入的顺序。当遍历一个PriorityQueue的时候，没有任何的顺序保证，但是LInkedHashMap可以保证遍历的顺序是元素插入的顺序。

### WeakHashMap与HashMap的区别是什么？

WeakHashMap的工作与正常的HashMap类似，但是使用弱引用作为key，意思是当key对象没有任何引用的时候，key/value将会被回收。

### ArrayList和HashMap默认大小？

在Java7中，ArrayList的默认大小是10个元素，HashMap的默认大小是16个元素（必须是2的幂次方）

### Comparator和Comparable区别

Comparable接口用于定义对象的自然顺序，而comparator通常用于定义用户定制的顺序。comparable总是只有一个，但是可以有多个comparator来定义对象的顺序。

### 如何实现集合的排序

可以使用有序集合比如Tree***也可以使用有顺序的集合比如list，然后通过Collections.sort()进行排序；

### 如何打印数组的内容

使用Arrays.toString()和Arrays.deepToString()方法打印数组。由于数组没有实现toString()方法，所以如果将数组传递给sout方法，将无法打印数组的内容。但是Arrays.toString()可以打印。

### LinkedHashMap是单向链表还是双向？

双向循环链表

### TreeMap由红黑树实现

### 遍历ArrayList时如何正确移除一个元素

### 什么是ArrayMap，他和HashMap有什么区别

ArrayMap是Android提供的，用两个数组模拟map，更少占用内存空间，有更高的效率

### HashMap的实现原理

1. HashMap 概述： HashMap 是基于哈希表的Map 接口的非同步实现。此实现提供所有可
选的映射操作，并允许使用null 值和null 键。此类不保证映射的顺序，特别是它不保证该顺
序恒久不变。
2. HashMap 的数据结构： 在java 编程语言中，最基本的结构就是两种，一个是数组，另外
一个是模拟指针（引用），所有的数据结构都可以用这两个基本结构来构造的，HashMap
也不例外。HashMap 实际上是一个“链表散列”的数据结构，即数组和链表的结合体。
当我们往Hashmap 中put 元素时,首先根据key 的hashcode 重新计算hash 值,根绝hash 值得
到这个元素在数组中的位置(下标),如果该数组在该位置上已经存放了其他元素,那么在这个
位置上的元素将以链表的形式存放,新加入的放在链头,最先加入的放入链尾.如果数组中该
位置没有元素,就直接将该元素放到数组的该位置上.
需要注意Jdk 1.8 中对HashMap 的实现做了优化,当链表中的节点数据超过八个之后,该链表
会转为红黑树来提高查询效率,从原来的O(n)到O(logn)

### 你了解Fail-Fast 机制吗？
Fail-Fast 即我们常说的快速失败，

### Fail-fast 和Fail-safe 有什么区别

Iterator 的fail-fast 属性与当前的集合共同起作用，因此它不会受到集合中任何改动的影响。
Java.util 包中的所有集合类都被设计为fail->fast 的，而java.util.concurrent 中的集合类都为
fail-safe 的。当检测到正在遍历的集合的结构被改变时， Fail-fast 迭代器抛出
ConcurrentModificationException ， 而fail-safe 迭代器从不抛出
ConcurrentModificationException。

## 关于日期
### SimpleDateFormat 是线程安全的吗?
非常不幸，DateFormat 的所有实现，包括SimpleDateFormat 都不是线程安全的，因此你不
应该在多线程序中使用，除非是在对外线程安全的环境中使用，如将SimpleDateFormat 限
制在ThreadLocal 中。如果你不这么做，在解析或者格式化日期的时候，可能会获取到一个
不正确的结果。因此，从日期、时间处理的所有实践来说，我强力推荐joda-time 库。

### 如何格式化日期?

Java 中，可以使用SimpleDateFormat 类或者joda-time 库来格式日期。DateFormat 类允
许你使用多种流行的格式来格式化日期。参见答案中的示例代码，代码中演示了将日期格式
化成不同的格式，如dd-MM-yyyy 或ddMMyyyy。

## 关于异
### 简单描述java 异常体系
相比没有人不了解异常体系,关于异常体系的更多信息可以见
### throw 和throws 的区别
throw 用于主动抛出java.lang.Throwable 类的一个实例化对象，意思是说你可以通过关键字
throw 抛出一个Error 或者一个Exception ， 如： throw new
IllegalArgumentException(“size must be multiple of 2″),
而throws 的作用是作为方法声明和签名的一部分，方法被抛出相应的异常以便调用者能处
理。Java 中，任何未处理的受检查异常强制在throws 子句中声明。
### 关于序列化
Java 中，Serializable 与Externalizable 的区别
Serializable 接口是一个序列化Java 类的接口，以便于它们可以在网络上传输或者可以将它
们的状态保存在磁盘上，是JVM 内嵌的默认序列化方式，成本高、脆弱而且不安全。
Externalizable 允许你控制整个序列化过程，指定特定的二进制格式，增加安全机制。

## 关于JVM

### JVM 特性

- 平台无关性.
Java 语言的一个非常重要的特点就是与平台的无关性。而使用Java 虚拟机是实现这一特点
的关键。一般的高级语言如果要在不同的平台上运行，至少需要编译成不同的目标代码。而
引入Java 语言虚拟机后，Java 语言在不同平台上运行时不需要重新编译。Java 语言使用模
式Java 虚拟机屏蔽了与具体平台相关的信息，使得Java 语言编译程序只需生成在Java 虚拟
机上运行的目标代码（字节码），就可以在多种平台上不加修改地运行。Java 虚拟机在执行
字节码时，把字节码解释成具体平台上的机器指令执行。
### 简单解释一下类加载器

有关类加载器一般会问你四种类加载器的应用场景以及双亲委派模型,

### 简述堆和栈的区别

JVM 中堆和栈属于不同的内存区域，使用目的也不同。栈常用于保存方法帧和局部变量，而
对象总是在堆上分配。栈通常都比堆小，也不会在多个线程之间共享，而堆被整个JVM 的
所有线程共享。

### 简述JVM 内存分配

基本数据类型比变量和对象的引用都是在栈分配的。
堆内存用来存放由new 创建的对象和数组。
类变量（static 修饰的变量），程序在一加载的时候就在堆中为类变量分配内存，堆
中的内存地址存放在栈中。
实例变量：当你使用java 关键字new 的时候，系统在堆中开辟并不一定是连续的空
间分配给变量，是根据零散的堆内存地址，通过哈希算法换算为一长串数字以表征
这个变量在堆中的”物理位置”,实例变量的生命周期–当实例变量的引用丢失后，将被
GC（垃圾回收器）列入可回收“名单”中，但并不是马上就释放堆中内存。
局部变量: 由声明在某方法，或某代码段里（比如for 循环），执行到它的时候在栈
中开辟内存，当局部变量一但脱离作用域，内存立即释放。

### XML 解析的几种方式和特点

DOM, SAX, PULL 三种解析方式：

- DOM:消耗内存：先把xml 文档都读到内存中，然后再用DOM API 来访问树形结构，
  并获取数据。这个写起来很简单，但是很消耗内存。要是数据过大，手机不够牛逼，
  可能手机直接死机

- SAX:解析效率高，占用内存少，基于事件驱动的：更加简单地说就是对文档进行顺
  序扫描，当扫描到文档(document)开始与结束、元素(element)开始与结束、文档
  (document)结束等地方时通知事件处理函数，由事件处理函数做相应动作，然后继
  续同样的扫描，直至文档结束。

- PULL:与SAX 类似，也是基于事件驱动，我们可以调用它的next（）方法，来获取
  下一个解析事件（就是开始文档，结束文档，开始标签，结束标签），当处于某个
  元素时可以调用XmlPullParser 的getAttributte()方法来获取属性的值，也可调用它的
  nextText()获取本节点的值。

### JDK 1.7 特性
JDK 1.7 不像JDK 5 和8 一样的大版本， 但是， 还是有很多新的特性， 如try-with-resource 语句，这样你在使用流或者资源的时候，就不需要手动关闭，Java 会自动关闭。Fork-Join 池某种程度上实现Java 版的Map-reduce。允许Switch 中有String 变量和文本。菱形操作符(<>)用于类型推断，不再需要在变量声明的右边申明泛型，因此可以写出可读写更强、更简洁的代码。
### JDK 1.8 特性
java 8 在Java 历史上是一个开创新的版本，下面JDK 8 中5 个主要的特性：

- Lambda 表达式
- 允许像对象一样传递匿名函数Stream API
- 充分利用现代多核CPU，可以写出很简洁的代码Date 与Time API
- 有一个稳定、简单的日期和时间库可供你使用
- 扩展方法，现在，接口中可以有静态、默认方法。重复注解，现在你可以将相同的注解在同一类型上使用多次。

### IO 操作最佳实践
- 使用有缓冲的IO 类,不要单独读取字节或字符
- 使用NIO 和NIO 2 或者AIO,而非BIO
- 在finally 中关闭流
- 使用内存映射文件获取更快的IO