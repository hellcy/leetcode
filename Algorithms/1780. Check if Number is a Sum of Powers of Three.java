class Solution {
    boolean ans = false;
    public boolean checkPowersOfThree(int n) {
        /*
            DFS
            store all possible values in a list 
            calculate all combinations
        */

        List<Integer> list = new ArrayList<>();
        int index = 0;
        int value = 1;
        while (value <= n) {
            value = (int)Math.pow(3, index);
            list.add(value);
            index++;
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }

        dfs(arr, 0, n, 0);
        return ans;
    }

    private void dfs (int[] arr, int index, int n, int sum) {
        if (ans) return;
        if (index >= arr.length) return;
        if (sum == n) {
            ans = true;
            return;
        }

        for (int i = index; i < arr.length; ++i) {
            sum += arr[i];
            dfs(arr, i + 1, n,  sum);
            sum -= arr[i];
        }
    }
}