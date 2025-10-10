class Solution {
    public boolean isBipartite(int[][] nums) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] even = new boolean[nums.length];
        boolean[] odd=  new boolean[nums.length];
        for(int k=0;k<nums.length;k++){
            if(!even[k] && !odd[k]){
                q.add(k);
                even[k]=true;
                while(!q.isEmpty()){
                    int n = q.poll();
                    for(int i=0;i<nums[n].length;i++){
                        int val = nums[n][i];
                        if(even[n]){
                            if(even[val]) return false;
                            if(!odd[val]){
                                odd[val]=true;
                                q.add(val);
                            }
                        }else{
                            if(odd[val]) return false;
                            if(!even[val]){
                                even[val]=true;
                                q.add(val);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}