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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        while (lists.length > 1){
            ListNode[] mergelist = new ListNode[(lists.length + 2 - 1) / 2];
            for( int i = 0; i < lists.length; i += 2){

                ListNode node1 = lists[i];
                ListNode node2 = null;
                if(i + 1 < lists.length){
                    node2 = lists[i + 1];
                }
                mergelist[i / 2] = mergedList(node1, node2);
            }
            lists = mergelist;
        }
        return lists[0];
    }
    public ListNode mergedList (ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 != null){
            tail.next = l1;
        }else{
            tail.next = l2;
        }
        return dummy.next;
    }
}
