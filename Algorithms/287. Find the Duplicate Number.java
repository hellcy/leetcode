class Solution {
    public int findDuplicate(int[] nums) {
        /*
            Method 1: Brute force
                compare each pair of numbers
        */
        // for (int i = 0; i < nums.length; ++i) {
        //     for (int j = i + 1; j < nums.length; ++j) {
        //         if (nums[i] == nums[j]) return nums[j]; 
        //     }
        // }
        
        /*
            Method 2: Sort
                duplicate numbers now should be together
        */
        // Arrays.sort(nums);
        // for (int i = 1; i < nums.length; ++i) {
        //     if (nums[i] == nums[i - 1]) return nums[i];
        // }
        
        /*
            Method 3: HashSet
                return number if it is already found in the set
        */
        // Set<Integer> set = new HashSet<>();
        // for (int i : nums) {
        //     if (!set.contains(i)) set.add(i);
        //     else return i;
        // }
        
        /*
            Method 4: think array as linked list with cycle
                If we interpret nums such that for each pair of index i and value v_i, 
                the "next" value v_j is at index v_i, 
                we can reduce this problem to cycle detection. 
                See the solution to Linked List Cycle II for more details.
                
                First use fast and slow pointers to find the intersection in the cycle,
                Then move fast pointer to the begining and move with the same speed as slow pointer 
                to find the entrance of cycle
                
                Becasue intersection might not be the correct answer, 
                intersection could be any point in the cycle
                only the entry of the loop means that there are at least 2 pointers point to it.
                According to the rule value v_i will point to index v_i that has a value v_j, 
                both pointers will have the same value v_i, 
                which is the duplicate value in the array.
        */
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // find the entrance of cycle
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}