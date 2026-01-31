class Solution {
    public char nextGreatestLetter(char[] nums, char k) {
        if(k=='z') return nums[0];
        int low = 0, high = nums.length-1,ans=0;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]-'a'<=k-'a'){
                low = mid+1;
            }else if(nums[mid]-'a'>k-'a'){
                ans = mid;
                high = mid-1;
            }
        }
        return nums[ans];
    }
}