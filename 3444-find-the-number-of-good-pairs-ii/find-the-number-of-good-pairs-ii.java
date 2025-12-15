class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long ans=0L;
        int temp=-1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++)
        {
            temp = nums2[i]*k;
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=1;j<=(int)Math.sqrt(nums1[i]);j++)
            {
                if(nums1[i]%j==0)
                {
                    if(map.containsKey(j))
                    {
                        ans+=map.get(j);
                    }
                    if((nums1[i]/j)!=j && map.containsKey(nums1[i]/j))
                    {
                        ans+=map.get(nums1[i]/j);
                    }
                }
            }
        }
        return ans;
    }
}