class Solution {
    public int totalMoney(int n) {
        int count = n / 7;
        int start = count + 1;
        int base = (int)((1 + 7) * 7 / 2.0);
        int ans = 0;
        for (int i = 0; i < count; ++i) {
            ans += base + i * 7;
        }
        
        int remain = n % 7;
        for (int i = 0; i < remain; ++i) {
            ans += start + i * 1;
        }
        
        return ans;
    }
}