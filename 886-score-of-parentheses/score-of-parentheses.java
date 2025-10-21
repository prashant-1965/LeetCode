class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> st= new Stack<>();
        int val1,val2;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==')' && st.peek().equals("(")){
                st.pop();
                st.add("1");
            }else if(c==')' && !st.peek().equals("(")){
                val1 = Integer.parseInt(st.pop());
                st.pop();
                val1 = val1*2;
                st.push(Integer.toString(val1));

            }
            else{
                st.push("(");
            }
            while(st.size()>=2 && !st.peek().equals("(")){
                val1 = Integer.parseInt(st.pop());
                if(st.peek().equals("(")){
                    st.add(Integer.toString(val1));
                    break;
                }
                val2 = Integer.parseInt(st.pop());
                val1 = val1+val2;
                st.push(Integer.toString(val1));
            }
        }
        return Integer.parseInt(st.pop());
    }
}