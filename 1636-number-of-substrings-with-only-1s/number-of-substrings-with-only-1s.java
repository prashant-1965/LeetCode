class Solution {
    public int numSub(String s) {
        long ans=0L;
        int mod =1000000007,low=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                low=i;
                while(i<s.length() && s.charAt(i)=='1'){
                    i++;
                }
                long n = i-low;
                long temp = n*(n+1)/2;
                ans = (ans+temp)%mod;
            }
        }
        return (int)ans;
    }
}
