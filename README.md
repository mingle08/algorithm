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
