class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles, left = numBottles;
        while (left >= numExchange) {
            count += left / numExchange;
            left = left / numExchange + left % numExchange;
        }
        
        return count;
    }
}