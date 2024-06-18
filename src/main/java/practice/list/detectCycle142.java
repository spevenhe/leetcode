package practice.list;

import java.util.Arrays;

public class detectCycle142 {

    public static void main(String[] args) {
        int[] nums = {10,8,8,9};
        int[][]queries = {{2,3},{0,1},{2,3},{0,1}};
        boolean[] rs = isArraySpecial(nums, queries);
        for(boolean ri :rs){
            System.out.println(ri);
        }
    }


    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode ptr1 = head;
                ListNode ptr2 = slow;
                while (ptr1 != ptr2){
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1;
            }
        }
        return null;


    }

//    public boolean isArraySpecial(int[] nums) {
//
//        boolean flag = nums[0]%2==0;
//        for(int i = 1;i<nums.length;i++){
//            if(flag){
//                if(nums[i] %2 ==0){
//                    return false;
//                }
//                flag = false;
//            }
//            else {
//                if(nums[i] %2 !=0){
//                    return false;
//                }
//                flag = true;
//            }
//        }
//        return true;
//    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] rs = new boolean[queries.length];
        int index = 0;
        int maxRight = 0;
        int minLeft = queries.length;
        for(int[] query :queries){
            int start = query[0];
            int end = query[1];
            rs[index] = true;

            if(end <= maxRight && start >= minLeft){
                index++;
                continue;
            }
            boolean flag = nums[start]%2==0;
            for(int i = start+1;i<=end;i++){
                if(flag){
                    if(nums[i] %2 ==0){
                        rs[index] = false;
                        break;
                    }
                    flag = false;
                }
                else {
                    if(nums[i] %2 !=0){
                        rs[index] = false;
                        break;
                    }
                    flag = true;
                }
            }
            if(rs[index]){
                if(maxRight < end && minLeft > start){
                    maxRight = end;
                    minLeft = start;
                }

            }

            index++;

        }
        return rs;
    }


}
