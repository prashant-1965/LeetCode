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
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean first = true;
        ListNode current = head, slow = null;
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],true);
        }
        while(current!=null)
        {
            if(!map.containsKey(current.val))
            {
                if(first)
                {
                    head = current;
                    slow = head;
                    first = false;
                }
                else
                {
                    slow.next = current;
                    slow = current;
                }
            }
            current = current.next;
        }
        slow.next = null;
        return head;
    }
}