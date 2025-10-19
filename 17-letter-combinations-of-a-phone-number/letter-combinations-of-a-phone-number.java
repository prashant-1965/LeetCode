class Solution {
    public static String[]  st = {"0","0","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<List<Character>> lt;
    public static List<String> ans;
    public List<String> letterCombinations(String str) {
        this.lt = new ArrayList<>();
        for(int i=0;i<str.length();i++) lt.add(new ArrayList<>());
        for(int i=0;i<str.length();i++){
            int val = str.charAt(i)-'0';
            String s = st[val];
            for(int j=0;j<s.length();j++){
                lt.get(i).add(s.charAt(j));
            }
        }
        this.ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(0,0,new StringBuilder());
        return ans;
    }
    public static void dfs(int row, int col, StringBuilder sb){
        if(row==lt.size()){
            ans.add(sb.toString()); return;
        }
        if(col==lt.get(row).size())return;
        sb.append(lt.get(row).get(col));
        dfs(row+1,0,sb);
        sb.deleteCharAt(sb.length() - 1);
        dfs(row,col+1,sb);
    }
}