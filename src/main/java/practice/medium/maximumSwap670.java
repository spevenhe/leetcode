package practice.medium;

public class maximumSwap670 {

    public static void main(String[] args) {
        int input = 99572736;
        System.out.println(maximumSwap(input));
    }

    public static int maximumSwap(int num) {
        char[] numc = String.valueOf(num).toCharArray();

        int n = numc.length;
        int maxIndex = n-1;
        int swapIndex = -1;
        int swapIndex2 = -1;
        for(int i = n-1;i>=0;i--){
            if(numc[i]>numc[maxIndex]){
                maxIndex = i;
            }
            if(numc[i]<numc[maxIndex]){
                swapIndex = i;
                swapIndex2 = maxIndex;
            }
        }
        if(swapIndex!=-1){
            char tmp = numc[swapIndex];
            numc[swapIndex] = numc[swapIndex2];
            numc[swapIndex2] = tmp;
        }
        return Integer.valueOf(new String(numc));
    }
}
