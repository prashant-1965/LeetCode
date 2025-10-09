class Solution {
    public static boolean[] path;
    public static boolean[] track;
    public static Stack<Integer> st;
    public static List<List<Integer>> lt;
    public static boolean flag;
    public int[] findOrder(int V, int[][] nums) {
        this.path = new boolean[V];
        this.track = new boolean[V];
        this.st=  new Stack<>();
        this.lt = new ArrayList<>();
        this.flag = false;

        for(int i=0;i<V;i++)lt.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++) lt.get(nums[i][1]).add(nums[i][0]);
        for(int i=0;i<V;i++){
            if(!track[i]){
                dfs(i);
                st.add(i);
                if(flag) return new int[]{};
            }
        }
        int[] ans = new int[st.size()];
        for(int i=0;i<ans.length;i++)ans[i]=st.pop();
        return ans;
    }
    public static void dfs(int n){
        if(flag) return;
        track[n]=true;
        path[n]=true;
        for(int i=0;i<lt.get(n).size();i++){
            int val = lt.get(n).get(i);
            if(path[val]){
                flag = true; return;
            }
            if(!track[val]){
                dfs(val);
                st.add(val);
            }
        }
        path[n]=false;
    }
}