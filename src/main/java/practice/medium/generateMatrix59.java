package practice.medium;

import java.util.Locale;

public class generateMatrix59 {

    public static void main(String[] args) {
        int n = 10;
        int[][]rs = generateMatrix(10);
        System.out.println("a");
    }

    public static int[][] generateMatrix(int n) {
        int up = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        int[][] rs = new int[n][n];
        int step = 1;
        while(step <= n*n){
            for(int i = left;i<=right;i++){
                rs[up][i] = step;
                step++;
            }
            for(int i = up+1;i<=down;i++){
                rs[i][right] = step;
                step++;
            }
            for(int i = right-1;i>=left;i--){
                rs[down][i] = step;
                step++;
            }
            for(int i = down-1;i>up;i--){
                rs[i][left] = step;
                step++;
            }
            up++;
            left++;
            down--;
            right--;
        }
        return rs;

    }


}
