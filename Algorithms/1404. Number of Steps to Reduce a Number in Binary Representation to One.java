class Solution {
    public int numSteps(String s) {
        int count = 0;
        int[] array = new int[501];
        
        char[] cs = s.toCharArray();
        int length = 0;
        while (length < cs.length) {
            array[array.length - 1 - length] = (cs[cs.length - 1 - length] - '0');
            length++;
        }
        
        // for (int i = 0; i < 501; ++i) {
        //     System.out.print(array[i] + " ");
        // }
        
        boolean ok = false;
        for (int i = array.length - 1; i >= 0; --i) {
            int sum = 0;
            for (int j = 0; j <= i; ++j) {
                sum += array[j];
            }
            //System.out.println(sum + " " + i + " " + count + " " + ok);
            
            if (ok) {
                if (sum == 1 && i == array.length - cs.length - 1) break;
            } else {
                if (sum == 1 && i == array.length - cs.length) break;
            }

            
            if (array[i] == 0) {
                count++;
            } else {
                array[i] = 0;
                int pos = i - 1;
                while (pos >= 0) {
                    if (array[pos] == 1) {
                        array[pos] = 0;
                    } else {
                        if (pos < array.length - cs.length) ok = true;
                        array[pos] = 1;
                        break;
                    }
                    pos--;
                }
                count = count + 2;
            }
            //if (sum == 1 && i == array.length - cs.length) break;
        }
        return count;
    }
}