class MyHashSet {
    /*
        HashSet
        Array
            fill array with -1, there is no test case with value -1
    */
    int[] set;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new int[1000000];
        Arrays.fill(set, -1);
    }
    
    public void add(int key) {
        set[key] = key;
    }
    
    public void remove(int key) {
        set[key] = -2;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (set[key] == key) return true;
        else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */