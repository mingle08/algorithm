package algo.leetCode;

public class Q072_EditDistance {

    public void main(String[] args){

    }

    public int minDistance2(String word1, String word2){
        if(word1.isEmpty()) return word2.length();
        if(word2.isEmpty()) return word1.length();
        int[] steps = new int[word2.length()+1];
        for(int j = 0 ; j<=word2.length() ; j++){
            steps[j] = j;
        }
        for(int i = 1 ; i<=word1.length() ; i++){
            int pre = steps[0];
            steps[0] = i;
            for(int j = 1 ; j<=word2.length() ; j++){
                int temp = steps[j];
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    steps[j] = pre;
                }else{
                    steps[j] = Math.min(pre+1, Math.min(steps[j]+1, steps[j-1]+1));
                }
                pre = temp;
            }

        }
        return steps[word2.length()];
    }


}
