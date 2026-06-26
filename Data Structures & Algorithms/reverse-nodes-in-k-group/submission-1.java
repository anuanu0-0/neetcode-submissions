/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k<=1) return head;
        int count = 0;
        ListNode temp = head;
        while(temp!=null && count<k) {
            count++;
            temp = temp.next;
        }

        if(count<k) return head;
        count=0;
        ListNode prev = null, cur = head, next = null;
        while(cur!=null && count<k) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
            count++;
        }

        if(next!=null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}
