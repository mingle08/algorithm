package jdk;

import java.util.concurrent.TimeUnit;

/**
 * 产生死锁必须具备以下四个条件： *
 * 1. 互斥条件：该资源任意一个时刻只由一个线程占用。
 * 2. 请求与保持条件：一个线程已经保持了至少一个资源，又提出新的资源请求。而新请求的资源已经被其他线程占有，
 *                  此线程只能阻塞等待，但又不释放自己已获得的资源，使得其他线程无法获取这个资源
 * 3. 不剥夺条件:线程已获得的资源在未使用完之前不能被其他线程强行剥夺，只有自己使用完毕后才释放资源。
 * 4. 循环等待条件:若干线程之间形成一种头尾相接的循环等待资源关系。
 *
 * 为了避免死锁，我们只要破坏产生死锁的四个条件中的其中一个就可以了。
 * 1. **互斥条件不能破坏** ：这个条件我们没有办法破坏，因为我们用锁本来就是想让他们互斥的（临界资源需要互斥访问）。
 * 2. **破坏请求与保持条件** ：一次性申请所有的资源。
 * 3. **破坏不剥夺条件** ：占用部分资源的线程进一步申请其他资源时，如果申请不到，可以主动释放它占有的资源。
 * 4. **破坏循环等待条件** ：进程必须按规定的顺序申请资源。 对所有不同类型的资源排序，要求每个进程按规定的顺序申请资源。
 *    这种方法的缺点如下：
 *     （1）限制了新设备的增加
 *     （2）系统为资源分配的序号与进程实际使用资源的顺序不同，造成浪费
 *     （3）给用户编程带来了麻烦
 */
public class DeadLock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            synchronized(a) {
                System.out.println(Thread.currentThread().getName() + " I get a");
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " I want get b");
                    synchronized (b) {
                        System.out.println("I get b");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();


        new Thread(() -> {
            synchronized(b) {
                System.out.println(Thread.currentThread().getName() + " I get b");
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " I wanna get a");
                    synchronized (a) {
                        System.out.println("I get a");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
