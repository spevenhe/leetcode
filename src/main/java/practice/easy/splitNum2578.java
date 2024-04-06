package practice.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class splitNum2578 {

    public static void main(String[] args) {
        int input = 687;
        int res = splitNum(input);
        System.out.println(res);
    }

    public static int splitNum(int num) {
        LinkedList<Integer>list = new LinkedList<>();
        int numCopy = num;
        while(numCopy!=0){
            int tmp = numCopy%10;
            numCopy = numCopy/10;
            list.add(tmp);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int res1 = 0;
        int res2 = 0;
        while(list.size()>0){
            res1 = res1*10 + list.pollFirst();
            if(list.size()>0){
                res2 = res2*10 + list.pollFirst();
            }

        }
        return res1+res2;
    }

}
