package practice.medium;

public class singleNumber137 {

    public static void main(String[] args) {
        int[] input = {0,1,0,1,0,1,99};
        int res = singleNumber(input);
        System.out.println(res);
    }

    public static int singleNumber(int[] nums) {
        int[] tmp = new int[32];
        for(int num : nums){
            for(int i = 0;i<32;i++){
                int one = (num>>i)&1;
                tmp[i]+=one;
            }

        }
        int res = 0;
        for(int i = 0;i<32;i++){
            if((tmp[i]%3 & 1)== 1){
                res += (1<<i);
            }
        }
        return res;
    }
}
