class Solution {
    public final int mod = 1000000007;
    public int numTilings(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 5;
        long n1=1L;
        long n2 = 2L;
        long n3 = 5L;
        for(int i=4;i<=n;i++){
            long temp = n3*2 + n1;
            n1 = n2;
            n2 = n3;
            n3 = temp%mod;
        }
        return (int)n3;
    }
}
// 1->1
// 2->2
// 3->5
// 4->11