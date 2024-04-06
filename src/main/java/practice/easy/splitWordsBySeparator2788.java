package practice.easy;

import java.util.LinkedList;
import java.util.List;

public class splitWordsBySeparator2788 {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String>ans = new LinkedList<>();
        String sep = String.valueOf(separator);
        for(String word : words){

            String[] wordArray = word.split(sep);
            for(String wordi : wordArray){
                if(wordi!=null && wordi.length()>0){
                    ans.add(wordi);
                }

            }
        }
        return ans;
    }
}
