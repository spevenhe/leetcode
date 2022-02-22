import java.util.LinkedList;

public class decode394 {

    public static void main(String[] args) {
        String rs = decodeString("3[a]2[bc]");
        System.out.println(rs);
    }
    public static String decodeString(String s) {
        LinkedList<Character>queue = new LinkedList<Character>();
        for(char ch : s.toCharArray()){
            queue.add(ch);
        }
        return helper(queue);
    }
    public static String helper(LinkedList<Character>queue){
        int num = 0;
        String s = "";
        while (!queue.isEmpty()){
            char ch = queue.poll();
            if(Character.isDigit(ch)){
                num = num*10 + ch-'0';
            }
            else if(ch == '['){
                String tmp = helper(queue);
                for(int i = 0;i<num;i++){
                    s+=tmp;
                }
                num = 0;
            }
            else if(ch == ']'){
                break;
            }
            else {
                s = s+ch;
            }
        }
        return s;

    }
}
