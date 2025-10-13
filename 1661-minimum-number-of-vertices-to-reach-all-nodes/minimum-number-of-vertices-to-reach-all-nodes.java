class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> nums) {
        boolean[] track = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> lt = new ArrayList<>();
        for(int i=0;i<n;i++){
            lt.add(new ArrayList<>());
        }
        for(int i=0;i<nums.size();i++){
            lt.get(nums.get(i).get(0)).add(nums.get(i).get(1));
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!track[i]){
                q.add(i);
                while(!q.isEmpty()){
                    int val = q.poll();
                    for(int j=0;j<lt.get(val).size();j++){
                        int num = lt.get(val).get(j);
                        if(!track[num]){
                            track[num]=true;
                            q.add(num);
                        }
                    }

                }
            }
        }
        for(int i=0;i<n;i++) if(!track[i])ans.add(i);
        return ans;
    }
}