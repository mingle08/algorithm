package algorithm.ProgrammingPearls;

public class SortByBitMap {

    private String bitmap;

    public SortByBitMap() {
        this.bitmap = "00000000000000000000"; // 初始化为全0的字符串
    }

    public void insert(int num) {
        if (num >= 0 && num < 20) {
            StringBuilder sb = new StringBuilder(bitmap);
            sb.setCharAt(num, '1'); // 将对应位置设置为1
            bitmap = sb.toString();
        } else {
            throw new IllegalArgumentException("Number out of range");
        }
    }

    public void remove(int num) {
        if (num >= 0 && num < 20) {
            StringBuilder sb = new StringBuilder(bitmap);
            sb.setCharAt(num, '0'); // 将对应位置设置为0
            bitmap = sb.toString();
        } else {
            throw new IllegalArgumentException("Number out of range");
        }
    }

    public boolean contains(int num) {
        if (num >= 0 && num < 20) {
            return bitmap.charAt(num) == '1'; // 检查对应位置是否为1
        } else {
            throw new IllegalArgumentException("Number out of range");
        }
    }

    public void printIndex() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitmap.length(); i++) {
            if (bitmap.charAt(i) == '1') {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        SortByBitMap bitMap = new SortByBitMap();
        bitMap.insert(2);
        bitMap.insert(5);
        bitMap.insert(10);
        bitMap.printIndex(); // 输出: 2 5 10

        bitMap.remove(5);
        bitMap.printIndex(); // 输出: 2 10

        System.out.println(bitMap.contains(2)); // 输出: true
        System.out.println(bitMap.contains(5)); // 输出: false
    }
}
