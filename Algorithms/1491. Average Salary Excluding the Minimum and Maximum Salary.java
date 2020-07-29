class Solution {
    public double average(int[] salary) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        int length = salary.length;
        double total = 0;
        for (int i : salary) {
            max = Math.max(max, i);
            min = Math.min(min, i);
            total += i;
        }
        
        return (total - max - min) / (length - 2);
    }
}