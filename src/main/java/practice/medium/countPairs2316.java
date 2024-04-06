package practice.medium;

import java.util.*;

public class countPairs2316 {

    public static void main(String[] args) {

    }

    public long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x); // 建图
        }
        boolean[] vis = new boolean[n];
        int total = 0;
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                int size = dfs(i ,g, vis);
                ans = ans + (size*total);
                total +=size;
            }
        }
        return ans;

    }

    public int dfs(int i, List<Integer>[] g, boolean[] vis){
        int size = 1;
        vis[i] = true;
        for(int to : g[i]){
            if(!vis[to]){
                size += dfs(to, g, vis);
            }
        }
        return size;
    }
}
