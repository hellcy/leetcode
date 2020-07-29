class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list = getFactors(n);
        if (list.size() < k) return -1;
        return list.get(k - 1);
    }
    
    private List<Integer> getFactors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                list.add(i);
                int other = n / i;
                if (other != i) {
                    list.add(other);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}