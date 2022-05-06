package algorithm.sort;

import algorithm.sort.heapSort.Node;

public class Heap {
    private Node[] heapArray;
    private int arraySize;
    private int currentSize;
    public Heap(int max) {
        this.arraySize = max;
        this.heapArray = new Node[arraySize];
        this.currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if(currentSize == arraySize) {
            return false;
        }
        Node newNode = new Node(key);
        // 新节点放到数组的最后位置
        heapArray[currentSize] = newNode;
        // 如果不是最小的数，就要向上调整位置
        trickleUp(currentSize);
        currentSize++;
        return true;
    }

    public void trickleUp(int index) {
        // 找父节点的索引值
        int parent = (index-1)/2;
        Node bottom = heapArray[index];
        while(index > 0 && heapArray[parent].getNum() < bottom.getNum()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent-1)/2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {// 删除根节点
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0); // 将新的根，向下调整
        return root;
    }

    public void trickleDown(int index) {
        int largerChild;  // 大的子节点位置
        Node top = heapArray[index];  // 要向下调整的节点对象
        while(index < currentSize/2) {// 未找到最后一层
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if(rightChild < currentSize &&
                    heapArray[leftChild].getNum() < heapArray[rightChild].getNum()) {
                largerChild = rightChild;
            }else {
                largerChild = leftChild;
            }

            if(top.getNum() >= heapArray[largerChild].getNum()) {// 找到位置，不用再调换
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public boolean change(int index, int newVal) {
        if(index < 0 || index >= currentSize) { // 无效位置
            return false;
        }
        int oldVal = heapArray[index].getNum();
        heapArray[index].setNum(newVal);
        if(oldVal < newVal) {
            trickleUp(index);
        }else {
            trickleDown(index);
        }
        return true;
    }

    public void displayHeap() {
        System.out.print("HeapArray: ");
        for (int i = 0; i < currentSize; i++) {
            if(heapArray[i] != null) {
                System.out.print(heapArray[i].getNum() + " ");
            }else {
                System.out.print("-- ");
            }
        }
        System.out.println();

        // 以树状方式显示
        int nBlanks = 32;
        int itemsPerRow = 1;  // 每一层有几个节点
        int column = 0;
        int j = 0;
        String dots = ".......................";
        System.out.println(dots + dots);
        while(currentSize > 0) {
            if(column == 0) {
                for(int k=0; k < nBlanks; k++) {
                    System.out.print(" ");
                }
            }
            System.out.print(heapArray[j].getNum());
            if(++j == currentSize) {
                break;
            }
            if(++column == itemsPerRow) {// 这层已打印完
                nBlanks /= 2;  // 空格，从上往下，依次减半
                itemsPerRow *= 2;   // 每一层的节点数是上一层节点数的2倍
                column = 0;
                System.out.println();
            }else {
                for (int i = 0; i < nBlanks * 2 - 2; i++) {
                    System.out.print(" ");
                }
            }
        }

        System.out.println("\n" + dots + dots);
    }
}
