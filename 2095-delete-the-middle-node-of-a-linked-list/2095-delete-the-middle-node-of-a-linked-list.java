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
    public ListNode deleteMiddle(ListNode head) {
        ListNode curr = head; 
        List<Integer> newL = new ArrayList<>();

        while(curr != null){
            newL.add(curr.val);
            curr=curr.next;
        }
        if(newL.size() <= 1 )return null;
        int remIndex = (newL.size() / 2)-1;

        curr = head;
        for(int i = 0 ; i < remIndex; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }
}