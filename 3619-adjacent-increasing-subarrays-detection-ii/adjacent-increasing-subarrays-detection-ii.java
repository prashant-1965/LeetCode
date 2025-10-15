class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums)
    {
        int n = nums.size();
        int[] incLengths = new int[n];
        int length = 1;

        for (int i = n - 2; i >= 0; i--)
        {
            if (nums.get(i) < nums.get(i + 1))
            {
                length++;
            }
            else
            {
                length = 1;
            }
            incLengths[i] = length;
        }
        int left = 1;
        int right = n / 2;
        int maxK = 0;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            boolean found = false;
            for (int i = 0; i <= n - 2 * mid; i++)
            {
                if (incLengths[i] >= mid && incLengths[i + mid] >= mid)
                {
                    found = true;
                    break;
                }
            }

            if(found)
            {
                maxK = mid;
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return maxK==0?1:maxK;
    }
}
