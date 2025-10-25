class Solution {
    public Integer[] dp;
    public int numDecodings(String s) {
        this.dp = new Integer[s.length()+1];
        return dfs(0,s);
    }
    public int dfs(int start, String s){
        if(start==s.length()){
            return 1;
        }
        if(dp[start]!=null) return dp[start];
        int val =0;
        for(int i=start;i<s.length();i++){
            String str = s.substring(start,i+1);
            if(valid(str)){
                val+=dfs(i+1,s);
            }
        }
        return dp[start] = val;
    }
    public boolean valid(String s){
        if(s.charAt(0)=='0' || s.length()>2) return false;
        int num =0;
        for(int i=0;i<s.length();i++){
            num = num*10 + s.charAt(i)-'0';
        }
        if(num>26) return false;
        return true;
    }
}