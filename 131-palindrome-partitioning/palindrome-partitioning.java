class Solution {
    public List<List<String>> ans;
    public List<List<String>> partition(String s) {
        this.ans=  new ArrayList<>();
        dfs(0,s,new ArrayList<>());
        return ans;
    }
    public void dfs(int idx, String s, List<String> lt){
        if (idx == s.length()) {
            ans.add(new ArrayList<>(lt));
            return;
        }
        for(int i=idx;i<s.length();i++){
            String sub = s.substring(idx, i + 1);
            if (isValid(sub)) {
                lt.add(sub);
                dfs(i + 1, s, lt);
                lt.remove(lt.size() - 1);
            }
        }
    }
    public boolean isValid(String s){
        int low=0,high=s.length()-1;
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)) return false;
            low++;high--;
        }
        return true;
    }
}