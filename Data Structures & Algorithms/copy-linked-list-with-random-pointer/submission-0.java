/*
// Definition for a Node.
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
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        while(cur!=null) {
            Node next = cur.next;
            Node temp = new Node(cur.val);
            cur.next = temp;
            temp.next = next;

            cur=temp.next;
        }

        // Update random pointers
        cur = head;
        while(cur!=null) {
            if(cur.random==null)  cur.next.random = cur.random;
            else cur.next.random = cur.random.next;

            cur = cur.next.next;
        }

        // Extract the copy list
        Node dummy = new Node(-1);
        Node copyList = dummy;
        cur = head;
        while(cur!=null) {
            Node temp = cur.next;
            cur.next = temp.next;
            copyList.next = temp;
            cur = cur.next;
            copyList = copyList.next;
        }

        return dummy.next;
    }
}
