class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        /*
            Brute force
                at certain position, if the number of people on the vehicle exceeded the capacity, we return false
                we know that the locations can only be as far as 1000,
                so for each postion from 0 to 1000
                we traverse all trips and add passengers to sum if the trips cover the current position
                return true if the sum never exceed capacity for all positions
        */
        for (int i = 0; i <= 1000; ++i) {
            int people = 0;
            for (int j = 0; j < trips.length; ++j) {
                if (trips[j][1] <= i && trips[j][2] > i) {
                    people += trips[j][0];
                }
            }
            if (people > capacity) return false;
        }
        return true;
    }
}