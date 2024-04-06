package practice.medium;

import java.util.LinkedList;
import java.util.List;

public class beautifulIndices100165 {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        LinkedList<Integer> listA = new LinkedList<>();
        LinkedList<Integer> listB = new LinkedList<>();

        int index = s.indexOf(a);
        while (index != -1) {
            listA.add(index);
            index = s.indexOf(a, index + 1);
        }

        int index2 = s.indexOf(b);
        while (index2 != -1) {
            listB.add(index2);
            index2 = s.indexOf(b, index2 + 1);
        }
        List<Integer>rs = new LinkedList<>();
        for(int indexA: listA){
            for(int indexB: listB){
                if(Math.abs(indexA - indexB)<=k){
                    rs.add(indexA);
                    break;
                }
            }
        }
        return rs;



    }



}
