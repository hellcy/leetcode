class FrontMiddleBackQueue {
    /*
        doubly linked list  
    */
    class DoublyNode {
        int val;
        DoublyNode next;
        DoublyNode prev;
        
        public DoublyNode(int value) {
            this.val = value;
        }
    }
    
    DoublyNode front;
    DoublyNode back;
    DoublyNode mid;
    int size;
    public FrontMiddleBackQueue() {
        size = 0;
        front = new DoublyNode(-1);
        back = new DoublyNode(-1);
        front.next = back;
        back.prev = front;
    }
    
    public void pushFront(int val) {
        DoublyNode node = new DoublyNode(val);
        DoublyNode temp = front.next;
        front.next = node;
        node.prev = front;
        node.next = temp;
        temp.prev = node;
        if (size == 0) mid = node;
        else if (size % 2 != 0) {
            mid = mid.prev;
        }
        size++;
    }
    
    public void pushMiddle(int val) {
        // add after the mid if size is even
        // add before the mid if size is odd
        DoublyNode node = new DoublyNode(val);
        if (size == 0) {
            mid = node;
            front.next = node;
            node.prev = front;
            node.next = back;
            back.prev = node;
        }
        else if (size % 2 == 0) {
            DoublyNode temp = mid.next;
            mid.next = node;
            node.prev = mid;
            node.next = temp;
            temp.prev = node;
        } else {
            DoublyNode temp = mid.prev;
            temp.next = node;
            node.prev = temp;
            node.next = mid;
            mid.prev = node;
        }
        mid = node;
        size++;
    }
    
    public void pushBack(int val) {
        DoublyNode node = new DoublyNode(val);
        DoublyNode temp = back.prev;
        temp.next = node;
        node.prev = temp;
        node.next = back;
        back.prev = node;
        if (size == 0) mid = node;
        else if (size % 2 == 0) {
            mid = mid.next;
        }
        size++;
    }
    
    public int popFront() {
        if (size == 0) return -1;
        DoublyNode node = front.next;
        int ans = node.val;
        node.next.prev = front;
        front.next = node.next;
        if (size % 2 == 0) {
            //System.out.println(mid.next.val);
            mid = mid.next;
        }
        size--;
        //System.out.println(ans);
        return ans;
    }
    
    public int popMiddle() {
        if (size == 0) return -1;
        DoublyNode before = mid.prev;
        DoublyNode after = mid.next;
        int ans = mid.val;
        before.next = after;
        after.prev = before;
        if (size % 2 == 0) {
            //System.out.println(mid.val);
            mid = mid.next;
        } else {
            //System.out.println(mid.val);
            mid = mid.prev;
        }
        size--;
        //System.out.println(ans);
        return ans;
    }
    
    public int popBack() {
        if (size == 0) return -1;
        DoublyNode node = back.prev;
        int ans = node.val;
        node.prev.next = back;
        back.prev = node.prev;
        if (size % 2 != 0) {
            //System.out.println(mid.val);
            mid = mid.prev;
        }
        size--;
        //System.out.println(ans);
        return ans;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */