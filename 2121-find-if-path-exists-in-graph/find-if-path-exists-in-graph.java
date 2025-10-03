class Solution {
    public static List<List<Integer>> lt;
    public static boolean[] track;
    public boolean validPath(int n, int[][] nums, int s, int d) {
        track = new boolean[n];
        lt = new ArrayList<>();
        for(int i=0;i<n;i++)lt.add(new ArrayList<>());
        for(int[] i:nums){
            lt.get(i[0]).add(i[1]);
            lt.get(i[1]).add(i[0]);
        }
        // for(List<Integer> i:lt)System.out.println(lt);
        track[s]=true;
        return dfs(s,d);
    }
    public static boolean dfs(int s, int d){
        if(s==d) return true;
        boolean flag = false;
        for(int i=0;i<lt.get(s).size();i++){
            int val = lt.get(s).get(i);
            if(!track[val]){
                track[val] = true;
                flag|=dfs(val,d);
            }
        }
        return flag;
    }
}