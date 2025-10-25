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
        int num = Integer.parseInt(s);
        if(num>26) return false;
        return true;
    }
}