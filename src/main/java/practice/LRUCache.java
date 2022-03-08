package practice;

import java.util.HashMap;

public class LRUCache {

    private DoubleList keyList;

    private HashMap<Integer,Node>map;

    private int size;

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }

    public LRUCache(int capacity) {
        keyList = new DoubleList();
        map = new HashMap<>(capacity);
        size = capacity;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node rs = map.get(key);
            keyList.remove(rs);
            keyList.addFirst(rs);
            return rs.val;
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node tmp = new Node(key,value);
        if(map.containsKey(key)){
            keyList.remove(map.get(key));
        }else {
            if(map.size() == size){
                Node last = keyList.removeLast();
                map.remove(last.key);
            }
        }
        keyList.addFirst(tmp);
        map.put(key,tmp);

    }
    class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {

        private Node head = new Node(0,0);
        private Node tail = new Node(0,0);;
        public DoubleList(){
            head.next = tail;
            tail.prev = head;
        }

        // 在链表头部添加节点 x，时间 O(1)
        public void addFirst(Node x){
            Node tmp = head.next;
            head.next = x;
            x.prev = head;
            x.next = tmp;
            tmp.prev = x;
        }

        // 删除链表中的 x 节点（x 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node x) {
            Node prev = x.prev;
            Node next = x.next;
            prev.next = next;
            next.prev = prev;
        }

        // 删除链表中最后一个节点，并返回该节点，时间 O(1)
        public Node removeLast() {
            Node tmp = tail.prev;
            tmp.prev.next = tail;
            tail.prev =  tmp.prev;
            return tmp;

        }

    }


}
