package practice.medium;

public class getHint299 {
    public static void main(String[] args) {

    }

    public String getHint(String secret, String guess) {
        char[] sc = secret.toCharArray();
        char[] gc = guess.toCharArray();
        int length = secret.length();
        int a = 0;
        int[] hashA = new int[10];
        int[] hashB = new int[10];
        for(int i = 0;i< length;i++){
            if(sc[i] == gc[i]){
                a++;
            }
            hashA[sc[i]-'0']++;
            hashB[gc[i]-'0']++;

        }

        int b = 0;
        for(int i = 0;i<hashA.length;i++){
            b+=Math.min(hashA[i],hashB[i]);
        }
        b = b-a;
        return String.valueOf(a)+"A"+String.valueOf(b)+"B";
    }

}
