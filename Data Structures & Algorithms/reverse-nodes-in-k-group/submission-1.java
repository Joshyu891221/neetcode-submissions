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
        if(head == null || k == 1) return head;

        ListNode res = new ListNode();
        ListNode groupPrev = res;
        res.next = head;

        while(true){
            ListNode kth = getKth(groupPrev, k);

            if(kth == null ) return res.next;
            ListNode groupNext = kth.next;

            ListNode curr = groupPrev.next;
            ListNode prev = groupNext;

            for(int i = 0; i < k; i++){
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }


    }

    public ListNode getKth(ListNode node, int k){
        while(node != null && k > 0){
            node = node.next;
            k--;
        }
        return node;
    }
}
