package practice;

public class songs1010 {
    public static void main(String[] args) {

        int[] time = {30,20,150,100,40};
        int[] tmp = new int[60];
        for(int timei : time){
            int roundi = timei%60;
            tmp[roundi]+=1;
        }
        int res = 0;
        for(int i = 0;i<60;i++){
            if(tmp[i]!=0){
                int pairi = i==0?0:60 - i;
                res+=tmp[i]*tmp[pairi];

            }

        }
        System.out.println(res/2);

    }
    }

