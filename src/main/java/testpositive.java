import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class testpositive {
    public static void main(String[] args) {
//       String S= "ability";
//        System.out.println(solution(S));
        String s2 = "we need a code?. . give me a try plz? no no no no !!!";
        String s1 = "Forget csvs..sva time . x x";
        System.out.println(solution2(s1));
        PriorityQueue<Integer>queue = new PriorityQueue<>((o1, o2) -> {return o1-o2;});
        queue.isEmpty();
        Stack<Integer> stack = new Stack<>();
    }

    public static String solution(String S){
        char[] sc = S.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char si : sc){
            if(set.contains(si)){
//                System.out.println(String.valueOf(si));

                return String.valueOf(si);
            }
            set.add(si);
        }
//        System.out.println(s);
        return S;
    }

    public static int solution2(String S){

        String[] sa = S.split("[?!.]");
        int res = 0;
        for(String si : sa){
            String[] tmp = si.trim().split(" ");
            res = Math.max(res,tmp.length);
        }
        return res;
    }

}
