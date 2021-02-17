class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        /*
            divide and conquer + DFS + binary search
            1. divide the array into two subarrays with equal sizes.
            2. calculate all subsequences sums for the two subarrays (DFS or DP)
            3. sort the first subarray
            4. for each numB in second subarray, use binary search in the first subarray to find the numA that closest to (goal - numB)

            Time Complexity: 
            n: length of nums
            1. calculate sum of all subsequences: O(2^(n/2))
            2. perform binary search (2^(n/2)) times: O(2^(n/2) * log(2^(n/2))) -> O((n/2) * 2^(n/2)) -> O(n * 2^(n/2))
            total: O(n * 2^(n/2))
        */

        int n = nums.length;
        Set<Integer> first = new TreeSet<>();
        Set<Integer> second = new HashSet<>();
        //dfs(first, nums, 0, n / 2, 0);
        //dfs(second, nums, n / 2, n, 0);
        dp(first, nums, 0, n / 2);
        dp(second, nums, n / 2, n);

        int[] array = new int[first.size()];
        int index = 0;
        for (int i : first) {
            array[index] = i;
            index++;
        }

        int ans = Integer.MAX_VALUE;
        // perform binary search 2^(n/2) times
        for (int i : second) {
            int left = 0, right = array.length - 1;
            int target = goal - i;
            while (left + 1 < right) {
                int mid = (right - left) / 2 + left;
                if (array[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            ans = Math.min(ans, Math.min(Math.abs(array[right] - target), Math.abs(array[left] - target)));
        }

        return ans;
    }

    // DFS: calculate sums of all subsets for an array
    private void dfs(Set<Integer> list, int[] nums, int start, int end, int sum) {
        if (start == end) {
            list.add(sum);
            return;
        } else {
            dfs(list, nums, start + 1, end, sum);
            dfs(list, nums, start + 1, end, sum + nums[start]);
        }
    }

    // DP: calculate sums of all subsets for an array
    private void dp(Set<Integer> list, int[] nums, int start, int end) {
        list.add(0);
        for (int i = start; i < end; ++i) {
            Set<Integer> extra = new HashSet<>();
            for (int j : list) {
                extra.add(j + nums[i]);
            }
            for (int j : extra) {
                list.add(j);
            }
        }
    }
}