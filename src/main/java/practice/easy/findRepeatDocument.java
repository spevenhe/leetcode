package practice.easy;

public class findRepeatDocument {



    public static void main(String[] args) {
        int[] input = {2, 5, 3, 0, 5, 0};
        int res = findRepeatDocument(input);
        System.out.println(res);
    }

    public static int findRepeatDocument(int[] documents) {
        int n = documents.length;
        for(int i = 0;i<n;i++){
            while(documents[i]!=i){
                if(documents[documents[i]] == documents[i]){
                    return documents[i];
                }
                swap(documents[i],i,documents);
            }
        }
        return -1;
    }

    public static void swap(int a, int b, int[] nums){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
