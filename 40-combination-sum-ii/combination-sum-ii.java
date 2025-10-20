class Solution {
    public static List<List<Integer>> ans;
    // public static Set<String> set;
    public List<List<Integer>> combinationSum2(int[] nums, int k) {
        Arrays.sort(nums);
        this.ans = new ArrayList<>();
        // this.set = new HashSet<>();
        dfs(0,nums,k,new ArrayList<>());
        return ans;
    }
    public static void dfs(int idx, int[] nums, int k, List<Integer> lt){
        if(k==0){
            // Collections.sort(lt);
            // StringBuilder sb=  new StringBuilder();
            // for(int i:lt)sb.append(i);
            // String str = sb.toString();
            // System.out.println(str);
            // if(!set.contains(str)){
                ans.add(new ArrayList<>(lt));
            //     set.add(str);
            // }
            return;
        }
        if(k<0 || idx==nums.length) return;
        lt.add(nums[idx]);
        dfs(idx+1,nums,k-nums[idx],lt);
        while(idx+1<nums.length && nums[idx]==nums[idx+1]){
            idx++;
        }
        lt.removeLast();
        dfs(idx+1,nums,k,lt);
    }
}
// 1 2 2 2 5 