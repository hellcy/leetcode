class Solution {
    public int getLucky(String s, int k) {
        // simulation
        int num = 0;
        for (char c : s.toCharArray()) {
            int current = (c - 'a') + 1;
            num += transform(current);
            //System.out.println(num);
        }
        k--;
        
        //System.out.println(num);
        
        while (k > 0) {
            num = transform(num);
            k--;
        }
        
        return num;
    }
    
    private int transform(int num) {
        int ans = 0;
        while (num > 9) {
            ans += num % 10;
            num /= 10;
        }
        ans += num;
        return ans;
    }
}