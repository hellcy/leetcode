class Solution {
    public int[][] indexPairs(String text, String[] words) {
        /*
            String
            PriorityQueue
                heap was used to sort the list
        */
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> (x[0] == y[0]) ? x[1] - y[1] : x[0] - y[0]);
        for (int i = 0; i < words.length; ++i) {
            int length = words[i].length();
            
            int left = 0, right = length;
            while (right <= text.length()) {
                if (text.substring(left, right).equals(words[i])) {
                    heap.add(new int[] {left, right - 1});
                }
                left++;
                right++;
            }
        }
        
        int[][] ans = new int[heap.size()][2];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}