class MyHashMap {
    
    List<int[]> lists;
    /** Initialize your data structure here. */
    public MyHashMap() {
        lists = new ArrayList<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int[] newarray = {key, value};
        for (int i = 0; i < lists.size(); ++i) {
            if (lists.get(i)[0] == key) {
                lists.set(i, newarray);
                return;
            }
        }
        
        lists.add(newarray);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for (int[] array : lists) {
            if (array[0] == key) return array[1];
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for (int[] array : lists) {
            if (array[0] == key) {
                lists.remove(array);
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */