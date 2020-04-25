class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        /*
            Binary Search
                do a binary search for each house
        */
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int radius = -1;
        for (int i = 0; i < houses.length; ++i) {
            int low = 0;
            int high = heaters.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (houses[i] < heaters[mid]) {
                    high = mid - 1;
                } else if (houses[i] > heaters[mid]) {
                    low = mid + 1;
                } else {
                    break;
                }
            }
            if (low < 1) radius = Math.max(radius, heaters[low] - houses[i]);
            else if (low > heaters.length - 1) radius = Math.max(radius, houses[i] - heaters[low - 1]);
            else radius = Math.max(radius, Math.min(heaters[low] - houses[i], houses[i] - heaters[low - 1]));
        }
        return radius;
    }
}