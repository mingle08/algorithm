package algo.swordToOffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q062_LastNumberInCircle {

    // 1. 经典圆环
    public int lastNumber1(int n,int m){
        if(n<1||m<1) return -1;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            list.add(i);
        }

        int cur = 0;  //从1到m计数
        int curSize = n;  //用以记录链表中元素的个数

        Iterator<Integer> iterator = list.iterator();
        while(curSize>1){
            for(cur=1;cur<=m;cur++){
                if(iterator.hasNext())
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
     *
     * 在n个数字中，第一个被删除的数字是(m-1)%n，
     *
     *
     * 我们再来看分析这个序列：k+1，...，n-1，0，1，...，k-1 。我们将这个序列做一个映射，
     * 映射结果是形成一个从0到n-2的序列：
     *
     *        k+1     ->    0
     *
     *        k+2     ->    1
     *
     *               ......
     *
     *        n-1     ->     n-k-2
     *
     *        0        ->     n-k-1
     *
     *        1        ->     n-k
     *
     *               ......
     *
     *        k-1      ->     n-2
     *
     *     f'(n-1,m)     f(n-1,m)
     *
     * 我们定义映射为p，那么p(x) = (x-k-1)%n 。 它表示如果映射前的数字是x，那么映射后的数字是(x-k-1)%n。
     * 该映射的逆映射是p-1(x)=(x+k+1)%n。
     *
     * 证明：
     *
     * 令y = p(x)，即 y = (x-k-1)%n
     *
     * 则有  y = (x-k-1) +t1n，t1属于整数，且0<= y <n
     *
     * < --->   x =  y - t1n + k + 1
     *
     * <---->   x =  (y+k+1) + t2n ，即 y = (x+k+1) + tn，故p-1(x) =  (x+k+1) %n
     *
     *
     * 现在，我们发现经过映射之后的n-1个数字是不是和原先的n个数字形式上是一样的？只不过少看一个数字n-1而已。
     * 那么，对0，1，...，n-2这n-1个数字，排成一个圆圈，从数字0开始每次删除第m个数，剩下的数字是不是可以
     * 表示成f(n-1,m)?! 现在有没有发现我们之前为什么要定义那么序列为 f'(n-1,m)? 这是要建立两次删除之间的联系！
     * 就是说原始的n个元素，在删除第一个元素k之后，按理说初始序列已经被打乱了，没有规则了；但是我们通过一个映射关系，
     * 让序列重新排列成初始序列的形式。这样只要我们找到这样的映射关系，求出两次操作之间的函数关系（迭代规律）就将问
     * 题转化成了递归问题。而递归问题的出口很好确定，当n=1时，序列只有一个元素：0，f(1,m)就是这个0！
     *
     * 既然有了映射关系，下面我们求两次迭代操作之间的关系，即如何由f(n-1,m)求得f(n,m)。
     *
     * 求解：
     *
     * 因为f(n,m) = f'(n-1,m)，且f'(n-1,m) = (f(n-1,m)+k+1)%n，故f(n,m) = (f(n-1,m)+k+1)%n。
     * 又因为 k = (m%n)-1， 代入f(n,m) = (f(n-1,m)+k+1)%n，得：f(n,m) = (f(n-1,m)+m)%n。
     *
     * 因此，当n=1时，f(n,m) = 0
     *
     * 当n>1时，f(n,m) = [f(n-1,m)+m]%n
     */
    public int lastNumber2(int n, int m){
        if (n < 1 || m < 1)
            return -1;

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;  // 注意，是%，不是 /
        }
        return last;
    }

    public static void main(String[] args){
        Q062_LastNumberInCircle solution = new Q062_LastNumberInCircle();

        int n = 10;
        int m = 3;
        int number1 = solution.lastNumber1(n, m);
        int number2 = solution.lastNumber2(n, m);

        System.out.println(number1 + ", " + number2);
    }
}
