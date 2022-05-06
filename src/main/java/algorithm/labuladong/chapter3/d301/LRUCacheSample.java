package algorithm.labuladong.chapter3.d301;

import java.util.HashMap;

public class LRUCacheSample {
    private HashMap<Integer, Node> map;

    private DeLinkList cache;

    private int cap;

    public LRUCacheSample(int capacity) {
        this.cap = capacity;
        this.cache = new DeLinkList();
        map = new HashMap<>();
    }

    private void makeRecently(int key) {
        Node x = map.get(key);
        // 先从链表中删除这个节点
        cache.remove(x);
        // 重新插到队尾
        cache.addLast(x);
    }

    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        // 链表尾部就是最近使用的元素
        cache.addLast(x);
        // 别忘了在map中添加key的映射
        map.put(key, x);
    }

    private void delelteKey(int key) {
        Node x = map.get(key);
        // 从链表中删除
        cache.remove(x);
        // 从map中删除
        map.remove(key);
    }

    // 删除最久未使用的元素
    private void removeLeastRecently() {
        // 链表状况的第一个元素就是最久未使用的
        Node deleteNode = cache.removeFirst();
        // 同时别忘了从map中删除它的key
        int deleteKey = deleteNode.key;
        map.remove(deleteKey);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 将该数据提升为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            // 删除旧的数据
            delelteKey(key);
            // 新插入的数据为最近使用的数据
            addRecently(key, val);
            return;
        }

        if (cap == cache.size()) {
            // 删除最久未使用的元素
            removeLeastRecently();
        }
        // 添加为最近使用的元素
        addRecently(key, val);
    }
}
