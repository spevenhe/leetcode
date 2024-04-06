package practice.medium;

import java.util.LinkedList;
import java.util.List;

public class maximumSumOfHeights2865 {
    public static void main(String[] args) {
        List<Integer>maxh = new LinkedList<>();
        maxh.add(1000000000);
        maxh.add(1000000000);
        maxh.add(1000000000);
        System.out.println(maximumSumOfHeights(maxh));
    }

    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        long sum = 0;
        int n = maxHeights.size();
        for(int i = 0;i<n;i++){
            long leftSum = 0;
            long rightSum = 0;
            int rightMax = maxHeights.get(i);
            for(int j = i+1;j<n;j++){
                if(maxHeights.get(j)>rightMax){
                    rightSum += rightMax;
                }else{
                    rightMax = maxHeights.get(j);
                    rightSum += rightMax;
                }
            }
            int leftMax = maxHeights.get(i);
            for(int z = i-1;z>=0;z--){
                if(maxHeights.get(z)>leftMax){
                    leftSum += leftMax;
                }else{
                    leftMax = maxHeights.get(z);
                    leftSum += leftMax;
                }
            }
            long res = maxHeights.get(i)+leftSum+rightSum;
            sum = Math.max(res,sum);
    }
        return sum;
}
}
