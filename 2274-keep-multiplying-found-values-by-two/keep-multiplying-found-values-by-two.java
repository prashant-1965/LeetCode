class Solution {
    public int findFinalValue(int[] nums, int k) {
        boolean[] track = new boolean[1001];
        for(int i:nums) track[i]=true;
        while(true){
            if(k<1001 && track[k]){
                k = 2*k;
            }else{
                return k;
            }
        }
    }
}