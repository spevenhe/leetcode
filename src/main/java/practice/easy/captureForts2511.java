package practice.easy;

import java.util.Arrays;

public class captureForts2511 {
    public static void main(String[] args) {
        int[] inputs = {0,-1,-1,0,-1};
        int res = captureForts(inputs);
        System.out.println(res);

    }

    public static int captureForts(int[] forts) {
        int res = 0;
        int flag = 0;
        int tmp = 0;
        for(int i = 0;i<forts.length;i++){
            if(forts[i] != 0){
                if(flag ==0){
                    flag = forts[i];
                    tmp = 0;
                } else if(forts[i] !=flag){
                    flag = forts[i];
                    res = Math.max(res, tmp);
                    tmp = 0;
                } else if(forts[i]==flag){
                    tmp = 0;
                }
            }
            if(forts[i]==0 && flag !=0){
                tmp++;
            }
        }
        return res;
    }
}
