class Solution {
    public static boolean[][] track;
    public static Queue<int[]> q;
    public static char[][] nums;
    public static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] nums) {
        int cnt=0;
        this.nums=nums;
        this.track = new boolean[nums.length][nums[0].length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]=='1' && !track[i][j]){
                    cnt++;
                    this.q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    track[i][j]=true;
                    bfs();
                }
            }
        }
        return cnt;
    }
    public static void bfs(){
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if (r >= 0 && c >= 0 && r < nums.length && c < nums[0].length &&
                    nums[r][c] == '1' && !track[r][c]) {
                    track[r][c] = true;
                    q.add(new int[]{r, c});
                }
            }
        }
    }
}

// dfs
// class Solution {
//     public static boolean[][] track;
//     public static char[][] nums;
//     public int numIslands(char[][] nums) {
//         this.nums = nums;
//         track = new boolean[nums.length][nums[0].length];
//         int cnt=0;
//         for(int i=0;i<nums.length;i++){
//             for(int j=0;j<nums[0].length;j++){
//                 if(nums[i][j]=='1' && !track[i][j]){
//                     cnt++;
//                     dfs(i,j);
//                 }
//             }
//         }
//         return cnt;
//     }
//     public static void dfs(int i, int j){
//         if(i<0 || j<0 || i==nums.length || j==nums[0].length || nums[i][j]=='0' || track[i][j]) return;
//         if(!track[i][j]){
//             track[i][j]= true;
//             dfs(i,j+1);
//             dfs(i+1,j);
//             dfs(i,j-1);
//             dfs(i-1,j);
//         }
//     }
// }