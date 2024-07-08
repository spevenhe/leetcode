package practice.medium.backtrack;

import java.util.LinkedList;
import java.util.List;

public class permute46 {

    List<List<Integer>> res = new LinkedList<>();
    int n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        boolean[] visited = new boolean[n];
        traverse(nums,visited,new LinkedList<>());
        return res;
    }

    public void traverse(int[] nums, boolean[]visited, LinkedList<Integer> list){
        if(list.size() == n){
            res.add(new LinkedList<>(list));
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            traverse(nums,visited,list);
            visited[i] = false;
            list.removeLast();
        }
    }
}
