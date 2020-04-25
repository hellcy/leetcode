class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        /*
            Math
        */
        int count = 1, total = 0;
        
        while (total < candies) {
            total += count;
            count++;
        }
        count--;
        //System.out.println(count);
        int row = (count - 1) / num_people;
        int left = count - row * num_people;
        int leftCandies = count - (total - candies);
        
        int[] array = new int[num_people];
        int number = 0;
        for (int i = 0; i < row; ++i) {
            number += i;
        }
        
        for (int i = 0; i < array.length; ++i) {
            array[i] = row * (i + 1) + number * num_people;
        }
        
        for (int i = 0; i < left - 1; ++i) {
            array[i] += count - left + 1 + i;
        }
        
        array[left - 1] += leftCandies;
        return array;
    }
}