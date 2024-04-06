package practice.list;

public class partition86 {

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        a.next = b;
        b.next = c;
        ListNode d = partition(a,2);

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode ptr1 = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode ptr2 = dummy2;
        ListNode ptr = head;
        while (ptr!=null){
            if(ptr.val <x){
                ptr1.next = ptr;
                ptr1 = ptr1.next;
            }
            if(ptr.val >=x){
                ptr2.next = ptr;
                ptr2 = ptr2.next;
            }
            ptr = ptr.next;
        }
        ptr2.next = null;
        ptr1.next = dummy2.next;
        return dummy1.next;
    }
}
