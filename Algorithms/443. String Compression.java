class Solution {
    public int compress(char[] chars) {
        /*
            String
            Array
                keep to track of the index while go through the array
                count could be more than 10 times so we need to convert it to char array and add it one by one
        */
        if (chars.length == 1) return 1;
        int count = 1;
        int size = 1;
        int index = 1;
        for (int i = 1; i < chars.length; ++i) {
            if (chars[i - 1] == chars[i]) {
                count++;
            } else {
                if (count != 1) {
                    char[] numbers = Integer.toString(count).toCharArray();
                    for (char c : numbers) {
                        chars[index] = c;
                        index++;
                        size++;
                    }
                }
                chars[index] = chars[i];
                index++;
                size++;
                count = 1;
            }
        }
        
        if (count != 1) {
            char[] numbers = Integer.toString(count).toCharArray();
            for (char c : numbers) {
                chars[index] = c;
                index++;
                size++;
            }   
        }
        
        return size;
    }
}