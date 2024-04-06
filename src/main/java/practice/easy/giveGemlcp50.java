package practice.easy;

public class giveGemlcp50 {

    public static void main(String[] args) {

    }

    public static int giveGem(int[] gem, int[][] operations) {
        for(int[] operation : operations){
            int from = operation[0];
            int to = operation[1];
            int give = gem[from]/2;
            gem[from] = gem[from]-give;
            gem[to] += give;
        }
        System.out.println();
        int min = 1000;
        int max = 0;
        for(int g :gem){
            min = Math.min(g,min);
            max = Math.max(g,max);
        }
        return max - min;
    }
}
