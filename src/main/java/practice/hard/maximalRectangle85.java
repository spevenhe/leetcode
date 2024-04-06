package practice.hard;

import java.util.Stack;

public class maximalRectangle85 {

    public static void main(String[] args) {
        int[] inputs = {1,0,1,0,0};
        int rs = maxArea(inputs);
    }

    public static int maximalRectangle(char[][] matrix) {
        int[] cols = new int[matrix[0].length];
        int rs = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    cols[j] += 1;
                }else{
                    cols[j] = 0;
                }

            }
            rs = Math.max(rs, maxArea(cols));
            System.out.println(rs);
        }
        return rs;


    }

    public static int maxArea(int[] cols){
        Stack<Integer> singleOrder = new Stack<>();
        int[] cols2 = new int[cols.length+2];
        for(int i = 0;i<cols.length;i++){
            cols2[i+1] = cols[i];
        }
        int res = 0;
        for(int i = 0;i<cols2.length;i++){
            while(!singleOrder.isEmpty() && cols2[i]< cols2[singleOrder.peek()]){
                int cur = singleOrder.pop();
                int right = i-1;
                int left = singleOrder.peek()+1;
                int areaSize = (right - left +1)*cols2[cur];
                res = Math.max(areaSize,res);

            }

            singleOrder.push(i);

        }
        return res;
    }

}
