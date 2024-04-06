package practice.list;

import practice.list.ListNode;

public class rotateRight61 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        ListNode rs = rotateRight(a,7);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        if(head ==null){
            return null;
        }
        int n = 1;
        while(tail.next!=null){
            tail = tail.next;
            n ++;
        }

        tail.next = head;
        int move = k%n;
        ListNode tmp = head;
        ListNode breakPoint = head;
        for(int i = 0;i<move;i++){
            tmp = tmp.next;
        }
        while(tmp!=tail){
            breakPoint = breakPoint.next;
            tmp = tmp.next;
        }
        ListNode rs = breakPoint.next;
        breakPoint.next = null;
        return rs;
    }

}
