package practice.medium;

public class addMinimum2645 {

    public int addMinimum(String word) {
        int n = word.length();
        char[] wc = word.toCharArray();
        int cnt = 0;
        if(n==1){
            cnt = 1;
        }
        for(int i =0;i<n-1;i++){
            if(wc[i]>=wc[i+1]){
                cnt+=1;
            }
        }
        return 3*cnt - n;
    }
}
