package practice.medium;

import java.util.Arrays;

public class minimumRemoval2171 {

    public static void main(String[] args) {

    }

    public static long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long sum = 0;
        for(int bean :beans){
            sum+=bean;
        }
        long res = sum;
        for(int i = 0;i<n;i++){
            long tmp = 1L*(n-i)*beans[i];
            if(tmp < sum){
                res = Math.min(sum-tmp, res);
            }

        }
        return res;
    }
}
