class Solution {
    public static List<List<Integer>> lt;
    public static boolean[] track;
    public int findCircleNum(int[][] nums) {
        lt=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            lt.add(new ArrayList<>());
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(j!=i && nums[i][j]==1){
                    lt.get(i).add(j);
                }
            }
        }
        // for(List<Integer> i:lt)System.out.println(i);
        int ans=0;
        track = new boolean[nums.length];
        for(int i=0;i<track.length;i++){
            if(!track[i]){
                track[i] = true;
                ans++;
                dfs(i);
            }
        }
        return ans;
    }
    public static void dfs(int n){
        for(int i=0;i<lt.get(n).size();i++){
            int val = lt.get(n).get(i);
            if(!track[val]){
                track[val] = true;
                dfs(val);
            }
        }
    }
}