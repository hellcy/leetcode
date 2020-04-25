class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        /*
            split two disjoint subsequences A and B, while trying to minimize depths of both A and B
            so make sure both A and B wouldn't exceed max depth / 2
            keep tracking of the depths of current index
                start at max depth, so the inner most parenthese will be depth 1,
                outer most parentheses will be depth max
            assign zero to indices where depth < max / 2
            and one to indices where depth > max / 2
        */
        int[] ans = new int[seq.length()];
        int[] depths = new int[seq.length()];
        int depth = 0;
        int max = 0;
        for (int i = 0; i < seq.length(); ++i) {
            if (seq.charAt(i) == '(') depth++;
            else depth--;
            max = Math.max(max, depth);
        }
        
        depth = max;

        for (int i = 0; i < seq.length(); ++i) {
            if (seq.charAt(i) == '(') depth--;
            else depth++;
            
            depths[i] = depth;
            //System.out.print(depths[i] + " ");
        }
        
        
        int limit = max / 2;
        for (int i = 0; i < seq.length(); ++i) {
            if (seq.charAt(i) == '(' && depths[i] < limit) ans[i] = 0;
            else if (seq.charAt(i) == ')' && depths[i] <= limit) ans[i] = 0;
            else ans[i] = 1;
        }
        
        return ans;
    }
}