package practice;

import java.util.HashMap;
import java.util.PriorityQueue;

public class topKFrequent {
    public int[] topKFrequent1(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer>count = new HashMap<>();
        for(int i = 0;i<n;i++){
            count.put(i,count.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer>topk = new PriorityQueue<>((a,b)->{
            return count.get(b)-count.get(a);
        }
        );
        for(int key : count.keySet()){
            if(topk.size()<=k){
                topk.add(key);
            }
            else {
                if(topk.peek()<count.get(key)){
                    topk.poll();
                    topk.add(key);
                }
            }
        }
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = topk.poll();
        }
        return res;

    }
}
