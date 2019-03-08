/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // write your code here
        if(head == null) return null;
        ListNode one = head;
        ListNode two = head;
        while(two.next != null && two.next.next != null){
            two = two.next.next;
            one = one.next;
        }
        return one;
    }
}