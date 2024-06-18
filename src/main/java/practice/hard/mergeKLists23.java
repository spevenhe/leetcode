package practice.hard;

import practice.list.ListNode;

import java.util.PriorityQueue;

public class mergeKLists23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        for(ListNode tmp : lists){
            while (tmp!=null){
                queue.add(tmp);
            }
        }
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            ptr.next = node;
            ptr = ptr.next;
            if(node.next!=null){
                queue.add(node.next);
            }
        }
        return dummy.next;
    }
}
