class Solution {
    public int longestBalanced(String s) {
        int ans=0,val;
        boolean flag;
        int[] track;
        for(int i=0;i<s.length();i++){
            track = new int[26];
            for(int j=i;j<s.length();j++){
                track[s.charAt(j)-'a']++;
                val=0; flag = true;
                for(int k=0;k<26;k++){
                    if(track[k]!=0 && val==0){
                        val = track[k];
                    }else if(track[k]!=0 && track[k]!=val){
                        // System.out.println(val);
                        flag = false; break;
                    }
                }
                if(flag){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}