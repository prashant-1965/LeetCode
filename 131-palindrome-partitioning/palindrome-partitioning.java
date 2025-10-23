class Solution {
    public List<List<String>> ans;
    public List<List<String>> partition(String s) {
        this.ans = new ArrayList<>();
        dfs(0,s,new ArrayList<>());
        return ans;
    }
    public void dfs(int start, String s, List<String> lt){
        if(start==s.length()){
            ans.add(new ArrayList<>(lt)); return;
        }
        for(int i=start;i<s.length();i++){
            String str = s.substring(start,i+1);
            if(isPalindrome(str)){
                lt.add(str);
                dfs(i+1,s,lt);
                lt.removeLast();
            }
        }
    }
    public boolean isPalindrome(String str){
        int low=0,high=str.length()-1;
        while(low<high){
            if(str.charAt(low)!=str.charAt(high)) return false;
            low++; high--;
        }
        return true;
    }
}