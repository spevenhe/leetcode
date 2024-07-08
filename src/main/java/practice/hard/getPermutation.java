package practice.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class getPermutation {

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        String rs = getPermutation(n,k);
        System.out.println(rs);
    }


    public static String getPermutation(int n, int k) {
        int[] fab = new int[10];
        fab[0] = 1;
        fab[1] = 1;
        for(int i = 2;i <= 9;i++){
            fab[i] = fab[i-1]*i;
        }

        LinkedList<Character> numList = new LinkedList<>();
        for(int i = 1;i <= n;i++){
            numList.add((char)('0'+i));
        }
        k--;
        StringBuffer sb = new StringBuffer();
        while(n>0){
            int index = k/fab[n-1];
            sb.append(numList.get(index));
            numList.remove(index);
            k = k %fab[n-1];
            n = n-1;
        }
        return sb.toString();

    }
}
