package practice.medium;

import java.util.HashMap;

public class numberOfBoomerangs447 {
    public static void main(String[] args) {

    }

    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int n = points.length;
        int ans = 0;
        for(int i = 0;i<n;i++){

            int x0 = points[i][0];
            int y0 = points[i][1];
            for(int j = 0;j<n;j++){
                if(i==j){
                    continue;
                }
                int x1 = points[j][0];
                int y1 = points[j][1];
                int distance = (x1 - x0)*(x1 - x0) + (y1 - y0)*(y1 - y0);
                map.put(distance,map.getOrDefault(distance,0)+1);
            }
            for(int key: map.keySet()){
                int val = map.get(key);
                if(val >=2){
                    ans+=val*(val-1);
                }
            }
            map.clear();

        }


        return ans;
    }
}
