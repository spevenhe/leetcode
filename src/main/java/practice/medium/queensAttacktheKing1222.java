package practice.medium;

import java.util.LinkedList;
import java.util.List;

public class queensAttacktheKing1222 {

    public static void main(String[] args) {
        int[] king = {3,4};
        int[][] input = {{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};
        List<List<Integer>> res = queensAttacktheKing(input,king);
        System.out.println("s");

    }

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] dirs = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
        int[][] map = new int[8][8];
        for(int[] queen : queens){
            map[queen[0]][queen[1]] = 1;
        }
        List<List<Integer>>res = new LinkedList<>();
        for(int[] dir:dirs){

            int i = king[0] ;
            int j = king[1];
            while(i>=0 && i<8 && j>=0 && j<8){

                if(map[i][j]==1){
                    List<Integer>tmp = new LinkedList<>();
                    tmp.add(i);
                    tmp.add(j);
                    res.add(tmp);
                    break;
                }
                i = i+dir[0];
                j = j+dir[1];
            }
        }
        return res;
    }

}
