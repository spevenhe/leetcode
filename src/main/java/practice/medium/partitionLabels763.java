package practice.medium;

import practice.list.ListNode;

import java.util.LinkedList;
import java.util.List;

public class partitionLabels763 {

    public static void main(String[] args) {
        String input =  "ababcbacadefegdehijhklij";
        List<Integer> rs = partitionLabels(input);
        for(int ri : rs){
            System.out.println(ri);
        }
    }

    public static List<Integer> partitionLabels(String s) {
        char[] sc = s.toCharArray();
        LinkedList<Integer> rs = new LinkedList<>();
        int length = s.length();
        int last = 0;
        for(int i = 0;i<length;i++){
            char cur = sc[i];
            last = Math.max(last,findLastChar(cur, sc));
            if(i==last){
                    rs.add(i+1);
            }
        }
        int prev = 0;
        LinkedList<Integer> rs2 = new LinkedList<>();
        for(int ri :rs){
            rs2.add(ri - prev);
            prev=ri;
        }
        return rs2;
    }

    public static int findLastChar(char a, char[] sc) {
        int length = sc.length;
        for(int i = length-1;i>=0;i--){
            if(sc[i] == a){
                return i;
            }
        }
        return -1;
    }
}
