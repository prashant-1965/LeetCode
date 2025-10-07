class Solution {
    public static List<List<Integer>> lt;
    public static boolean[] track;
    public boolean canFinish(int V, int[][] nums) {
        this.lt = new ArrayList<>();
        for(int i=0;i<V;i++)lt.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            lt.get(nums[i][1]).add(nums[i][0]);
        }
        this.track = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!track[i] && dfs(i, new boolean[V])) return false;
        }
        return true;
    }
    public boolean dfs(int n, boolean[] path){
        track[n]=true;
        path[n]=true;
        boolean flag = false;
        for(int i=0;i<lt.get(n).size();i++){
            int val = lt.get(n).get(i);
            if(track[val] && path[val]) return true;
            if(!track[val]){
                flag |= dfs(val,path);
                path[val]=false;
            }
        }
        return flag;
    }
}