class Solution {
    public int countLargestGroup(int n) {
        /*
            HashMap
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 1; i <= n; ++i) {
            int sum = helper(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        int ans = 0, max = 0;
        //System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = 1;
            } else if (entry.getValue() == max) {
                ans++;
            }
        }
        
        return ans;
    }
    
    private int helper(int n) {
        int sum = 0;
        while (n >= 1) {
            sum += n % 10;
            n /= 10;
        }
        
        return sum;
    }
}