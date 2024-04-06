package practice.easy;

public class findTheLongestBalancedSubstring2609 {

    public static void main(String[] args) {

    }

    public int findTheLongestBalancedSubstring(String s) {
        char[] sc = s.toCharArray();
        int length = sc.length;
        int res = 0;
        int j = 0;
        while(j<length){
            if(sc[j]=='0'){
                int i = j;
                int tmp = 0;
                while(i<length && sc[i]=='0'){
                    i++;
                    tmp++;
                }
                int tmp2 = 0;
                while (i<length && sc[i]=='1'){
                    i++;
                    tmp2++;
                }
                if(tmp2 >= tmp){
                    res = Math.max(res, 2*tmp);
                }
            }
            j++;

        }
        return res;
    }

}
