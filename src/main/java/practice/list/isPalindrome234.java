package practice.list;

public class isPalindrome234 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode rev = head;
        ListNode prev = null;
        while(fast!= null && fast.next!=null){
            rev = slow;
            slow = slow.next;

            fast = fast.next.next;
            rev.next = prev;
            prev = rev;
        }

        ListNode mid = slow.next;
        while(rev!= null && mid !=null){
            if(rev.val!= mid.val){
                return false;
            }
            rev = rev.next;
            mid = mid.next;
        }
        return true;
    }
}
