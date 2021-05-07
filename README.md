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
```

例如，十进制的13：
13    0000 1101

>>1     0000 0110
>>|=    0000 1111
>>2     0000 0011
>>|=    0000 1111    (15)
>>4     0000 0000
>>|=    0000 1111    (15)
>>8     0000 0000
>>|=    0000 1111    (15)

经过多次右移之后再进制 | 运算，结果是最右边四位都是1
n = 15
n + 1 = 16

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
 
```

例如，十进制的13：
13    0000 1101
>>1     0000 0110
>>|=    0000 1111
>>2     0000 0011
>>|=    0000 1111    (15)
>>4     0000 0000
>>|=    0000 1111    (15)
>>8     0000 0000
>>|=    0000 1111    (15)

经过多次右移之后再进制 | 运算，结果是最右边四位都是1
i               0000 1111  (15)
i >>> 1     0000 0111  (7)
i - (i >>> 1) 得到
	        0000 1000  (8) 
即15 - 7 = 8

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

![1620373643311](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1620373643311.png)

四、HashMap 1.7和1.8的区别之一

​    1.7是头插法，1.8是尾插法