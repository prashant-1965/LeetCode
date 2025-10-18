class Solution {
    public static Boolean[][] dp;
    public static boolean isPossible(int index,int jump, int size, int[] stones, Map<Integer,Integer> map)
    {
        if(jump<=0 || jump>=size)return false;
        if(index==size-1)return true;
        if(dp[index][jump]!=null) return dp[index][jump];
        if(!map.containsKey(stones[index]+jump)) return false;
        index = map.get(stones[index]+jump);
        return dp[index][jump] = isPossible(index,jump-1,stones.length,stones,map) || isPossible(index,jump,stones.length,stones,map) || isPossible(index,jump+1,stones.length,stones,map);
    }
    public boolean canCross(int[] stones) {
        if(stones[1]!=1) return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<stones.length;i++) map.put(stones[i],i);
        int n = stones.length;
        this.dp = new Boolean[n][n];
        boolean left = isPossible(1,1,stones.length,stones,map);
        this.dp = new Boolean[n][n];
        boolean right = isPossible(1,2,stones.length,stones,map);
        return left || right;
    }
}