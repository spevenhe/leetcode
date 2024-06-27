package practice.medium;

public class smallestString2734 {

    public String smallestString(String s) {
        char[] sc = s.toCharArray();
        int start = -1;
        int end = -1;
        int n = s.length();
        for(int i = 0;i<n;i++){
            if(sc[i]!='a'){
                start = i;
                break;
            }
        }
        if(start ==-1){
            sc[n-1] = 'z';
            return new String(sc);
        }else{
            for(int j = start;j<n;j++){
                if(sc[j]=='a'){
                    end = j;
                    break;
                }
            }
            for(int i = start;i<end;i++){
                sc[i] = (char)(sc[i] - 1);
            }
            return new String(sc);
        }



    }
}
