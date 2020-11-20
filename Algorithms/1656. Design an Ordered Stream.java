class OrderedStream {
    Map<Integer, String> map;
    int pointer;
    int max;
    public OrderedStream(int n) {
        pointer = 1;
        map = new HashMap<>();
        max = n;
    }
    
    public List<String> insert(int id, String value) {
        map.put(id, value);
        List<String> ans = new ArrayList<>();
        if (id == pointer) {
            while (map.containsKey(pointer) && pointer <= max) {
                ans.add(map.get(pointer));
                pointer++;
            }
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */