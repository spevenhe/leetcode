package practice;

import java.util.PriorityQueue;

public class MedianFinder295 {
    public static void main(String[] args) {
        MedianFinder295 medianFinder295 = new MedianFinder295();
        medianFinder295.addNum(1);
        medianFinder295.addNum(2);
        medianFinder295.addNum(3);
        System.out.println(medianFinder295.findMedian());
        medianFinder295.addNum(4);
        medianFinder295.addNum(5);
        medianFinder295.addNum(6);
        System.out.println(medianFinder295.findMedian());

    }
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder295() {
        small = new PriorityQueue<>((a,b)->{return b-a;});
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(large.size()<small.size()){
           small.offer(num);
           large.offer(small.poll());
        }else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if(small.size()>large.size()){
            return small.peek();
        }
        else if(small.size()<large.size()){
            return large.peek();
        }
        else {
            return 0.5*(small.peek()+large.peek());
        }
    }

}
