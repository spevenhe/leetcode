package practice.list;

public class getIntersectionNode160 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2){
            if(p1 == null){
                p1 = headB;
            }
            if(p1 != null){
                p1 = p1.next;
            }
            if(p2 == null){
                p1 = headA;
            }
            if(p2 != null){
                p2 = p2.next;
            }

        }
        return p1;
    }
}
