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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode dummy = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        
        while (prev != null) {
            ListNode tempd = dummy.next;
            ListNode tempp = prev.next;
            if (dummy.val == prev.val) {
                break;
            }
            dummy.next = prev;
            dummy = dummy.next;
            if(tempp == null) {
                break;
            }
            dummy.next = tempd;
            dummy = dummy.next;
            prev = tempp;

        }
        while (prev != null){

            System.out.print(prev.val);
            prev = prev.next;
        }
    }
}
