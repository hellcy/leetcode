class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        /*
            Algorithm explained:
                create two pointers, slow and fast
                if value not equal to next value
                    check if difference between fast and slow is more than 3, add array to ans
                    move slow and fast pointer to current's next
                if equal
                    fast pointer++
                
        */
        List<List<Integer>> result = new ArrayList();
        
        int slow = 0;
        int fast = 0;
        int N = S.length();
        
        while (fast < N) {
            if (fast == N - 1 || S.charAt(fast) != S.charAt(fast + 1)) {
                if (fast - slow + 1 >= 3) {
                    result.add(Arrays.asList(new Integer[]{slow, fast}));
                }
                slow = fast + 1;
            }
            fast++;
        }

        return result;
    }
}