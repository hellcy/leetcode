class FirstUnique {
    /*
        add number to the first set, then if a same number comes in, add it to the second set.
        Unique numbers will be the numbers in the first set, but not in the second set.
    */
    Queue<Integer> queue;
    Set<Integer> set;
    Set<Integer> notunique;
    public FirstUnique(int[] nums) {
        queue = new LinkedList<>();
        set =  new HashSet<>();
        notunique = new HashSet<>();
        for (int i : nums) {
            queue.add(i);
            if (!set.contains(i)) {
                set.add(i);
            } else {
                notunique.add(i);
;            }
        }
    }
    
    public int showFirstUnique() {
        while (!queue.isEmpty()) {
            int value = queue.peek();
            if (set.contains(value) && !notunique.contains(value)) {
                return value;
            } else {
                queue.poll();
            }
        }
        return -1;
    }
    
    public void add(int value) {
        queue.add(value);
        if (!set.contains(value)) {
            set.add(value);
        } else {
            notunique.add(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */