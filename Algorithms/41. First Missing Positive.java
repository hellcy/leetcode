class Solution {
    public int firstMissingPositive(int[] nums) {
        /*
            Priority Queue
            Set
        */
        int size = nums.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> x - y);
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < size; ++i) {
            if (nums[i] > 0 && !set.contains(nums[i])) {
                set.add(nums[i]);
                heap.add(nums[i]);
            }
        }
                
        if (heap.size() == 0 || heap.peek() > 1) return 1;
        
        int number = 0, check = 0;
        while (!heap.isEmpty()) {
            number = heap.poll();
            if (number != check + 1) return check + 1; 
            check = number;
        }
        return number + 1;
    }
}