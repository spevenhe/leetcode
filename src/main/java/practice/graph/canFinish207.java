package practice.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class canFinish207 {

    public static void main(String[] args) {
        int num = 2;
        int[][] prerequisites = {{1,0},{0,1}};



    }

    public Map<Integer, List<Integer>>map  = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        boolean rs = true;
        for(int from : map.keySet()){

            rs = dfs(visited,from);
            if(!rs){
                return false;
            }

        }
        return rs;
    }

    public boolean dfs(boolean[] visited, int index){
        if(visited[index]){
            return false;
        }
        if(!map.containsKey(index)){
            return true;
        }

        List<Integer> tos = map.get(index);
        visited[index] = true;
        boolean rs = true;
        for(int to: tos){
            rs =  dfs(visited, to);
            if(!rs){
                return rs;
            }
        }
        visited[index] = false;
        return rs;

    }



}
