class LRUCache {
    /*
        HashMap + Doubly Linked List
    */
    class Dnode {
        int key;
        int val;
        Dnode prev;
        Dnode next;
        Dnode(int key, int val) {this.key = key; this.val = val;}
    }
    
    public void addNode(Dnode node) {
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
    
    public void removeNode(Dnode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    Map<Integer, Dnode> map;
    int capacity;
    Dnode dummy, tail;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        dummy = new Dnode(-1, -1);
        tail = new Dnode(-1, -1);
        tail.prev = dummy;
        dummy.next = tail;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Dnode node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        //System.out.println(map.size());
        // first check if it is a new key, or old key
        if (map.containsKey(key)) {
            Dnode node = map.get(key);
            node.val = value;
            removeNode(node);
            addNode(node);
        } else {
            if (map.size() == capacity) {
                Dnode node = dummy.next;
                removeNode(node);
                map.remove(node.key);
            }
            
            Dnode newnode = new Dnode(key, value);
            addNode(newnode);
            map.put(key, newnode);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */