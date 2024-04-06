package practice.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class merge56 {
    public static void main(String[] args) {
        int[][] input = {{1,3}, {2,6},{8,10},{15,18}};
        int[][] res = merge(input);
        System.out.println(res);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        LinkedList<int[]>res = new LinkedList<>();
        int length = intervals.length;
        int[] tmprs = new int[2];
        tmprs[0] = intervals[0][0];
        tmprs[1] = intervals[0][1];
        for(int i = 1;i<length;i++){
            if(intervals[i][0] <= tmprs[1]){
                tmprs[1] = Math.max(intervals[i][1], tmprs[1]);
            }else{
                res.add(tmprs);
                tmprs = new int[2];
                tmprs[0] = intervals[i][0];
                tmprs[1] = intervals[i][1];
            }
        }
        res.add(tmprs);
        return res.toArray(new int[res.size()][2]);

    }
}
