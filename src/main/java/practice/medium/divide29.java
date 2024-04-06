package practice.medium;

public class divide29 {
    public static void main(String[] args) {
        int dividend =-2147483648;
        int divisor = -1;
        System.out.println(dividend/divisor);
        int res = divide(dividend,divisor);
        System.out.println(res);
    }

    public static int divide(int dividend, int divisor) {
        boolean isNeg = false;
        if((dividend <0 && divisor >0) || (dividend >0 && divisor <0)){
            isNeg = true;
        }
        long r = dividend<0L?-(long)dividend:dividend;
        long target = r;
        long d = divisor<0L?-(long)divisor:divisor;
        long l = 0;
        while(l < r){
            long mid = (l+r)>>1;
            if(multiply(mid, d) >target){
                r = mid;
            }else {
                l = mid+1;
            }

        }
        long res = multiply(l, d) >target?l-1:l;
        res = isNeg?-res:res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)res;

    }

    public static long multiply(long a, long b){
        long res = 0;
        while(b>0){
            if((b&1) == 1){
                res = res+a;
            }
            a +=a;
            b = b>>1;
        }
        return res;
    }
}
