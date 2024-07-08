package practice.medium.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class generate118 {

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res = generate(numRows);
        for(List<Integer> row : res){
            for(int i : row){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>>res = new ArrayList<>(numRows);
        List<Integer> firstRow = new LinkedList<>();
        firstRow.add(1);
        res.add(firstRow);
        for(int i = 1;i<numRows;i++){
            List<Integer> row = new LinkedList<>();
            List<Integer> prevRow = res.get(i-1);
            row.add(1);
            for(int j = 1;j<i;j++){
                row.add(prevRow.get(j-1)+prevRow.get(j));
            }
            row.add(1);
            res.add(row);


        }
        return res;
    }
}
