class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> lt = new ArrayList<>();
        String last,current;
        StringBuilder sb;
        char[] ch;
        ch = words[0].toCharArray();
        Arrays.sort(ch);
        last = new String(ch);
        lt.add(words[0]);
        for(int i=1;i<words.length;i++){
            ch = words[i].toCharArray();
            Arrays.sort(ch);
            current = new String(ch);
            if(!last.equals(current)){
                lt.add(words[i]);
                last = current;
            }

        }
        return lt;
    }
}