package practice;

public class countBits338 {
    public static void main(String[] args) {
        int n = 5;
        int[] res = new int[n+1];
        int one = 1;
        for(int i = 0;i<=n;i++){
            int tmp = i;
            int tmpRes = 0;
            while(tmp!=0){
                int flag = tmp&one;
                if(flag==1){
                    tmpRes+=1;
                }
                tmp = tmp>>1;

            }
            res[i] = tmpRes;
        }
    }
}
