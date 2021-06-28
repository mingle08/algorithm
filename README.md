# algo
学习JDK源码与leetcode



一、jdk源码中类似的代码：

1，HashMap中的tableSizeFor方法

```java
static final int tableSizeFor(int cap) {
    int n = cap - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
}

例如，参数cap为十进制的14，n就是13：
13      0000 1101

>>>1    0000 0110
|=      0000 1111
>>>2    0000 0011
|=      0000 1111    (15)
>>>4    0000 0000
|=      0000 1111    (15)
>>>8    0000 0000
|=      0000 1111    (15)

经过多次右移之后再进制 | 运算，结果是最右边四位都是1
n = 15
n + 1 = 16
```

2，Integer中的highestOneBit方法

```java
public static int highestOneBit(int i) {
    // HD, Figure 3-1
    i |= (i >>  1);
    i |= (i >>  2);
    i |= (i >>  4);
    i |= (i >>  8);
    i |= (i >> 16);
    return i - (i >>> 1);
}
例如，i为十进制的13：
13      0000 1101
>>1     0000 0110
|=      0000 1111
>>2     0000 0011
|=      0000 1111    (15)
>>4     0000 0000
|=      0000 1111    (15)
>>8     0000 0000
|=      0000 1111    (15)
经过多次右移之后再进制 | 运算，结果是最右边四位都是1
i           0000 1111  (15)
i >>> 1     0000 0111  (7)
i - (i >>> 1) 得到
0000 1000  (8)
即15 - 7 = 8
```

二、System.out.print()方法，带有synchronized锁

```java
public final static PrintStream out = null;    // System类中

// PrintStream类
public void print(String s) {
    if (s == null) {
        s = "null";
    }
    write(s);
}

// write方法带有synchronized
private void write(String s) {
    try {
        synchronized (this) {
            ensureOpen();
            textOut.write(s);
            textOut.flushBuffer();
            charOut.flushBuffer();
            if (autoFlush && (s.indexOf('\n') >= 0))
                out.flush();
        }
    }
    catch (InterruptedIOException x) {
        Thread.currentThread().interrupt();
    }
    catch (IOException x) {
        trouble = true;
    }
}
```

三、java.util包中有一个Objects工具类
有equals, deepEquals, hashCode, hash, toString, compare等方法
```aidl

public static int hashCode(Object o) {
	return o != null ? o.hashCode() : 0;
}

public static int hash(Object... values) {
	return Arrays.hashCode(values);
}


```

四、HashMap 1.7和1.8的区别之一

​    1.7是头插法，1.8是尾插法

五、jdk中的Array类
1，在Arrays中有使用Array.newInstance方法
```aidl
    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        @SuppressWarnings("unchecked")
        T[] copy = ((Object)newType == (Object)Object[].class)
            ? (T[]) new Object[newLength]
            : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0,
                         Math.min(original.length, newLength));
        return copy;
    }
```
2，Array.class在反射包(java.lang.reflect)中
```aidl
    public static Object newInstance(Class<?> componentType, int length)
        throws NegativeArraySizeException {
        return newArray(componentType, length);
    }
```

六、jad反编译工具
1，下载：https://varaneckas.com/jad/
2，解压，不需其它安装操作
3，使用：打开cmd，切换到jad所在路径，执行命令：jad  D:\study\gitcode\algo\target\classes\jdk\ListArray.class
    注意是.class文件，得到一个.jad文件，用记事本打开就行
```aidl
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ListArray.java

package jdk;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class ListArray
{

    public ListArray()
    {
    }

    public static void main(String args[])
    {
        int test[] = {
            1, 2, 3, 4
        };
        // 这里入参是一个二维数组，而且是一个1行三列的二维数组，所以size为1
        List list = Arrays.asList(new int[][] {
            test
        });
        System.out.println(list.size());
        Integer test2[] = {
            Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)
        };
        List list2 = Arrays.asList(test2);
        System.out.println(list2.size());
    }
}

```

七、两个质数1231与1237
在Boolean.java中发现其hashCode方法的返回值，true返回1231，false返回1237，为什么选这两个质数？
```aidl
    public static int hashCode(boolean value) {
        return value ? 1231 : 1237;
    }
```

八、死锁
产生死锁必须具备以下四个条件：

1. 互斥条件：该资源任意一个时刻只由一个线程占用。
2. 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
3. 不剥夺条件:线程已获得的资源在未使用完之前不能被其他线程强行剥夺，只有自己使用完毕后才释放资源。
4. 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。

为了避免死锁，我们只要破坏产生死锁的四个条件中的其中一个就可以了。现在我们来挨个分析一下：

