class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> nums) {
        boolean[] track = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            track[nums.get(i).get(1)]=true;
        }
        for(int i=0;i<n;i++) if(!track[i])ans.add(i);
        return ans;
    }
}