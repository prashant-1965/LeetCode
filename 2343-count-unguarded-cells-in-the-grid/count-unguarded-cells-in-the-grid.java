class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] nums = new int[m][n];
        for (int[] w : walls) nums[w[0]][w[1]] = 1;
        for (int[] g : guards) nums[g[0]][g[1]] = 2;

        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        for (int i = 0; i < m; i++) {
            boolean seenGuard = false;
            for (int j = n - 1; j >= 0; j--) {
                if (nums[i][j] == 1) seenGuard = false;
                else if (nums[i][j] == 2) seenGuard = true;
                else if (seenGuard) right[i][j] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            boolean seenGuard = false;
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 1) seenGuard = false;
                else if (nums[i][j] == 2) seenGuard = true;
                else if (seenGuard) left[i][j] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            boolean seenGuard = false;
            for (int i = m - 1; i >= 0; i--) {
                if (nums[i][j] == 1) seenGuard = false;
                else if (nums[i][j] == 2) seenGuard = true;
                else if (seenGuard) down[i][j] = 1;
            }
        }

        for (int j = 0; j < n; j++) {
            boolean seenGuard = false;
            for (int i = 0; i < m; i++) {
                if (nums[i][j] == 1) seenGuard = false;
                else if (nums[i][j] == 2) seenGuard = true;
                else if (seenGuard) up[i][j] = 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 1 || nums[i][j] == 2) continue;
                if (left[i][j] == 0 && right[i][j] == 0 && up[i][j] == 0 && down[i][j] == 0) ans++;
            }
        }

        return ans;
    }
}
