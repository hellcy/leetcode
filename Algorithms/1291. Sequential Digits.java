class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        
        int num = 0;
        int start = 1, length = 2;
        while (num < low) {
            num = getnext(start, length);
            start++;
            if (start == 9 - length + 2) {
                start = 1;
                length++;
            }
        }
        
        while (num >= low && num <= high) {
            list.add(num);
            num = getnext(start, length);
            start++;
            if (start == 9 - length + 2) {
                start = 1;
                length++;
            }
        }
        
        return list;
    }
    
    private int getnext(int start, int length) {
        int num = start;
        while (length > 1) {
            num = num * 10;
            start++;
            num += start;
            length--;
        }
        
        return num;
    }
    
}