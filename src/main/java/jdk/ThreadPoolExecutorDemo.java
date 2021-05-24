package jdk;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorDemo {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    /**
     *   COUNT_BITS = 32 - 3 = 29
     *   1 << COUNT_BITS 即  1 << 29，十进制为536870912
     *   0010 0000 0000 0000 0000 0000 0000 0000
     *   再减1，得到：
     *   0001 1111 1111 1111 1111 1111 1111 1111
     *   这就是(1 << COUNT_BITS) - 1，即CAPACITY的二进制表示，十进制为536870911
     *
     *   ~CAPACITY是把CAPACITY取反，得到：
     *   1110 0000 0000 0000 0000 0000 0000 0000
     *
     *   状态               计算方式                      计算结果                             前三位
     * RUNNING       -1 << COUNT_BITS       1110 0000 0000 0000 0000 0000 0000 0000          111
     * SHUTDOWN       0 << COUNT_BITS       0000 0000 0000 0000 0000 0000 0000 0000          000
     * STOP           1 << COUNT_BITS       0010 0000 0000 0000 0000 0000 0000 0000          001
     * TIDYING        2 << COUNT_BITS       0100 0000 0000 0000 0000 0000 0000 0000          010
     * TERMINATED     3 << COUNT_BITS       0110 0000 0000 0000 0000 0000 0000 0000          011
     *
     *
     *
     *  c & ~CAPACITY 就是取前三位
     *  c & CAPACITY  取低 29 位的值, 也就是线程数
     *
     *  Integer.MIN = -2147483648
     *  Integer.MAX = 2147483647
     *
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        // The main pool control state, ctl
        final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
        System.out.println("ctl=" + ctl + ", CAPACITY=" + CAPACITY + "，RUNNING=" + RUNNING + "，STOP=" + STOP + ", TIDYING=" + TIDYING);
        // ctl=-536870912, CAPACITY=536870911，RUNNING=-536870912，STOP=536870912, TIDYING=1073741824
    }

}
