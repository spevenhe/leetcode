package practice.medium;

import java.util.LinkedList;

public class simplifyPath71 {

    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        LinkedList<String> list = new LinkedList<>();
        for(String pathi : paths){
            if(pathi.equals("") || pathi.equals(".")){
                continue;
            }
            else if(pathi.equals("..")){
                if(!list.isEmpty()){
                    list.pollLast();
                }
            }
            else{
                list.addLast(pathi);
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for(String pathi : list){
            sb.append(pathi);
            sb.append("/");
        }
        if(sb.length()>1){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }


}
