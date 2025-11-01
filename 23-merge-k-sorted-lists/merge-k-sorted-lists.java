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
    public ListNode mergeKLists(ListNode[] nums) {
        ListNode head = null;
        if(nums.length==0) return head;
        int j=0;
        while(j<nums.length-1 && nums[j]==null){
            j++;
        }
        head = nums[j];
        ListNode sec,temp1,temp2,prev,first;
        for(int i=j+1;i<nums.length;i++){
            sec = nums[i];
            first = head;
            prev = head;
            while(first!=null && sec!=null){
                if(first.val<sec.val){
                    prev = first;
                    first=first.next;
                }else if(first.val==sec.val){
                    prev = first;
                    temp1 = first.next;
                    temp2 = sec.next;
                    first.next = sec;
                    first = first.next;
                    sec = temp2;
                    first.next = temp1;

                }else{
                    if(first==head){
                        head = sec;
                        sec = sec.next;
                        head.next = prev;
                        prev = head;
                    }else{
                        prev.next = sec;
                        sec = sec.next;
                        prev = prev.next;
                        prev.next = first;
                    }
                }
            }
            while(sec!=null){
                prev.next = sec;
                sec = sec.next;
                prev = prev.next;
                first = prev.next;
            }
        }
        return head;
    }
}