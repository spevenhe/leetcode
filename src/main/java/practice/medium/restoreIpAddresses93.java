package practice.medium;

import java.util.LinkedList;
import java.util.List;

public class restoreIpAddresses93 {

    public static void main(String[] args) {
//        String input = "25525511135";
        String input = "101023";
//        String input = "25525511135";
        List<String>rs = restoreIpAddresses(input);
        for(String ri :rs){
            System.out.println(ri);
        }
    }

    private static List<String>rs = new LinkedList<>();

    public static List<String> restoreIpAddresses(String s) {
        char[]sc = s.toCharArray();
        dfs(sc,0,0,"",new boolean[sc.length]);
        return rs;
    }

    public static void dfs(char[] sc, int start, int count, String tmp, boolean[]visited){

        if(count == 4){
            if(start == sc.length){
                rs.add(tmp.substring(1));
            }
            return;
        }

        if(start >= sc.length || sc.length - start <( 4- count) || sc.length - start > 3*( 4- count)){
            return;
        }
        if(sc[start]=='0'){
            dfs(sc,start+1,count+1,tmp+"."+sc[start],visited);
        }
        else{
            dfs(sc,start+1,count+1,tmp+"."+sc[start],visited);
            if(start < sc.length-1){
                String number = String.valueOf(sc[start])+sc[start+1];
                dfs(sc,start+2,count+1,tmp+"."+number,visited);
            }
            if(start < sc.length-2){
                if((sc[start]-'0')<=2){
                    String number = String.valueOf(sc[start])+sc[start+1]+sc[start+2];
                    int num = Integer.valueOf(number);
                    if(num <= 255){
                        dfs(sc,start+3,count+1,tmp+"."+number,visited);
                    }
                }

            }


        }
    }


}
