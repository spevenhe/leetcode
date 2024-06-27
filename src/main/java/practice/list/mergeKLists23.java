package practice.list;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class mergeKLists23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode node : lists){
            if(node!=null){
                priorityQueue.add(node);
            }

        }
        ListNode newHead = new ListNode(0);
        ListNode ptr = newHead;
        while(!priorityQueue.isEmpty()){
            ListNode tmp = priorityQueue.poll();
            ptr.next = tmp;
            ptr = ptr.next;
            if(tmp.next!=null){
                priorityQueue.add(tmp.next);
            }
        }
        return newHead.next;
    }

}