1. **破坏互斥条件** ：这个条件我们没有办法破坏，因为我们用锁本来就是想让他们互斥的（临界资源需要互斥访问）。
2. **破坏请求与保持条件** ：一次性申请所有的资源。
3. **破坏不剥夺条件** ：占用部分资源的线程进一步申请其他资源时，如果申请不到，可以主动释放它占有的资源。
4. **破坏循环等待条件** ：依靠按序申请资源来预防。按某一顺序申请资源，释放资源则反序释放。破坏循环等待条件。


九、数据库的三范式（Normal Form）
1NF:字段不可分;

2NF:有主键，非主键字段依赖主键;

3NF:非主键字段不能相互依赖;

解释:

1NF:原子性 字段不可再分,否则就不是关系数据库;

2NF:唯一性 一个表只说明一个事物;

3NF:每列都与主键有直接关系，不存在传递依赖;

十、线程池

```java
/** 
FixedThreadPool和SingleThreadPool使用的队列是LinkedBlockingQueue,这是无界队列，允许请求的最大长度为：Integer.MAX_VALUE，
可能会堆积大量的请求，从而导致OOM
*/
public static ExecutorService newFixedThreadPool(int nThreads) {
    return new ThreadPoolExecutor(nThreads, nThreads, 
                                  0L, TimeUnit.MILLISECONDS, 
                                  new LinkedBlockingQueue<Runnable>());
}

public static ExecutorService newSingleThreadExecutor() {
    return new FinalizableDelegatedExecutorService
        (new ThreadPoolExecutor(1, 1,
                                0L, TimeUnit.MILLISECONDS,
                                new LinkedBlockingQueue<Runnable>()));
}

/**
看看LinkedBlockingQueue的容量大小：Integer.MAX_VALUE
*/
public LinkedBlockingQueue() {
    this(Integer.MAX_VALUE);
}



/**
CachedThreadPool和ScheduleThreadPool允许的创建线程数量为：Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM
*/
public static ExecutorService newCachedThreadPool() {
    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
}

public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
    return new ScheduledThreadPoolExecutor(corePoolSize);
}

// ScheduledThreadPoolExecutor类
public ScheduledThreadPoolExecutor(int corePoolSize) {
    super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
          new DelayedWorkQueue());
}

/**
线程池参数分析
corePoolSize : 核心线程数
maximumPoolSize : 最大线程数
keepAliveTime : 非核心线程的超时时长,如果非核心线程闲置时间超过keepAliveTime之后，就会被回收。如果设置allowCoreThreadTimeOut为true，则该参数也表示				核心线程的超时时长
unit : 超时时长单位
workQueue : 线程池中的任务队列，该队列主要用来存储已经被提交但是尚未执行的任务
handler : 拒绝策略
*/
public ThreadPoolExecutor(int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        RejectedExecutionHandler handler)
```



十一、HashMap中能保证元素有序的是哪个Map？

![image-20210625205908982](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210625205908982.png)



怎么保证有序？

查看源码，我们也会发现，linkedHashMap只是维护了一个链表，并没有put、remove方法的具体实现。

```java
/**
The iteration ordering method for this linked hash map: true for access-order, false for insertion-order.
true 访问顺序，false 插入顺序
*/
final boolean accessOrder;
```

添加元素要调用父类的put方法：

![image-20210625210433596](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210625210433596.png)

而linkedHashMap重写了newNode方法：

