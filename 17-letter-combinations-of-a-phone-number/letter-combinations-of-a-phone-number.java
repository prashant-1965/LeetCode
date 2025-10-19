class Solution {
    public static Map<Integer,String> map = new HashMap<>();
    static{
        map.put(2,"abc"); map.put(3,"def"); map.put(4,"ghi"); map.put(5,"jkl");
        map.put(6,"mno"); map.put(7,"pqrs"); map.put(8,"tuv"); map.put(9,"wxyz");
    }
    public static List<List<Character>> lt;
    public static List<String> ans;
    public List<String> letterCombinations(String str) {
        this.lt = new ArrayList<>();
        for(int i=0;i<str.length();i++) lt.add(new ArrayList<>());
        for(int i=0;i<str.length();i++){
            int val = str.charAt(i)-'0';
            String s = map.get(val);
            for(int j=0;j<s.length();j++){
                lt.get(i).add(s.charAt(j));
            }
        }
        // for(int i=0;i<lt.size();i++){
        //     for(int j=0;j<lt.get(i).size();j++){
        //         System.out.print(lt.get(i).get(j)+" ");
        //     }
        //     System.out.println();
        // }
        this.ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(0,0,new StringBuilder());
        return ans;
    }
    public static void dfs(int row, int col, StringBuilder sb){
        if(row==lt.size()){
            ans.add(sb.toString());
            return;
        }
        if(col==lt.get(row).size()){
            return;
        }
        sb.append(lt.get(row).get(col));
        dfs(row+1,0,sb);
        sb.deleteCharAt(sb.length() - 1);
        dfs(row,col+1,sb);
    }
}