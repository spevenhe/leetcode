package practice.list;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class copyRandomList138 {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node>map = new HashMap<>();
        Node ptr = head;
        Node newHead = new Node(head.val);
        Node ptr2 = newHead;

        while(ptr!=null){
            map.put(ptr,ptr2);
            ptr = ptr.next;
            if(ptr!=null)ptr2.next = new Node(ptr.val);
            ptr2 = ptr2.next;
        }

        ptr = head;
        ptr2 = newHead;
        while (ptr!=null){
            ptr2.random = map.get(ptr.random);
            ptr = ptr.next;
            ptr2 = ptr2.next;
        }
        return newHead;


    }
}
