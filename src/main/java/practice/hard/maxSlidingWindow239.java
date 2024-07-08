package practice.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class maxSlidingWindow239 {

    public static void main(String[] args) {
        int[] res = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] rs = maxSlidingWindow(res,k);
        for(int ri:rs){
            System.out.println(ri);
        }
    }



    public static int[] maxSlidingWindow(int[] nums, int k) {
        SeqStack ss = new SeqStack();
        List<Integer> rs = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i <k-1){
                ss.push(nums[i]);
            }else {
                ss.push(nums[i]);
                rs.add(ss.peekMax());
                ss.remove(nums[i-k+1]);


            }
        }

        int[] res = new int[nums.length - k +1];
        for(int i = 0;i< res.length;i++){
            res[i] = rs.get(i);
        }
        return res;
    }

    public static class SeqStack {
        private LinkedList<Integer> list= new LinkedList<>();

        public void push(int num){

            while(!list.isEmpty() && list.getLast() < num){
                list.removeLast();
            }
            list.addLast(num);
        }

        public int size(){
            return list.size();
        }


        public void remove(int n){
            if (n == list.getFirst()) {
                list.pollFirst();
            }
        }

        public int peekMax(){
            return list.peekFirst();
        }
    }


    public int[] solution2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        seqList sl = new seqList();
        for(int i=0;i<nums.length;i++){
            if(i<k){
                sl.push(nums[i]);
                if(i == k-1){
                    res[index] = sl.peekMax();
                    index++;
                }
            }
            else{
                sl.push(nums[i]);
                if(sl.peekMax() == nums[i-k]){
                    sl.removeFirst();
                }
                res[index] = sl.peekMax();
                index++;

            }
        }
        return res;
    }

    public class seqList{
        private LinkedList<Integer> list = new LinkedList<>();

        public void push(int num){
            while (!list.isEmpty() && list.getLast() < num){
                list.removeLast();
            }
            list.addLast(num);
        }

        public int peekMax(){
            return list.peekFirst();
        }

        public void removeFirst(){
            list.removeFirst();
        }
    }


}


