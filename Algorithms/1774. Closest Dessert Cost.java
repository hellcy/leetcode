class Solution {
    /*
        recursion
    */
    int ans = Integer.MAX_VALUE;
    boolean isNeg = false;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        Arrays.sort(toppingCosts);
        for (int i = 0; i < toppingCosts.length / 2; ++i) {
            int temp = toppingCosts[i];
            toppingCosts[i] = toppingCosts[toppingCosts.length - 1 - i];
            toppingCosts[toppingCosts.length - 1- i] = temp;
        }
        for (int i = 0; i < baseCosts.length; ++i) {
            dfs(toppingCosts, target - baseCosts[i], 0);
        }

        return isNeg ? target + ans : target - ans;
    }

    private void dfs(int[] toppingCosts, int target, int current) {
        //System.out.println(target + " " + isNeg);
        if (ans >= Math.abs(target)) {
            if (Math.abs(target) != ans || isNeg) {
                //System.out.println(target + " " + isNeg);
                ans = Math.abs(target);
                if (target < 0) isNeg = true;
                else isNeg = false;
            }
        }
        if (target < 0 && Math.abs(target) >= ans) return;
        else {
            if (current >= toppingCosts.length) return;
            for (int i = current; i < toppingCosts.length; ++i) {
                dfs(toppingCosts, target, current + 1);
                dfs(toppingCosts, target - toppingCosts[current], current + 1);
                dfs(toppingCosts, target - toppingCosts[current] * 2, current + 1);
            }
        }
    }
}