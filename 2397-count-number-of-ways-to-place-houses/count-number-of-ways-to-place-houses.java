class Solution {
    public final int mod = 1000000007;
    public int countHousePlacements(int n) {
        long n1 = 1L,n2 = 2L,temp;
        int ans=4;
        for(int i=1;i<n;i++){
            temp = (n1+n2)%mod;
            n1=n2;
            n2=temp;
            temp = (n2*n2)%mod;
            ans = (int)temp;
        }
        return ans;
    }
}