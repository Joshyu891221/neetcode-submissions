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
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode groupPrev = dummy;

        while(true){
            ListNode kth = getKth(k, groupPrev);
            if(kth == null) break;
            
            ListNode groupNext = kth.next;

            ListNode curr = groupPrev.next;
            ListNode prev = groupNext;

            for(int i = 0; i < k; i++){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        return dummy.next;
    }
    public ListNode getKth(int k, ListNode node){
        while(node != null && k > 0){
            node = node.next;
            k--;
        }

        return node;
    }
}
