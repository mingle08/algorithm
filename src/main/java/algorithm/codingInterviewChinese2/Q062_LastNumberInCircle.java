package algorithm.codingInterviewChinese2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q062_LastNumberInCircle {

    // 1. 经典圆环
    public int lastNumber1(int n, int m) {
        if (n < 1 || m < 1) return -1;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int cur = 0;  //从1到m计数
        int curSize = n;  //用以记录链表中元素的个数

        Iterator<Integer> iterator = list.iterator();
        while (curSize > 1) {
            for (cur = 1; cur <= m; cur++) {
                if (iterator.hasNext())
                    iterator.next();
                else {
                    //------到链表末尾--------
                    iterator = list.iterator();
                    iterator.next();
                }
            }//end for
            iterator.remove();
            curSize--;
        }//end while
        iterator = list.iterator();
        return iterator.next();
    }

    /**
     * 2. 数学归纳
     * 定义函数f(n,m)，表示每次在n个数字0,1,...,n-1中每次删除第m个数字最后剩下的数字。
     * <p>
     * 在n个数字中，第一个被删除的数字是(m-1)%n，
     * <p>
     * <p>
     * 我们再来看分析这个序列：k+1，...，n-1，0，1，...，k-1 。我们将这个序列做一个映射，
     * 映射结果是形成一个从0到n-2的序列：
     * <p>
     * k+1     ->    0
     * <p>
     * k+2     ->    1
     * <p>
     * ......
     * <p>
     * n-1     ->     n-k-2
     * <p>
     * 0        ->     n-k-1
     * <p>
     * 1        ->     n-k
     * <p>
     * ......
     * <p>
     * k-1      ->     n-2
     * <p>
     * f'(n-1,m)     f(n-1,m)
     * <p>
     * 我们定义映射为p，那么p(x) = (x-k-1)%n 。 它表示如果映射前的数字是x，那么映射后的数字是(x-k-1)%n。
     * 该映射的逆映射是p-1(x)=(x+k+1)%n。
     * <p>
     * 证明：
     * <p>
     * 令y = p(x)，即 y = (x-k-1)%n
     * <p>
     * 则有  y = (x-k-1) +t1n，t1属于整数，且0<= y <n
     * <p>
     * < --->   x =  y - t1n + k + 1
     * <p>
     * <---->   x =  (y+k+1) + t2n ，即 y = (x+k+1) + tn，故p-1(x) =  (x+k+1) %n
     * <p>
     * <p>
     * 现在，我们发现经过映射之后的n-1个数字是不是和原先的n个数字形式上是一样的？只不过少看一个数字n-1而已。
     * 那么，对0，1，...，n-2这n-1个数字，排成一个圆圈，从数字0开始每次删除第m个数，剩下的数字是不是可以
     * 表示成f(n-1,m)?! 现在有没有发现我们之前为什么要定义那么序列为 f'(n-1,m)? 这是要建立两次删除之间的联系！
     * 就是说原始的n个元素，在删除第一个元素k之后，按理说初始序列已经被打乱了，没有规则了；但是我们通过一个映射关系，
     * 让序列重新排列成初始序列的形式。这样只要我们找到这样的映射关系，求出两次操作之间的函数关系（迭代规律）就将问
     * 题转化成了递归问题。而递归问题的出口很好确定，当n=1时，序列只有一个元素：0，f(1,m)就是这个0！
     * <p>
     * 既然有了映射关系，下面我们求两次迭代操作之间的关系，即如何由f(n-1,m)求得f(n,m)。
     * <p>
     * 求解：
     * <p>
     * 因为f(n,m) = f'(n-1,m)，且f'(n-1,m) = (f(n-1,m)+k+1)%n，故f(n,m) = (f(n-1,m)+k+1)%n。
     * 又因为 k = (m%n)-1， 代入f(n,m) = (f(n-1,m)+k+1)%n，得：f(n,m) = (f(n-1,m)+m)%n。
     * <p>
     * 因此，当n=1时，f(n,m) = 0
     * <p>
     * 当n>1时，f(n,m) = [f(n-1,m)+m]%n
     */
    public int lastNumber2(int n, int m) {
        if (n < 1 || m < 1)
            return -1;

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;  // 注意，是%，不是 /
        }
        return last;
    }

    /**
     * 这道题我们可以通过定义一个list集合去解决它。首先我们把所有的元素加入到list集合里，
     * 因为题目要求每次从n个数中删除第m个数，假如m是3，n是5，那么第一次删除的就是m-1下标的元素，
     * 而第二次删除的就是m-2下标开始数，第3个元素也就是m + m - 1下表的元素，但是因为此时下标已
     * 经越界了，此时我们可以通过取余去找到这个元素的下标，但是因为每次都会删除一个元素，n会不断
     * 减少，取余时n也要跟着减少才行。当list只剩最后一个，把那个元素取出来即可
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m, List<Integer> removeList) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0, j = 0;
        int removeNum = 0;    // 每次被删除的数
        while (list.size() > 1) {
            /*
             第一次的m-1,是因为数字从0开始，第三个数的下标是m-1，之后的循环，m-1，本来是要+m，但是因为删除了一个数，总数少了1，
             所以m-1正好是其下标。
             利用ArrayList的remove方法的原理：删除一个元素之后，把该位置后面的元素往前移一位，填补空白
             */
            index = (index + m - 1) % (n - j);
            removeNum = list.remove((int) index);
            removeList.add(removeNum);
            j++;
        }
        return list.get(0);
    }

    // 没出圈，值为0；出圈，值设为1
    public static void ysf(int n, int m, List<Integer> removeList) {
        int[] arr = new int[n];
        int out = 0, k = 0;    // out 是出圈的个数
        int index, c = 0;
        while (out != n) {
            index = c++;
            if (index > n - 1) {    // 也可以是 if(index == n)    注意：index和c要同步归零
                index = 0;
                c = 0;
            }
            if (arr[index] == 0) {
                k++;
                if (k == m) {
                    arr[index] = 1;
                    k = 0;
                    out++;
                    removeList.add(index);
                }
            }
        }
    }

    public static void main(String[] args) {
        Q062_LastNumberInCircle solution = new Q062_LastNumberInCircle();

        List<Integer> removelist = new ArrayList<>();
        int n = 5;
        int m = 3;
//        int number1 = solution.lastNumber1(n, m);
//        int number2 = solution.lastNumber2(n, m);
//        int last = solution.lastRemaining(n, m, removelist);
//        for (Integer removeNum : removelist) {
//            System.out.print(removeNum + "\t");
//        }
        ysf(n, m, removelist);
        for (int a : removelist) {
            System.out.print(a + "\t");
        }
//        System.out.println("最后剩下的数字：" + last);
    }
}
