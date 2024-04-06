package practice.list;

import java.util.Arrays;
import java.util.Collections;

public class deleteDuplicates83 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null || head.next == null){
            return head;
        }
        ListNode ptr = head;
        ListNode prev = head;
        int tmp;
        while (ptr.next!=null){
            tmp = prev.val;
            ptr = ptr.next;
            if(tmp == ptr.val){
                prev.next = ptr.next;

            }else {
                prev = ptr;
            }

        }
        return head;
    }

    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[100];
        for(int num : nums){
            freq[num]++;
        }
        int max = 0;
        for(int freqi:freq){
            max = Math.max(freqi,max);
        }
        int res = 0;
        for(int freqi:freq){
            if(freqi == max){
                res++;
            }
        }
        return res*max;


    }
}
