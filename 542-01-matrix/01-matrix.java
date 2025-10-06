class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        // Initialize distances
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (ans[nr][nc] > ans[r][c] + 1) {
                        ans[nr][nc] = ans[r][c] + 1;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return ans;
    }
}
