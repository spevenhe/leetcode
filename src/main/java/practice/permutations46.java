package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permutations46 {
    public static void main(String[] args) {
        int[] input = {1,2,3};
        List<List<Integer>>res1 = permute(input);
        System.out.println(res1.toString());
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        LinkedList<Integer>tmp = new LinkedList<>();
        int[] visited = new int[nums.length];
        traverse(res,tmp,visited,nums);
        return res;
    }

    public static List<List<Integer>> traverse(List<List<Integer>>res,LinkedList<Integer>tmp
    ,int[] visited,int[] nums){
        if(tmp.size()==nums.length){

            res.add(new LinkedList<>(tmp));
        }
        for(int i =0;i< nums.length;i++){
            if(visited[i]==1){
                continue;
            }
            visited[i]=1;
            tmp.addLast(nums[i]);
            traverse(res,tmp,visited,nums);
            visited[i]=0;
            tmp.removeLast();
        }

        return res;
    }

}
