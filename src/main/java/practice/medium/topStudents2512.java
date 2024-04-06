package practice.medium;

import java.util.*;

public class topStudents2512 {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> pset = new HashSet<>();
        for(String pf : positive_feedback){
            pset.add(pf);
        }
        HashSet<String> nset = new HashSet<>();
        for(String nf : negative_feedback){
            nset.add(nf);
        }
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return b[1] - a[1];
        });
        int length = student_id.length;
        int[] record = new int[length];
        for(int i = 0;i<length;i++){
            String[] words = report[i].split(" ");
            for(String word :words){
                if(pset.contains(word)){
                    record[i]+=3;
                    continue;
                }if(nset.contains(word)){
                    record[i]-=1;
                    continue;
                }
            }
            p.offer(new int[]{student_id[i],record[i]});
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
            System.out.println(p.peek());
            ans.add(p.poll()[0]);
        }

        return ans;

    }
}
