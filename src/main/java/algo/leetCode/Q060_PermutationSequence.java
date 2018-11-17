package algo.leetCode;

/**
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *  * 给定 n 和 k，返回第 k 个排列。
 *  
 * 输入: n = 3, k = 3
 * 输出: "213"
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"


 * 输入: n = 4, k = 9
 * 输出: "2314"
 *   "1234"
 *   "1243"
 *   "1324"
 *   "1342"
 *   "1423"
 *   "1432"
 *   "2134"
 *   "2143"
 *   "2314"
 *   "2341"
 *   "2413"
 *   "2431"
 *   "3124"
 *   "3142"
 *   "3214"
 *   "3241"
 *   "3412"
 *   "3421"
 *   "4123"
 *   "4132"
 *   "4213"
 *   "4231"
 *   "4312"
 *   "4321"
 */
public class Q060_PermutationSequence {

    public static void main(String[] args) {
        Q060_PermutationSequence solution = new Q060_PermutationSequence();
        int num = 4;
        int index = 9;
        String str = solution.getPermutation(num, index);
        System.out.println(str);

    }
    
    /**
     * 第k个排列的第一个元素在0-n中的位置为（k-1）/（n-1）！
     */
    public String getPermutation(int n, int k) {  
        StringBuilder ans=new StringBuilder("");
        int num=k;
        StringBuilder s=new StringBuilder("");
        int factorial=calFactorial(n);
        
        for(int i=1;i<=n;i++){
            s.append(i);
        }
        
        for(int i=n;i>=1;i--){
            factorial/=i;  // 如果n=4，以每个数字开头的有24/4 = 6种
            /**
             * 第9个，前面有6个以1开头的， （9-1）/ 6 = 1，表示这第9个，是以2为开头的
             */
            int index=(num-1)/factorial;
            
            String tmp=""+s.charAt(index);
            ans.append(tmp);
            num-=index*factorial;
            s=s.deleteCharAt(index);
        }
        
        return ans.toString();
    }
    
    private int calFactorial(int n){
        int ans = 1;
        for(int i=2; i <= n; i++){
            ans *= i;
        }
        return ans;
    }

}
