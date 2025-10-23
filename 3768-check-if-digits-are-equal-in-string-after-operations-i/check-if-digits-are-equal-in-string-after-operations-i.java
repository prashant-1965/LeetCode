class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb;
        int last,val;
        while(s.length()>2){
            sb = new StringBuilder();
            for(int i=1;i<s.length();i++){
                last = s.charAt(i-1)-'0';
                val = s.charAt(i)-'0';
                sb.append((last+val)%10);
            }
            s = sb.toString();
        }
        return s.charAt(0)==s.charAt(1);
    }
}