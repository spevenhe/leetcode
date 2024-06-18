package practice.binarySearch;

import java.util.LinkedList;
import java.util.List;

public class findClosestElements658 {
    public static void main(String[] args) {
        int[] input = {0,0,1,2,3,3,4,7,7,8};
        List<Integer> res = findClosestElements(input, 3, 5);
        for( int i :res){
            System.out.println(i);
        }

    }


    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int nearest = findNearestLeftBound(arr,x);
        int left = nearest -1 ;
        int right = nearest  ;
        LinkedList<Integer> res = new LinkedList<>();
        while(right - left -1  <k){
            if(left < 0){
                res.addLast(arr[right]);
                right++;
            }
            else if(right == arr.length){
                res.addFirst(arr[left]);
                left --;
            }
            else if((arr[right] - x) < (x- arr[left])){
                res.addLast(arr[right]);
                right++;

            }else if((arr[right] - x) >= (x- arr[left])){
                res.addFirst(arr[left]);
                left --;
            }
        }
        return res;
    }

    public static int findNearestLeftBound(int[] arr, int x){
        int left = 0;
        int right = arr.length;
        while(left < right){
            int mid = (left + right)/2;
            if(arr[mid] < x){
                left = mid+1;
            }else if(arr[mid] > x){
                right = mid;
            }else {
                right = mid;
            }
        }
        return (left ==right || arr[left] >x)?left-1:left;
    }
}
