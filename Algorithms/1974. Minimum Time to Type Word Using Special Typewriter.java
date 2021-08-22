class Solution {
    public int minTimeToType(String word) {
        int count = 0;
        char current = 'a';
        for (char c : word.toCharArray()) {
            if (current - c > 0) {
                count += Math.min(current - c, c + 26 - current);
            } else {
                count += Math.min(c - current, current + 26 - c);
            }
            
            current = c;
            count++;
            //System.out.println(count);
        }
        
        return count;
    }
}