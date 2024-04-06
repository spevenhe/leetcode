package practice.easy;

import java.util.PriorityQueue;

public class maxKelements2530 {

    public static void main(String[] args) {

    }

    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer>pq = new PriorityQueue<>(n, (a,b) -> {
            return b- a;
        });
        for(int num : nums){
            pq.add(num);
        }
        long res = 0;
        for(int i = 0;i<k;i++){
            int tmp = pq.poll();
            res+= tmp;
            pq.offer((tmp+2)/3);
        }
        return res;
    }
}
