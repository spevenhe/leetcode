package practice.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class totalNQueens52 {
    public static void main(String[] args) {
        int res = totalNQueens(6);
        System.out.println(res);
    }

    private static int res = 0;
    private static int n;

    public static int totalNQueens(int n1) {
        n = n1;
        List<char[]> map = new ArrayList<>(n);
        for(int i = 0;i<n;i++){
            char[] line = new char[n];
            Arrays.fill(line,'.');
            map.add(line);
        }

        dfs(map,0);
        return res;


    }

    public static void dfs(List<char[]> map, int rowNumber){
        if(rowNumber> n){
            return;
        }
        if(rowNumber == n){
            res+=1;
            return;
        }

        char[] curRow = map.get(rowNumber);

        for(int i = 0;i<n;i++){
            curRow[i] = 'Q';
            if(validRow(rowNumber, i, map)){
                dfs(map,rowNumber+1);
            }
            curRow[i] = '.';
        }
    }

    public static boolean validRow(int row, int column, List<char[]> map){
        // check column
        for(int i = 0;i<row;i++){
            if(map.get(i)[column] == 'Q'){
                return false;
            }
        }

        // left up
        for(int i = row-1, j = column -1; i>=0 && j>=0;i--,j--){
            if(map.get(i)[j] == 'Q'){
                return false;
            }
        }

        // right up
        for(int i = row-1, j = column + 1; i>=0 && j<n;i--,j++){
            if(map.get(i)[j] == 'Q'){
                return false;
            }
        }
        return true;


    }
}
