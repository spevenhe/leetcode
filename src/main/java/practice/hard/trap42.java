package practice.hard;

public class trap42 {
    public static void main(String[] args) {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(input);
        System.out.println(res);
    }

    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int leftM = height[0];

        int rightM = height[n-1];

        for(int i = 1; i<n-1;i++){
            leftMax[i] = leftM;
            leftM = Math.max(leftM, height[i]);
        }
        for(int i = n-1;i>0;i--){
            rightMax[i] = rightM;
            rightM = Math.max(rightM,height[i]);
        }
        int res = 0;
        for(int i = 1;i<n-1;i++){
            int minHeight = Math.min(leftMax[i],rightMax[i])-height[i];
            if(minHeight>0){
                res+= minHeight;
            }
        }
        return res;
    }

}
