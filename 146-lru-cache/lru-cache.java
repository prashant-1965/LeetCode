class KeyValue{
    public int key;
    public int val;
    public int wt;
    public KeyValue(int key, int val, int wt){
        this.key = key;
        this.val = val;
        this.wt = wt;
    }
}
class LRUCache {
    public int last;
    public int limit;
    public int cur;
    public TreeSet<KeyValue> set;
    public Map<Integer,KeyValue> map;
    public LRUCache(int cap) {
        this.set = new TreeSet<>((a,b)->{
            return Integer.compare(a.wt,b.wt);
        });
        this.map = new HashMap<>();
        this.last=0;
        this.limit = cap;
        this.cur = 0;
    }
    
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        KeyValue temp = map.get(key);
        int ans = temp.val;
        set.remove(temp);
        KeyValue adrr = new KeyValue(key,ans,++last);
        set.add(adrr);
        map.remove(key);
        map.put(key,adrr);
        return ans;

    }
    
    public void put(int k, int v) {
        if(map.containsKey(k)){
            KeyValue temp = map.get(k);
            set.remove(temp);
            map.remove(k);
            cur--;
        }
        if(cur==limit){
            KeyValue adr = set.pollFirst();
            map.remove(adr.key);
            cur--;
        }
        KeyValue temp2 = new KeyValue(k,v,++last);
        map.put(k,temp2);
        set.add(temp2);
        cur++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */