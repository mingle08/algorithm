package jdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class PrimeDemo {

    private static boolean[] sieve(int range){
        boolean[] isPrime = new boolean[range + 1];
        for (int i = 2; i < isPrime.length; i++){
            isPrime[i] = true;
        }
        int sqrtCeil = (int) Math.ceil(Math.sqrt(range)); // 平方根
        System.out.println("平方根为：" + sqrtCeil);
        for (int i = 2; i <= sqrtCeil; i++){
            if (isPrime[i]){// false的表示判定过
//                for (int k = 2 * j; k <= range; k += j){  // 把2的倍数，3的倍数，5的倍数这些合数都去掉
//                    isPrime[k] = false;
//                }
                for (int j = 2; i * j <= range; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return isPrime;
    }

    private static int findLargest(boolean[] isPrime){
        int largest = isPrime.length - 1;  // 从后往前遍历，第一个质数就是最大的
        for (; !isPrime[largest]; largest--);
        return largest;
    }

    public static void printPrime(int num){
        BitSet sieve = new BitSet(num);
        int size = sieve.size();
        for(int i = 2; i < size; i++)
            sieve.set(i);
        int finalBit = (int)Math.sqrt(sieve.size());
        for(int i = 2; i < finalBit; i++)
            if(sieve.get(i))
                for(int j = 2*i; j < size; j+=i)
                    sieve.clear(j);

        int counter = 0;
        for(int i = 1; i < size; i++){
            if(sieve.get(i)){
                System.out.printf("%5d",i);
                if(++counter % 15 == 0)
                    System.out.println();
            }
        }
    }

    public static void main(String[] args){
        /*BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int param = 0;
        try{
            param = Integer.parseInt(input.readLine());
        } catch (NumberFormatException e){
            System.out.println("Invalid Argument.");
        } catch (IOException e){
            e.printStackTrace();
        }
        boolean[] isPrime = sieve(param);

        for (int i = 1; i < isPrime.length; i++){
            if (isPrime[i])
                System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println(findLargest(isPrime));*/

        boolean[] isPrime = sieve(30);

        for (int i = 2; i < isPrime.length; i++){
            if (isPrime[i])
                System.out.print(i + ", ");
        }

        /*System.out.println();
        System.out.println("============================");
        printPrime(30);*/

    }

}

