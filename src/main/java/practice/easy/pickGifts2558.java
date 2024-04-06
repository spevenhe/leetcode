package practice.easy;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class pickGifts2558 {

    public static void main(String[] args) {

    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->{
            return b-a;
        });
        for(int gift : gifts){
            q.add(gift);
        }
        for(int i = 0;i<k;i++){
            int max = q.poll();
            int sqrt = (int) Math.floor(Math.sqrt(max));
            q.add(sqrt);
        }
        int res = 0;
        for( int num : q){
            res+=num;
        }
        return res;

    }
}
