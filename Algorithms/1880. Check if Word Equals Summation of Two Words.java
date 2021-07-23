class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int firstValue = 0;
        int secondValue = 0;
        int target = 0;
        
        for (char c : firstWord.toCharArray()) {
            firstValue *= 10;
            firstValue += (c - 'a');
        }
        
        for (char c : secondWord.toCharArray()) {
            secondValue *= 10;
            secondValue += (c - 'a');
        }
        
        //System.out.println(firstValue + " " + secondValue);
        int value = firstValue + secondValue;
        
        for (char c : targetWord.toCharArray()) {
            target *= 10;
            target += (c - 'a');
        }
        
        //System.out.println(target);

        return value == target;
    }
}