package practice.medium;

public class maxArea11 {
    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(input);
        System.out.println(res);
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right  = height.length-1;
        int res = 0;
        while(left< right){
            int lh = height[left];
            int rh = height[right];
            int tmp = Math.min(lh,rh)*(right - left);
            res = Math.max(tmp, res);
            if(lh<rh){
                left++;
            }
            else{
                right--;
            }
        }
        return res;
    }


}
