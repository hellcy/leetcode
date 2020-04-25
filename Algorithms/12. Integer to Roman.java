class Solution {
    public String intToRoman(int num) {
        /*
            Brute force
        */
        String ans = "";
        while (num >= 1) {
            if (num >= 1000) {
                ans += "M";
                num -= 1000;
            } else if (num < 1000 && num >= 900) {
                ans += "CM";
                num -= 900;
            } else if (num < 900 && num >= 500) {
                ans += "D";
                num -= 500;
            } else if (num < 500 && num >= 400) {
                ans += "CD";
                num -= 400;
            } else if (num < 400 && num >= 100) {
                ans += "C";
                num -= 100;
            } else if (num < 100 && num >= 90) {
                ans += "XC";
                num -= 90;
            } else if (num < 90 && num >= 50) {
                ans += "L";
                num -= 50;
            } else if (num < 50 && num >= 40) {
                ans += "XL";
                num -= 40;
            } else if (num < 40 && num >= 10) {
                ans += "X";
                num -= 10;
            } else if (num < 10 && num >= 9) {
                ans += "IX";
                num -= 9;
            } else if (num < 9 && num >= 5) {
                ans += "V";
                num -= 5;
            } else if (num < 5 && num >= 4) {
                ans += "IV";
                num -= 4;
            } else if (num < 4 && num >= 1) {
                ans += "I";
                num -= 1;
            }
        }
        return ans;
        
        /*
            Using String array
        */
//         // List all the possible roman numberial values
//         int[] romanValue = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
//         String[] romanCharacters = new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
//         String solution = "";
        
//         for(int i = 0; i < romanValue.length; i++){
//             // We are going to determine how many times each roman numerial can be used in a single iteration
//             int repeat = num / romanValue[i];
            
//             // The remainder become the new value
//             num = num % romanValue[i];
            
//             // Adding the repeation to the result
//             for(int j = 0; j < repeat; j++){
//                 solution += romanCharacters[i];
//             }
            
//         }
        
//         return solution;
    }
}