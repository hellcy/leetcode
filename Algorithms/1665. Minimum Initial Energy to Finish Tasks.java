class Solution {
    public int minimumEffort(int[][] tasks) {
        /*
            Greedy + Binary Search
            Choose the task which has the larger difference between requirement and spend to finish first
            Use Bianry search to find minimum required value
        */
        Arrays.sort(tasks, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (b[1] - b[0]) - (a[1] - a[0]);
            }
        });

        int low = 0, high = 0;
        for (int[] arr : tasks) {
            low += arr[0];
            high += arr[1];
        }
        
        while (low + 1 < high) {
            int mid = (high - low) / 2 + low;
            if (helper(mid, tasks)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if (helper(low, tasks)) return low;
        else if (helper(high, tasks)) return high;
        return high;
    }

    private boolean helper(int num, int[][] tasks) {
        for (int[] arr : tasks) {
            if (num < arr[1]) {
                return false;
            }
            num -= arr[0];
        }

        return true;
    }
}