package practice.medium;

import java.util.*;

public class avoidFlood1488 {

    public static void main(String[] args) {
        int[] input = {1,2,0,0,2,1};
        int[] res = avoidFlood(input);
        for(int i:res){
            System.out.println(i);
        }
    }

    public static int[] avoidFlood(int[] rains) {
        TreeSet<Integer>sunny = new TreeSet<>();
        Map<Integer, Integer>rainMap = new HashMap<>();
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for(int i  = 0;i< n;i++){
            if(rains[i] == 0){
                sunny.add(i);
                continue;
            }else{
                ans[i] = -1;
                if(rainMap.containsKey(rains[i])){
                    Integer nearestSunny = sunny.ceiling(rainMap.get(rains[i]));
                    if(nearestSunny ==null){
                        return new int[0];
                    }
                    ans[nearestSunny] = rains[i];
                    sunny.remove(nearestSunny);
                    rainMap.remove(rains[i]);
                }

                rainMap.put(rains[i],i);
            }
        }
        return ans;
    }
}
