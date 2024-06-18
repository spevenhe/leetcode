package practice.medium;

public class trailingZeroes172 {

    public int trailingZeroes(int n) {
        int res = 0;
        while(n >= 5){
            n = n/5;
            res+=1;
        }
        return res;
    }
}
