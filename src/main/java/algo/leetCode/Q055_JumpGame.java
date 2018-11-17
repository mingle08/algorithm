package algo.leetCode;

public class Q055_JumpGame {

    public static void main(String[] args) {
        

    }
    
    public boolean canJump(int[] arr){
        if(arr.length < 1)
            return false;
        if(arr.length == 1)
            return true;
        
        int max = 0;  // 记录当前点能到达的最远位置
        for(int i=0; i<arr.length-1; i++){
            max = Math.max(max, i + arr[i]);
            if(max < i+1){ //如果到达不了后续点(这里通常情况为 当前点为0，前面的能达到的最大点 为当前点或者当前点前面的点)，返回false
                return false;
            }
            
            if(max >= arr.length-1){
                return true;
            }
        }
        return false;
    }

}
