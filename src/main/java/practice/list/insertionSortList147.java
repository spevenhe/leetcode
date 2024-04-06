package practice.list;

public class insertionSortList147 {

    public ListNode insertionSortList(ListNode head) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur!= null){
            if(cur.val < prev.val){
                ListNode temp = dummyHead;
                while(temp.next.val < cur.val){
                    temp = temp.next;
                }
                prev.next = cur.next;
                cur.next = temp.next;
                temp.next = cur;
                cur = prev.next;

            }
            else{
                prev = cur;
                cur = cur.next;
            }


        }
        return dummyHead.next;

    }


}
