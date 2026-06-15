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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode curr = res;
        boolean hasten = false;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val;

            if(hasten) sum ++;

            if(sum > 9){
                sum -= 10;              
                hasten = true;
            }else{
                hasten = false;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val;
            if(hasten) sum++;

            if(sum > 9){
                sum -= 10;              
                hasten = true;
            }else{
                hasten = false;
            }

            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = l2.val;
            if(hasten) sum++;

            if(sum > 9){
                sum -= 10;              
                hasten = true;
            }else{
                hasten = false;
            }

            curr.next = new ListNode(sum);
            curr = curr.next;
            l2 = l2.next;
        }

        if(hasten) curr.next = new ListNode(1);
        return res.next;
    }
}
