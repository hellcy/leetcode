class Solution {
    public int romanToInt(String s) {
        /*
            Math
                first add then substrct double of it
        */
        int number = 0;
        int prev = 1000;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'I') {
                number += 1;
                prev = 1;
            } else if (s.charAt(i) == 'V') {
                number += 5;
                if (prev < 5) number -= 2;
                prev = 5;
            } else if (s.charAt(i) == 'X') {
                number += 10;
                if (prev < 10) number -= 2;
                prev = 10;
            } else if (s.charAt(i) == 'L') {
                number += 50;
                if (prev < 50) number -= 20;
                prev = 50;
            } else if (s.charAt(i) == 'C') {
                number += 100;
                if (prev < 50) number -= 20;
                prev = 100;
            } else if (s.charAt(i) == 'D') {
                number += 500;
                if (prev < 500) number -= 200;
                prev = 500;
            } else if (s.charAt(i) == 'M') {
                number += 1000;
                if (prev < 500) number -= 200;
                prev = 1000;
            }
             
        }
        return number;
    }
}