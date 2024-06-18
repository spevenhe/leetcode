package practice.list;

public class removeNthFromEnd19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        int length = 1;
        while(ptr.next!= null){
            ptr = ptr.next;
            length++;
        }

        ListNode ptr2 = head;
        ListNode prev = head;
        ListNode next = null;
        int index1 = length - n;
        if(index1 == 0){
            return head.next;
        }
        int index2 = length - n +2;
        for(int i = 0;i < length;i++){
            if(i == index1-1){
                prev = ptr2;
            }else if(i == index2-1){
                next = ptr2;
                break;
            }
            ptr2 = ptr2.next;
        }
        prev.next = next;
        return head;

    }

}
