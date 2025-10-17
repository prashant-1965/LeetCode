class Solution {

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long part1 = power(5, evenCount);
        long part2 = power(4, oddCount);

        return (int)((part1 * part2) % 1000000007);
    }

    public static long power(long x, long n) {
        long res = 1;
        x %= 1000000007;
        while (n > 0) {
            if ((n & 1) == 1)
                res = (res * x) % 1000000007;
            x = (x * x) % 1000000007;
            n >>= 1;
        }
        return res;
    }
}
