package algo.swordToOffer;

public class Q038_3_EightQueens {

    private static int total = 0;
    private boolean check(int columnIndex[],int length){
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                //是否在对角线上
                if(i-j==columnIndex[i]-columnIndex[j]
                        ||j-i==columnIndex[i]-columnIndex[j]){
                    return false;
                }
            }
        }
        return true;
    }

    //全排列
    void Permutation(int columnIndex[],int length,int index){
        if(length == index){
            if(check(columnIndex,length)){
                total++;
                //打印
                for(int i=0;i<length;i++){
                    System.out.printf("%d ",columnIndex[i]);
                }
                System.out.printf("\n---------------------------\n");
            }
        }else{
            for(int i= index ;i<length;i++){
                swap(columnIndex, index, i);
                Permutation(columnIndex,length,index+1);
                swap(columnIndex, index, i);
            }
        }
    }

    private void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


    private void eightQueen(){
        int queens =8;
        int[] columnIndex = new int[queens];
        for(int i=0;i<queens;i++){
            columnIndex[i] = i;
        }
        Permutation(columnIndex, queens ,0);
    }

}






