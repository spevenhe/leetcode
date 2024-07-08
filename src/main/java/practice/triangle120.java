package practice;

import java.util.List;

public class triangle120 {


    public int minimumTotal(List<List<Integer>> triangle) {
        int[] cur;
        int[] prev = new int[1];
        prev[0] = triangle.get(0).get(0);
        int n = triangle.size();
        for( int i =1;i<n;i++){
            List<Integer>tmp = triangle.get(i);
            int len = tmp.size();
            cur = new int[len];
            for(int j = 0;j<len;j++){
                int val = triangle.get(i).get(j);
                if(j==0){
                    cur[j] = prev[j]+val;
                }
                else if(j==len-1){
                    cur[j] = prev[j-1]+val;
                }
                else {
                    cur[j] = Math.min(prev[j],prev[j-1])+val;
                }
            }
            prev = cur;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i<triangle.get(n-1).size();i++){
            res = Math.min(res,prev[i]);
        }
        return res;
    }
}
