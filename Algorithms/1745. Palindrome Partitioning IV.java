class Solution {
    public boolean checkPartitioning(String s) {
        /*
            save all palindrome substring into a 2d boolean matrix
            use hashmap to find all possible palindrome count for each substring
            note we only need to count the value less than 3 in the set.

            O(3N^2)
        */
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];

        getPalin(isPalin, s);
        // Map<Integer, Set<Integer>> map = new HashMap<>();
        // Set<Integer> set = new HashSet<>();
        // set.add(0);
        // map.put(0, set);
        // for (int i = 1; i <= n; ++i) {
        //     map.put(i, new HashSet<>());
        //     for (int j = 0; j < i; ++j) {
        //         if (isPalin[j][i - 1] && map.get(i).size() < 3) {
        //             for (int k : map.get(j)) {
        //                 if (k < 3) map.get(i).add(k + 1);
        //             }
        //         }
        //     }
        // }

        // return map.get(n).contains(3);
        
        /*
            cut string into 3 part
            if all 3 parts are palindrome, return true
        */
        for (int i = 1; i < n - 1; ++i) {
            for (int j = i; j < n - 1; ++j) {
                if (isPalin[0][i - 1] && isPalin[i][j] && isPalin[j + 1][n - 1]) return true;
            }
        }
        return false;
    }

    private void getPalin(boolean[][] isPalin, String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n - 1; ++i) {
            int left = i, right = i + 1;
            while (left >= 0 && right < n && cs[left] == cs[right]) {
                isPalin[left][right] = true;
                left--;
                right++;
            }
        }

        for (int i = 0; i < n; ++i) {
            int left = i, right = i;
            while (left >= 0 && right < n && cs[left] == cs[right]) {
                isPalin[left][right] = true;
                left--;
                right++;
            }
        }
    }
}