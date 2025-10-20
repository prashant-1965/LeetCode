class Solution {
    public List<String> ans;
    public List<String> generateParenthesis(int n) {
        this.ans = new ArrayList<>();
        dfs(0,0,n,new StringBuilder());
        return ans;
    }
    public void dfs(int op, int clo, int n, StringBuilder sb){
        if(op==n && clo==n){
            ans.add(sb.toString()); return;
        }
        if(op<=n){
            sb.append('(');
            dfs(op+1,clo,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(op>clo && clo<n){
            sb.append(')');
            dfs(op,clo+1,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}