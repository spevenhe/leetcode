package practice.graph;

import java.util.*;

public class findOrder210 {
    public Map<Integer, List<Integer>> map  = new HashMap<>();
    public boolean hasCycle = false;
    public LinkedList<Integer> postorder = new LinkedList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int[] pre: prerequisites){
            int from  = pre[0];
            int to = pre[1];
            if(map.containsKey(from)){
                map.get(from).add(to);
            }else{
                List<Integer> list = new LinkedList<>();
                list.add(to);
                map.put(from,list);
            }
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        for(int i = 0;i<numCourses;i++){
            dfs(visited,onPath,i);
        }
        if(hasCycle){
            return new int[0];
        }
        int[] rs = new int[postorder.size()];
        int i = 0;
        while(!postorder.isEmpty()){
            rs[i] = postorder.removeFirst();
            i++;
        }
        return rs;


    }

    public void dfs(boolean[] visited, boolean[] onPath, int index){
        if(onPath[index] ){
            hasCycle = true;
        }
        if(visited[index] || hasCycle){
            return;
        }
        List<Integer> tos = map.get(index);
        visited[index] = true;
        onPath[index] = true;
        if(tos!=null){
            for(int to: tos){
                dfs(visited,onPath, to);
            }
        }

        postorder.add(index);
        onPath[index] = false;

    }


}