```java
/**
先new一个节点，然后调用linkNodeLast，将新的节点加到链表末尾
*/
Node<K,V> newNode(int hash, K key, V value, Node<K,V> e) {
    LinkedHashMap.Entry<K,V> p =
        new LinkedHashMap.Entry<K,V>(hash, key, value, e);
    linkNodeLast(p);
    return p;
}

/**
link at the end of list
原来的尾指向p，p指向原来的尾，双向链表
*/
private void linkNodeLast(LinkedHashMap.Entry<K,V> p) {
    LinkedHashMap.Entry<K,V> last = tail;
    tail = p;
    if (last == null)
        head = p;
    else {
        p.before = last;
        last.after = p;
    }
}


/**
如果在初始化linkedHashMap对象的时候，accessOrder设为true，则表示按照访问顺序有序，在get方法中，会对访问到的元素进行处理
*/
public V get(Object key) {
    Node<K,V> e;
    if ((e = getNode(hash(key), key)) == null)
        return null;
    if (accessOrder)
        afterNodeAccess(e);
    return e.value;
}

void afterNodeAccess(Node<K,V> e) { // move node to last
    LinkedHashMap.Entry<K,V> last;
    if (accessOrder && (last = tail) != e) {
        LinkedHashMap.Entry<K,V> p =
            (LinkedHashMap.Entry<K,V>)e, b = p.before, a = p.after;
        p.after = null;
        if (b == null)
            head = a;
        else
            b.after = a;
        if (a != null)
            a.before = b;
        else
            last = b;
        if (last == null)
            head = p;
        else {
            p.before = last;
            last.after = p;
        }
        tail = p;
        ++modCount;
    }
}

// LinkedHashMap的5个构造方法
public LinkedHashMap(int initialCapacity, float loadFactor) {
    super(initialCapacity, loadFactor);
    accessOrder = false;
}

public LinkedHashMap(int initialCapacity) {
    super(initialCapacity);
    accessOrder = false;
}

public LinkedHashMap() {
    super();
    accessOrder = false;
}

public LinkedHashMap(Map<? extends K, ? extends V> m) {
    super();
    accessOrder = false;
    putMapEntries(m, false);
}

// 只有这个方法，可以由外部设定accessOrder
public LinkedHashMap(int initialCapacity,
                         float loadFactor,
                         boolean accessOrder) {
    super(initialCapacity, loadFactor);
    this.accessOrder = accessOrder;
}
```

十二、BeanFactory与FactoryBean
1，BeanFactory 是接口，提供了IOC容器最基本的形式，给具体的IOC容器的实现提供了规范，功能非常复杂。
2，FactoryBean 也是接口，为IOC容器中Bean的实现提供了更加灵活的方式，FactoryBean在IOC容器的基础上给Bean的实现加上了一个简单的
工厂模式和装饰模式 ，我们可以在getObject()方法中灵活配置.

如果我们想要编写一些比较复杂点儿的逻辑就会触及到其他一些不必要的接口，或者只是想简单的去构造Bean，不希望实现IOC容器原有的大量方法，这时候就可以使用FactoryBean

3，FactoryBean的实际应用

（1）使用MyBatis时就用到了FactoryBean

```xml
<!-- SqlSessionFactory -->
<bean id="dgSqlSessionFactory"  class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dgDataSource"/>
    <!-- mybatis配置文件路径-->
    <property name="configLocation"  value="classpath:mybatis-config.xml"/>   
    <!-- 实体类映射文件路径-->
    <property name="mapperLocations" value="classpath*:query-mapping/**/*.xml"/>
</bean>
```



```java
package org.mybatis.spring;

// 省略imports

public class SqlSessionFactoryBean implements FactoryBean<SqlSessionFactory>, InitializingBean, ApplicationListener<ApplicationEvent> {
    private static final Log LOGGER = LogFactory.getLog(SqlSessionFactoryBean.class);
    private Resource configLocation;
    private Resource[] mapperLocations;
    private DataSource dataSource;
    private TransactionFactory transactionFactory;
    private Properties configurationProperties;
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    private SqlSessionFactory sqlSessionFactory;
    
    // 中间省略很多代码
    
    public SqlSessionFactory getObject() throws Exception {
        if (this.sqlSessionFactory == null) {
            this.afterPropertiesSet();
        }

        return this.sqlSessionFactory;
    }

    public Class<? extends SqlSessionFactory> getObjectType() {
        return this.sqlSessionFactory == null ? SqlSessionFactory.class : this.sqlSessionFactory.getClass();
    }

    public boolean isSingleton() {
        return true;
    }
    
}
```

（2）quartz定时器

```java
package org.springframework.scheduling.quartz;

// 省略imports

public class SchedulerFactoryBean extends SchedulerAccessor implements FactoryBean<Scheduler>, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, SmartLifecycle {
    public static final String PROP_THREAD_COUNT = "org.quartz.threadPool.threadCount";
    public static final int DEFAULT_THREAD_COUNT = 10;
    private static final ThreadLocal<ResourceLoader> configTimeResourceLoaderHolder = new ThreadLocal();
    private static final ThreadLocal<Executor> configTimeTaskExecutorHolder = new ThreadLocal();
    private static final ThreadLocal<DataSource> configTimeDataSourceHolder = new ThreadLocal();
    private static final ThreadLocal<DataSource> configTimeNo
        
    // 省略代码    
        
}
```

十三、Spring的事务传播机制
REQUIRED: Spring默认的事务传播类型，如果当前没有事务，就自己创建一个事务，如果当前存在事务，就加入到该事务中
SUPPORTS: 当前存在事务，则加入当前事务，如果不存在事务，就以非事务方法执行
MANDATORY: 当前存在事务，则加入当前事务，如果当前事务不存在，则抛异常
REQUIRES_NEW: 创建一个新事务，如果存在当前事务，则挂起该事务
NOT_SUPPORTED: 以非事务方式执行，如果当前存在事务，则挂起该事务
NEVER: 不使用事务，如果当前事务存在，则抛出异常
NESTED: 如果当前事务存在，则在嵌套事务中执行，否则开启一个事务

