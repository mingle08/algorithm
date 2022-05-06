package algorithm.leetCode;

public class LeetCode011_ContainerWithMostWater {

    public static int maxArea(int[] height){
        int i = 0;
        int j = height.length - 1;
        int maxS = 0;
        int thisS = 0;
        while(i != j){
            thisS = Math.min(height[i], height[j]) * (j - i);
            maxS = thisS > maxS ? thisS : maxS;
            if(height[i] > height[j]) {  // 突破点在高的柱子上：哪个高度小，就换哪个
                j--;
            }else{
                i++;
            }
        }
        return maxS;
    }

    public static void main(String[] args){
        int[] a = {3,1, 9, 1};
        int maxS = maxArea(a);
        System.out.println(maxS);
    }
}
