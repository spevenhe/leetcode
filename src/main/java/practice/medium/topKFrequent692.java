package practice.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class topKFrequent692 {

    public static void main(String[] args) {
        String[] inputs = {"i","love","leetcode","i","love","coding"};
        List<String>rs = topKFrequent(inputs,2);
        for(String ri : rs){
            System.out.println(ri);
        }

    }

    public static class WordFreq {
        public String str;
        public int freq;

        public WordFreq(String str, int freq){
            this.str = str;
            this.freq = freq;
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        PriorityQueue<WordFreq>pq = new PriorityQueue<WordFreq>((a,b)->{
            if(a.freq==b.freq){
                return b.str.compareTo(a.str);
            }else{
                return a.freq - b.freq;
            }
        });
        for(String key : map.keySet()){
            int value = map.get(key);
            WordFreq wf = new WordFreq(key, value);
            pq.add(wf);
            if(pq.size() > k){
                pq.poll();
            }

        }
        LinkedList<String> res = new LinkedList<>();
        while (!pq.isEmpty()){
            res.addFirst(pq.poll().str);
        }
        return res;

    }
}