十四、Spring事务什么时候会失效
    Spring事务的原理是AOP，进行了切面增强，那么失效的根本原因就是这个AOP不起作用了。常见情况有以下几种：
1，自调用
   类里面使用this调用本类的方法（this通常省略），此时这个this对象不是代理类，而是对象本身
   解决方法很简单，使用代理类调用该方法
2，方法不是public
   @Transactional只能用于public方法上，否则事务不会生效，如果偏要用在非public方法上，可以开启AspectJ代理模式
3，数据库不支持事务
4，没有被Spring管理
5，异常被吃掉，事务不会回滚（或者抛出的异常没有被定义，默认为RuntimeException）

十五、项目中使用dubbo的版本
大致了解一下dubbo的版本更新事件：
2012年10月23号   2.5.3
2017年9月27号     2.5.4
2018年1月8号       2.6.0    此版本合并了dubbox
2019年5月             2.7.2

阿里的dubbo最后一个版本号是2.6.10.1，之后就捐赠给了apache

![image-20210627233345791](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210627233345791.png)

apache的dubbo版本从2.7.0开始

![image-20210627233420698](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210627233420698.png)

1，引用的jar包的版本：2.6.8
2，xml中配置的dubbo版本号

```xml
<!-- 使用的版本号为 1.0.0 -->
<dubbo:service registry="loan" version="1.0.0" scope="remote" register="true"
               interface="com.abc.pfs.service.api.QueryService" ref="queryService"/>
```

3，默认的协议：序列化 hessian2，传输 dubbo

```xml
<!-- 序列化协议 hessian2 -->
<dubbo:provider serialization="hessian2" retries="0"  filter="setOrg" timeout="${dubbo.provider.timeout:3000}"
                threads="${dubbo.provider.threads:300}" />
<!-- 传输协议 dubbo -->
<dubbo:protocol name="dubbo" port="${dubbo.protocol.port}" />
```



十六、单例模式，为什么枚举型单例是安全的？

因为反射包下的Constructor中的newInstance方法，不允许通过反射获取枚举的实例

```java
// java.lang.reflect.Constructor
public T newInstance(Object ... initargs)
        throws InstantiationException, IllegalAccessException,
               IllegalArgumentException, InvocationTargetException
{
   if (!override) {
     if (!Reflection.quickCheckMemberAccess(clazz, modifiers)) {
        Class<?> caller = Reflection.getCallerClass();
        checkAccess(caller, clazz, null, modifiers);
     }
   }
   // 如果是ENUM，抛出异常
   if ((clazz.getModifiers() & Modifier.ENUM) != 0)
      throw new IllegalArgumentException("Cannot reflectively create enum objects");
   ConstructorAccessor ca = constructorAccessor;   // read volatile
   if (ca == null) {
     ca = acquireConstructorAccessor();
   }
   @SuppressWarnings("unchecked")
   T inst = (T) ca.newInstance(initargs);
     return inst;
}
```

十七、Dubbo SPI

1，与Java SPI相比，Dubbo SPI做了一定的改进和优化：

（1）JDK标准的SPI会一次性实例化扩展点所有实现，如果有扩展实现则初始化很耗时，如果没有用上也加载，则浪费资源
（2）如果扩展加载失败，则连扩展的名称都获取不到了，加载失败的真正原因被“吃掉”了，报的错并不是真正失败的原因
（3）增加了对扩展IOC和AOP的支持，一个扩展可以直接setter注入其他扩展。在Java SPI使用中，java.util.ServiceLoader
会一次把某接口下的所有实现庆全部初始化，用户直接调用即可。 Dubbo SPI只是加载配置文件中的类，并分成不同的种类缓存
在内存中，而不会立即全部初始化，在性能上有更好的表现。

2，ExtensionLoader的工作原理

![image-20210627212600584](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210627212600584.png)

ExtensionLoader的逻辑入口可以分为：

（1）getExtension  获取普通扩展类

（2）getAdaptiveExtension  获取自适应扩展类

（3）getActivateExtension  获取自动激活的扩展类

3，扩展点动态编译的实现

Dubbo中有三种代码编译器：JdkCompiler、JavassitCompiler和AdaptiveCompiler

![image-20210627214042897](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210627214042897.png)

