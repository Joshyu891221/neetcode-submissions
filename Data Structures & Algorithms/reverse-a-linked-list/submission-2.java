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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode start = new ListNode(2);
        ListNode curr = head;
        start.next = curr;
        while(curr.next != null){
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = start.next;
            start.next = temp;
        }
        return start.next;


    }
}
