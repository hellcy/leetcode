class Solution {
    public int kthGrammar(int N, int K) {
        /*
            从后往前推 找到第N行第K个位置的数是由第N-1行第K/2 或者 K/2 + 1的数得来的
            由于每个数都会变成两个数 所以还要记录下是前面的数还是后面的数
            0 -> 前面的数
            1 -> 后面的数
            保存到list中
            推到第一行 然后list从后往前保存了从第一行到最后一行的选择
        */
        if (N == 1) return 0;
        
        List<Integer> list = new ArrayList<>();
        while (K > 1) {
            if (K % 2 == 0) {
                list.add(1);
                K = K / 2;
            } else {
                list.add(0);
                K = (K / 2) + 1;
            }
        }
        
        String str = "01";
        int ans = 0;
        for (int i = list.size() - 1; i >= 0; --i) {
            ans = str.charAt(list.get(i)) - '0';
            
            if (ans == 1) str = "10";
            else str = "01";
        }
        
        return ans;
    }
}