```java
/**
注解的默认值是javassist，即Javassist编译器将作为默认编译器。
如果用户想改变默认编译器，则可以通过<dubbo:application compiler="jdk" />标签进行配置
*/
@SPI("javassist")
public interface Compiler {
    Class<?> compile(String code, ClassLoader classLoader);
}
```



（1）JdkCompiler使用了JDK自带的编译器

![image-20210627215411722](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210627215411722.png)

```java
import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject.Kind;
public class JdkCompiler extends AbstractCompiler {.......}
```

（2）Javassist编译器

```java
public class JavassitCompiler extends AbstractCompiler {.......}
```

（3）Adaptive编译器

```java
/**
AdaptiveCompiler直接实现Compiler，没有继续AbstractCompiler
注解@Adaptive，说明AdaptiveCompiler会固定为默认实现，这个Compiler的主要作用就是为了管理其他compiler
*/
@Adaptive
public class AdaptiveCompiler implements Compiler {
    private static volatile String DEFAULT_COMPILER;

    public AdaptiveCompiler() {
    }

    // 设置默认的编译器名称
    public static void setDefaultCompiler(String compiler) {
        DEFAULT_COMPILER = compiler;
    }

    // 通过ExtensionLoader获取对应的编译器扩展类实现，并调用真正的compiler做编译
    public Class<?> compile(String code, ClassLoader classLoader) {
        ExtensionLoader<Compiler> loader = ExtensionLoader.getExtensionLoader(Compiler.class);
        String name = DEFAULT_COMPILER;
        Compiler compiler;
        if (name != null && name.length() > 0) {
            compiler = (Compiler)loader.getExtension(name);
        } else {
            compiler = (Compiler)loader.getDefaultExtension();
        }

        return compiler.compile(code, classLoader);
    }
}
```

十八、什么是MVCC

1，MVCC是Muiti-Version Concurrency Control的简写，即多版本并发控制：读取数据时通过一种类似快照的方式将数据保存下来，这样读锁和写锁就不冲突了，不同的事务session会看到自己特定版本的数据，版本链

MVCC只有在READ COMMITTED和REPEATABLE READ两个隔离级别下工作。其他两个隔离级别和MVCC不兼容，因为READ UNCOMMITTED总是读取最新的数据行，而不是符合当前事务版本的数据行。而SERIALIZABLE则会对所有读取的行都加锁。

2，聚簇索引记录中有两个必要的隐藏列：
（1）trx_id  用来存储每次对某条聚簇索引记录进行修改时候的事务id
（2）roll_pointer  每次对哪条聚簇索引记录有修改的时候，都会把老版本写入undo日志中。这个roll_pointer就是存了一个指针，
它指向这条聚簇索引记录的上一个版本的位置，通过它来获得上一个版本的记录信息（注意插入操作的undo日志没有这个属性，因为它没有老版本）

3，READ COMMITTED和REPEATABLE READ的区别就在于它们生成READVIEW的策略不同：
（1）READ COMMITTED隔离级别下的事务在每次查询的开始都会生成一个独立的READVIEW
（2）REPEATABLE READ隔离级别则在第一次读的时候生成一个READVIEW，之后的读都复用之前的READ VIEW

4，开启事务时创建readview,readview维护当前活动的事务id，即未提交的事务尖，排序生成一个数组
访问数据，获取数据中的事务id（获取的是事务id最大的记录），对比readview:
（1）如果在readview的左边（比readview小），可以访问（在左边意味着该事务已经提交）
（2）如果在readview的右边（比readview大），或者在readview区间内，不可以访问，获取roll_pointer，取上一版本重新对比（在右边意味着，该事务在readview生成之后出现；在readview区间内意味着该事务还未提交）

十九、mysql主从同步原理

1，有三个线程：binlog dump thread（master）、I/O thread（slave）和sql thread（slave）

2，过程：
（1）主节点binlog，主从复制的基础是主库记录数据库的所有变更记录到binlog。binlog在数据库服务器启动那一刻起，保存所有修改数据库结构或内容的一个文件
（2）主节点log dump线程：当log有变动时，log dump线程读取其内容并发送给从节点
（3）从节点I/O线程接收binlog内容，并将其写入到relay log文件中
（4）从节点sql线程读取relay log文件内容，对数据更新进行同步，最终保证主从数据库的一致性

3，同步方式
（1）异步复制：mysql默认的复制方式
（2）全同步复制：主库强制同步日志到从库，所有的从库都执行完成后才返回给客户端，此方式性能不高
（3）半同步复制：从库写入日志成功后返回ACK确认给主库，主库收到至少一个从库的确认就认为同步操作完成

