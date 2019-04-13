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
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head == null || head.next == null)
            return head;
        ListNode res = head;
        head = head.next;
        res.next = null;
        
        while(head.next != null){
            ListNode next = head.next;
            head.next = res;
            res = head;
            head = next;
        }
        head.next = res;
        
        return head;
    }
}