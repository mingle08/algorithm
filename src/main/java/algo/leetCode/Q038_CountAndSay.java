package algo.leetCode;

public class Q038_CountAndSay {
    public static void main(String[] args){
        Q038_CountAndSay solution = new Q038_CountAndSay();
        String str = solution.countAndSay(4);
        System.out.println(str);
    }
    public String countAndSay(int n) {
        //设置初始字符串
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;

        for(int i=1;i<n;i++){
            prev = curr;
            //将curr重新赋值
            curr = new StringBuilder();
            //当前字符
            char say = prev.charAt(0);
            //字符计数
            int count = 1;

            for(int j=1,len=prev.length();j<len;j++){
                if(prev.charAt(j) != say){
                    curr.append(count).append(say);
                    count =1;
                    say = prev.charAt(j);

                }else{
                    count++;
                }
            }
            curr.append(count).append(say);

        }
        return curr.toString();
    }
}
