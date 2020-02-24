class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*
            Brute force
        */
//         int[] ans = new int[nums1.length];
        
//         for (int i = 0; i < nums1.length; ++i) {
//             boolean flag = false;
//             for (int j = 0; j < nums2.length; ++j) {
//                 if (nums2[j] == nums1[i]) flag = true;
                
//                 if (flag) {
//                     if (nums2[j] > nums1[i]) {
//                         ans[i] = nums2[j];
//                         break;
//                     }
//                 }
                
//                 if (j == nums2.length - 1) ans[i] = -1;
//             }
//         }
        
//         return ans;
        
        /*
            Mono Stack
            HashMap
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
    
        for (int i : nums2) {
            while (!stack.empty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            
            stack.add(i);
        }
        
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }
        
        //System.out.println(map);
        
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}