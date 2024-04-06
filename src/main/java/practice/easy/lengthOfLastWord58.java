package practice.easy;

public class lengthOfLastWord58 {

    public int lengthOfLastWord(String s) {
        String[] sc = s.split(" ");
        String last = sc[sc.length-1];
        return last.length();
    }
}
