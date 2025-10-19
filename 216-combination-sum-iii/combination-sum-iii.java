class Solution {
    public static List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.ans = new ArrayList<>();
        dfs(k,n, new ArrayList<>(),0);
        return ans;
    }
    public static void dfs(int k, int n, List<Integer> lt, int sum){
        if(lt.size()>k || sum>n) return;
        if(lt.size()==k && sum==n){
            ans.add(new ArrayList<>(lt));
        }
        int start = lt.size()==0?1:lt.get(lt.size()-1)+1;
        for(int i=start;i<=9;i++){
            lt.add(i);
            dfs(k,n,lt,sum+i);
            lt.remove(lt.size()-1);
        }
    }

}