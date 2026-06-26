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
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(a!=null && b!=null) {
            if(a.val<b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }

            cur = cur.next;
        }

        if(a!=null) cur.next = a;
        else cur.next = b;

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;

        for(int i=1; i<lists.length; i++) {
            lists[i] = merge(lists[i], lists[i-1]);
        }

        return lists[lists.length-1];
    }
}
