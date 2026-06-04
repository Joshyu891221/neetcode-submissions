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
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode quick = head;

        while (quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;

            if (slow == quick) {
                return true;
            }
        }
        return false;
    }
}
