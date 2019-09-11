class Solution {
    public int shipWithinDays(int[] weights, int D) {
        /*
            Binary Search
                weight capacity range from max weight in the array to the sum of the array
                calculate days from each middle in the range
                if days > D, we know weight must be higher than mid and vice versa
        */
        int sum = 0;
        int max = 0;
        for (int i = 0; i < weights.length; ++i) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        
        int low = Math.max((int)Math.ceil(sum / D), max);
        int high = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //System.out.println("mid" + mid + " " + low + " " + high);
            int days = check(weights, mid);
            if (days > D) {
                low = mid + 1;
            } else if (days <= D) {
                high = mid - 1;
            }
        }
        return low;
    }
    
    private int check(int[] weights, int mid) {
        int days = 1;
        int currentsum = 0;

        for (int i = 0; i < weights.length; ++i) {
            //System.out.println(days + " " + mid + " " + currentsum);
            currentsum += weights[i];
            if (currentsum > mid) {
                days++;
                currentsum = weights[i];
            }
        }
        return days;
    }
}