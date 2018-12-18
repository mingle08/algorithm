package algo.swordToOffer;

public class Q056_1_NumbersAppearOnce {
    public boolean fidnNumbersAppearOnce(int[] data, int[] num1, int[] num2){
        if (data == null || data.length < 2)
            return false;

        int resultExclusiveOR = 0;
        for (int i = 0; i < data.length ; i++)
            resultExclusiveOR ^= data[i];

        int indexOf1 = findFirstIndexOf1(resultExclusiveOR);

        for(int j=0; j < data.length; j++){
            if (isBit1(data[j], indexOf1))
                num1[0] ^= data[j];
            else
               num2[0] ^= data[j];
        }

        return true;

    }

    private int findFirstIndexOf1(int num){
        int indexBit = 0;
        while ((num & 1) == 0 && indexBit < 32){
            num = num >>> 1;
            indexBit++;
        }
        return indexBit;
    }

    private boolean isBit1(int num, int indexBit){
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    public static void main(String[] args){
        Q056_1_NumbersAppearOnce solution = new Q056_1_NumbersAppearOnce();

        int[] data = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        boolean canFind = solution.fidnNumbersAppearOnce(data, num1, num2);
        if (canFind){
            System.out.println(num1[0]);
            System.out.println(num2[0]);
        }
    }
}