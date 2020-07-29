class BrowserHistory {
    class Dnode {
        String value;
        int index;
        Dnode prev;
        Dnode next;
        Dnode(int index, String value) {
            this.value = value;
            this.index = index;
        }
    }
    
    public void addnode(Dnode node) {
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
    public void removeNode(Dnode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    Dnode head, tail;
    Map<Integer, Dnode> map;
    int currentIndex;
    int maxIndex;
    public BrowserHistory(String homepage) {
        map = new HashMap<>();
        head = new Dnode(-1, "");
        tail = new Dnode(-1, "");
        head.next = tail;
        tail.prev = head;
        currentIndex = 0;
        maxIndex = 0;
        Dnode newnode = new Dnode(0, homepage);
        map.put(0, newnode);
        addnode(newnode);
    }
    
    public void visit(String url) {
        Dnode current = map.get(currentIndex);
        current.next = tail;
        tail.prev = current;
        
        currentIndex++;
        maxIndex = currentIndex;
        Dnode newnode = new Dnode(currentIndex, url);
        map.put(currentIndex, newnode);
        addnode(newnode);
    }
    
    public String back(int steps) {
        int targetIndex = currentIndex - steps;
        if (targetIndex < 0) targetIndex = 0;
        Dnode ans = map.get(targetIndex);
        currentIndex = targetIndex;
        return ans.value;
    }
    
    public String forward(int steps) {
        int targetIndex = currentIndex + steps;
        if (targetIndex > maxIndex) targetIndex = maxIndex;
        Dnode ans = map.get(targetIndex);
        currentIndex = targetIndex;
        return ans.value;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */