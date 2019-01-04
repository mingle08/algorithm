package jdk.BinarySearchOfCollections;

import java.util.*;

public class BinarySearchOfCollections {
    private static final int BINARYSEARCH_THRESHOLD   = 5000;

    // 三个参数
    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        if (c==null)
            return binarySearch((List<? extends Comparable<? super T>>) list, key);

        if (list instanceof RandomAccess || list.size()<BINARYSEARCH_THRESHOLD)
            return indexedBinarySearch(list, key, c);
        else
            return iteratorBinarySearch(list, key, c);
    }

    // 二个参数
    public static <T>
    int binarySearch(List<? extends Comparable<? super T>> list, T key) {
        if (list instanceof RandomAccess || list.size()<BINARYSEARCH_THRESHOLD)
            return indexedBinarySearch(list, key);
        else
            return iteratorBinarySearch(list, key);
    }

    // 二个参数
    private static <T>
    int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size()-1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }

    // 二个参数
    private static <T>
    int iteratorBinarySearch(List<? extends Comparable<? super T>> list, T key)
    {
        int low = 0;
        int high = list.size()-1;
        ListIterator<? extends Comparable<? super T>> i = list.listIterator();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = get(i, mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }

    // 三个参数
    private static <T>
    int indexedBinarySearch(List<? extends T> l, T key, Comparator<? super T> c) {
        int low = 0;
        int high = l.size()-1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = l.get(mid);
            int cmp = c.compare(midVal, key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }

    // 三个参数
    private static <T>
    int iteratorBinarySearch(List<? extends T> l, T key, Comparator<? super T> c) {
        int low = 0;
        int high = l.size()-1;
        ListIterator<? extends T> i = l.listIterator();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = get(i, mid);
            int cmp = c.compare(midVal, key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }

    private static <T> T get(ListIterator<? extends T> i, int index) {
        T obj = null;
        int pos = i.nextIndex();
        if (pos <= index) {
            do {
                obj = i.next();
            } while (pos++ < index);
        } else {
            do {
                obj = i.previous();
            } while (--pos > index);
        }
        return obj;
    }

    public static void main(String[] args){
        int num = 1200000;
        List<String> cities = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cities.add(i + "");
        }
        /**
         * 此main方法所用的实例摘自以下这篇博客：
         * https://www.cnblogs.com/DreamDrive/p/5660155.html
         * 博主用二分查找得到的索引是负数，原因是在查找前，没有排序：Collections.sort(cities);
         * 排序之后是这样的：
         * 0, 1, 10, 100, 1000, 10000, 100000, 1000000, 1000001, 1000002,
         * 1000003, 1000004, 1000005, 1000006, 1000007, 1000008, 1000009, 100001, 1000010, 1000011,
         * 1000012, 1000013, 1000014, 1000015, 1000016, 1000017, 1000018, 1000019, 100002, 1000020,
         * 1000021, 1000022, 1000023, 1000024, 1000025, 1000026, 1000027, 1000028, 1000029, 100003,
         * 1000030, 1000031, 1000032, 1000033, 1000034, 1000035, 1000036, 1000037, 1000038, 1000039,
         * 10033033  ......
         */
        Collections.sort(cities);
        // 打印前50个数，每10个数换行
        for (int i = 0; i < 50; i++) {
            if(i%10 == 0)
                System.out.println();

            System.out.print(cities.get(i) + ", ");
        }
        long startTime = System.nanoTime();
        int index1 = cities.indexOf((num - 5) + "");
        long endTime1 = System.nanoTime();
        System.out.println();
        System.out.println(endTime1 - startTime);
        int index2 = BinarySearchOfCollections.binarySearch(cities, (num - 5) + "");
        long endTime2 = System.nanoTime();
        System.out.println(endTime2 - endTime1);
        System.out.println("indexOf=" + index1);   // indexOf=222219
        System.out.println("binarySearch=" + index2);   // binarySearch=222219
        
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int mid1 = (left + right) >> 1;
        int mid2 = left + ((right - left) >> 1);
        int mid3 = (left + right) >>> 1;
        System.out.println("mid1=" + mid1 + ", mid2=" + mid2 + ", mid3=" + mid3); // mid1=-1, mid2=2147483647, mid3=2147483647
    }
}
