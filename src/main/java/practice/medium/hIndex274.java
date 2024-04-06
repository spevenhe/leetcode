package practice.medium;

public class hIndex274 {

    public static void main(String[] args) {
        int[] inputs = {0,1};
        int res = hIndex(inputs);
        System.out.println(res);
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int min = 0;
        int max = n;
        int res = 0;
        while(min < max){
            int tmp = min+ (max - min +1)/2;
            if(check(citations,tmp)){
                min = tmp;
                res = Math.max(res,tmp);
            }else{
                max = tmp-1;
            }
        }
        return res;
    }

    public static boolean check(int[] citations, int target){
        int res = 0;
        for(int cita : citations){
            if(cita >= target){
                res+=1;
            }
        }
        return res>=target;
    }
}
