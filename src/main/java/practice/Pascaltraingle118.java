package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Pascaltraingle118 {
    public static void main(String[] args) {
        int numRows = 5;
        Integer[] prev;
        Integer[] now;
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        prev = new Integer[1];
        prev[0] = 1;
        res.add(Arrays.asList(prev));
        for(int i = 2;i<=numRows;i++){
            now = new Integer[i];
            for(int j = 0;j<i;j++){
                if(j==0){
                    now[j] = prev[j];
                }
                else if(j==i-1){
                    now[j] = prev[j-1];
                }else {
                    now[j] = prev[j-1]+prev[j];
                }
            }

            prev = now;
            res.add(Arrays.asList(prev));
        }
        for(List<Integer> i :res){
            for(Integer j : i){
                System.out.print(j);
            }
            System.out.println("");
        }
    }
}
