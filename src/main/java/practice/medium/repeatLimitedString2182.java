package practice.medium;

import java.util.Collections;
import java.util.LinkedList;

public class repeatLimitedString2182 {
    public static void main(String[] args) {
        String input = "aababab";
        int repeatLimit = 2;
        System.out.println(repeatLimitedString(input,repeatLimit));
        System.out.println(repeatLimitedString("xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt",1));
        System.out.println(repeatLimitedString("robnsdvpuxbapuqgopqvxdrchivlifeepy",2));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] sChars = new int[26];
        for (byte b : s.getBytes()) {
            sChars[b - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            int k = i - 1;
            while (true) {
                for (int j = 0; j < repeatLimit && sChars[i] > 0; j++) {
                    sChars[i]--;
                    builder.append((char) (i + 'a'));
                }
                if (sChars[i] == 0) {
                    break;
                }
                while (k >= 0 && sChars[k] == 0) {
                    k--;
                }
                if (k < 0) {
                    break;
                }
                sChars[k]--;
                builder.append((char) (k + 'a'));
            }
        }
        return builder.toString();
    }
}
