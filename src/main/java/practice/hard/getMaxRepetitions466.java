package practice.hard;

public class getMaxRepetitions466 {
    public static void main(String[] args) {
        int res = getMaxRepetitions("abaacdbac", 1000000, "adcbd", 10);
        System.out.println(res);

    }

    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        StringBuilder S1 = new StringBuilder();
        for(int i = 0;i<n1;i++){
            S1.append(s1);
        }
        String str1 = S1.toString();
        StringBuilder S2 = new StringBuilder();
        for(int i = 0;i<n2;i++){
            S2.append(s2);
        }
        String str2 = S2.toString();
        int length = str1.length();
        int index = 0;
        int ans = 0;
        for (int i = 0; i < length; ++i) {
                char ch = str1.charAt(i);
                if (ch == str2.charAt(index)) {
                    ++index;
                    if (index == str2.length()) {
                        ++ans;
                        index = 0;
                    }
                }
        }
        return ans;
    }
}
