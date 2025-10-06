class Solution {
    public static boolean[][] track;
    public static Queue<int[]> q;
    public static char[][] nums;
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
                    bfs(i,j);
                }
            }
        }
        return cnt;
    }
    public static void bfs(int row, int col){
        while(!q.isEmpty()){
            int[] temp = q.poll();
            if(temp[0]-1>=0 && !track[temp[0]-1][temp[1]] && nums[temp[0]-1][temp[1]]=='1'){
                track[temp[0]-1][temp[1]]=true;
                q.add(new int[]{temp[0]-1,temp[1]});
            }
            if(temp[0]+1<nums.length && !track[temp[0]+1][temp[1]] && nums[temp[0]+1][temp[1]]=='1'){
                track[temp[0]+1][temp[1]] = true;
                q.add(new int[]{temp[0]+1,temp[1]});
            }
            if(temp[1]-1>=0 && !track[temp[0]][temp[1]-1] && nums[temp[0]][temp[1]-1]=='1'){
                track[temp[0]][temp[1]-1]=true;
                q.add(new int[]{temp[0],temp[1]-1});
            }
            if(temp[1]+1<nums[0].length && !track[temp[0]][temp[1]+1] && nums[temp[0]][temp[1]+1]=='1'){
                track[temp[0]][temp[1]+1]=true;
                q.add(new int[]{temp[0],temp[1]+1});
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