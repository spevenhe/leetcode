package practice.list;

import java.util.LinkedHashMap;

public class LRUCache {

    private LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        int value =  -1;
        if(map.containsKey(key)){
            value = map.get(key);
            map.remove(key);
            map.put(key,value);
        }
        return value;

    }

    public void put(int key, int value) {
        if(map.size() >= cap ){
            int oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }
        if(map.containsKey(key)){
            map.remove(key);
        }
        map.put(key,value);
    }
}
