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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next == null) return new int []{-1, -1};
        int minDistance = Integer.MAX_VALUE;
        int first = -1;
        int previous = -1;
        int index = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while(curr.next != null){
            ListNode next = curr.next;
            if((curr.val > prev.val && curr.val > next.val) || 
            (curr.val < prev.val && curr.val < next.val)){
                if(first == -1){
                    first = index;
                }
                if(previous != -1){
                    minDistance = Math.min(minDistance, index - previous);
                }
                previous = index;
            }

            prev = curr;
            curr = next;
            index++;
        }

        if(first == -1 || previous == first) return new int []{-1, -1};
        int maxDistance = previous - first;
        return new int []{minDistance, maxDistance};
    }
}