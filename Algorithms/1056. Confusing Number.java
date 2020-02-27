class Solution {
    public boolean confusingNumber(int N) {
        /*
            Math
        */
        int number = 0;
        int originNumber = N;
        while (N >= 1) {
            int pos = N % 10;
            if (pos == 2 || pos == 3 || pos == 4 || pos == 5 || pos == 7) return false;
            
            if (pos == 6) pos = 9;
            else if (pos == 9) pos = 6;
            
            if (number == 0) number += pos;
            else number = number* 10 + pos;
            
            N /= 10;
        }
        //System.out.println(number + " " + originNumber);
        if (number != originNumber) return true;
        else return false;
    }
}