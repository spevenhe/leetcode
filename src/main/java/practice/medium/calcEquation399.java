package practice.medium;

import java.util.*;

public class calcEquation399 {

    public static void main(String[] args) {

        double[] values = {2.0,3.0};
        List<String> equation1 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");

        List<String> equation2 = new ArrayList<>();
        equation2.add("b");
        equation2.add("c");
        List<String> equation3 = new ArrayList<>();
        equation3.add("bc");
        equation3.add("cd");
        List<List<String>> equations = new ArrayList<>();
        equations.add(equation1);
        equations.add(equation2);
//        equations.add(equation3);
        List<List<String>> queries = new LinkedList<>();
        List<String> queries1 = new ArrayList<>();
        queries1.add("a");
        queries1.add("c");
        List<String> queries2 = new ArrayList<>();
        queries2.add("b");
        queries2.add("a");
        List<String> queries3 = new ArrayList<>();
        queries3.add("a");
        queries3.add("e");
        List<String> queries4 = new ArrayList<>();
        queries4.add("a");
        queries4.add("a");
        List<String> queries5 = new ArrayList<>();
        queries5.add("x");
        queries5.add("x");
        queries.add(queries1);
        queries.add(queries2);
        queries.add(queries3);
        queries.add(queries4);
        queries.add(queries5);
        double[] rs = calcEquation(equations, values,queries);
        System.out.println(rs);
    }

    static HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        constructGraph(equations, values);
        double[] rs = new double[queries.size()];
        int i = 0;
        for(List<String> query : queries){
            String start = query.get(0);
            String end = query.get(1);
            if(graph.containsKey(start)){
                double num = bfs(start,end,1, new HashSet<>());
                if(num ==0){
                    rs[i] = -1d;
                }else{
                    rs[i] = num;
                }
            }else {
                rs[i] = -1d;
            }
            i++;
        }
        return rs;


    }

    public static double bfs(String start, String end, double num, Set<String> visited){
        HashMap<String, Double>tmp = graph.get(start);
        double rs = 0;
        visited.add(start);
        for(String key : tmp.keySet()){
            if(!visited.contains(key)&& end ==key){
                return num*tmp.get(key);
            }else{
                if(!visited.contains(key) && graph.containsKey(key)){
                    rs = bfs(key,end,num*tmp.get(key), visited);
                    if(rs != 0){
                        return rs;
                    }
                }

            }
        }
        return 0;
    }

    public static void constructGraph(List<List<String>> equations, double[] values){
        for(int i = 0;i< equations.size();i++){
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            double value = values[i];
            if(graph.containsKey(first)){
                HashMap<String, Double> tmp = graph.get(first);
                tmp.put(second, value);
            }else{
                HashMap<String, Double> tmp = new HashMap<>();
                tmp.put(second, value);
                graph.put(first,tmp);
            }
            if(graph.containsKey(second)){
                HashMap<String, Double> tmp = graph.get(second);
                tmp.put(second, 1/value);
            }else{
                HashMap<String, Double> tmp = new HashMap<>();
                tmp.put(first, 1/value);
                graph.put(second, tmp);
            }
        }
    }

}
