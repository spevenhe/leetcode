package practice.easy;

public class strStr28 {
    public static void main(String[] args) {
        String s1 = "sadbutsad";
        String s2 = "sad";
        int res = strStr(s1,s2);
        System.out.println(res);
    }

    public static int strStr(String haystack, String needle) {
        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();
        int nl = nc.length;
        for(int i = 0;i<hc.length;i++){
            int tmp = i;
            int j = 0;
            while(tmp<hc.length && hc[tmp]==nc[j]){
                if(j==nl-1){
                    return i;
                }
                tmp++;
                j++;

            }
        }
        return -1;
    }
}
