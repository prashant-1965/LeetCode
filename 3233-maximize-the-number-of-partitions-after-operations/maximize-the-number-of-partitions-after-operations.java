class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        Map<Long, Integer> memo = new HashMap<>();

        return dfs(0, 0, 0, s, k, memo, n);
    }

    private int dfs(int i, int used, int mask, String s, int k, Map<Long, Integer> memo, int n) {
        if (i == n) return mask == 0 ? 0 : 1;
        long key = (((long) i) << 27) | ((long) used << 26) | mask;
        if (memo.containsKey(key)) return memo.get(key);

        int best = 0, ch = s.charAt(i) - 'a', newMask = mask | (1 << ch);

        if (Integer.bitCount(newMask) <= k)
            best = Math.max(best, dfs(i + 1, used, newMask, s, k, memo, n));
        else
            best = Math.max(best, 1 + dfs(i + 1, used, 1 << ch, s, k, memo, n));

        if (used == 0) {
            for (int c = 0; c < 26; c++) {
                if (c == ch) continue;
                int m = mask | (1 << c);
                if (Integer.bitCount(m) <= k)
                    best = Math.max(best, dfs(i + 1, 1, m, s, k, memo, n));
                else
                    best = Math.max(best, 1 + dfs(i + 1, 1, 1 << c, s, k, memo, n));
            }
        }

        memo.put(key, best);
        return best;
    }
}
