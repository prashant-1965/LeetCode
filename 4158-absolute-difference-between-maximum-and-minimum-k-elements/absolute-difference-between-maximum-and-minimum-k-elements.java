class Solution {
    public int absDifference(int[] nums, int k) {
        if(k==nums.length) return 0;
        Arrays.sort(nums);
        int sum1=0,sum2=0;
        for(int i=0;i<k;i++){
            sum1 +=nums[i];
        }
        // System.out.println(sum1);
        k = nums.length-k;
        while(k<nums.length){
            sum2 +=nums[k];
            k++;
        }
        // System.out.println(sum1);
        return Math.abs(sum1-sum2);
    }
}
// 2 2 4 5