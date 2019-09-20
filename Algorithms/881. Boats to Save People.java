class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /*
            Two Pointers
                create two pointers start from left and right
                if their sum is greater than limit, we need one boat for the heavier people, right--
                if their sum is smaller than limit, we can use ont boat for both of them, right--, left++
                until we finish the whole array
        */
        if (people.length == 1) return people.length;
        Arrays.sort(people);
        
        int count = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                right--;
            } else {
                left++;
                right--;
            }
            count++;
        }
        return count;
    }
}