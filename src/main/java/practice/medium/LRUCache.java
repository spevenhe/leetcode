package practice.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Node dummy;
    private int capacity;
    private Map<Integer, Node>map = new HashMap<>();

    public static void main(String[] args) {

    }


    public class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int i, int j){
            key = i;
            value = j;
        }
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy = new Node(0,0);
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public  int get(int key) {
        if(map.containsKey(key)){
            moveKeyToFront(key);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            moveKeyToFront(key);
            map.get(key).value = value;
        }else{
            Node node = new Node(key,value);
            map.put(key,node);

            node.next = dummy.next;
            node.prev = dummy;
            dummy.next.prev = node;
            dummy.next = node;
        }
        if(map.size()>capacity){
            Node last = dummy.prev;
            map.remove(last.key);
            last.prev.next = last.next;
            last.next.prev = last.prev;
        }



    }

    public void moveKeyToFront(int key){
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = dummy.next;
        node.prev = dummy;
        dummy.next.prev = node;
        dummy.next = node;
    }




}
