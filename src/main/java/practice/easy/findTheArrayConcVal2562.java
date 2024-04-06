package practice.easy;

public class findTheArrayConcVal2562 {
    public static void main(String[] args) {

    }

    public static long findTheArrayConcVal(int[] nums) {
        int end = nums.length-1;
        int start = 0;
        long res = 0;
        while(end>start){
            int i = nums[start];
            int j = nums[end];
            res+= link(i,j);
            end--;
            start++;
        }
        if(end == start){
            res+= nums[start];
        }
        return res;
    }

    public static long link(int i, int j){
        if(j/10 ==0){
            return i*10+j;
        }else if(j/100 == 0){
            return i*100+j;
        }else if(j/1000 ==0){
            return i*1000+j;
        }else if(j/10000 ==0){
            return i*10000+j;
        }else{
            return i*100000+j;
        }
    }
}
