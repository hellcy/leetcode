class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        while (label >= 1) {
            list.add(label);
            int row = 0, pos = 0;
            int num = label;
            int index = 0;
            while (num >= 1) {
                num -= Math.pow(2, index);
                if (num <= 0) break;
                row++;
                index++;
            }
            
            if ((row + 1) % 2 == 0) {
                pos = -num + 1;
            } else if ((row + 1) % 2 != 0) {
                pos = num + (int)Math.pow(2, index);
            }
            if (row == 0) break;
            label = prev(row + 1, pos);
            //System.out.println(label + " " + (row + 1) + " " + pos);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i : list) {
            ans.add(0, i);
        }
        
        return ans;
    }
    
    private int prev(int row, int pos) {
        int prevpos = 0;
        if (pos % 2 == 0) prevpos = pos / 2;
        else prevpos = pos / 2 + 1;
        
        int prevrow = row - 1;
        int prevlabel = 0;
        int index = 0;
        for (int i = 0; i < prevrow - 1; ++i) {
            prevlabel += (int)Math.pow(2, i);
        }
        
        if (prevrow % 2 == 0) {
            prevlabel += (int)Math.pow(2, prevrow - 1) - (prevpos - 1);
        } else {
            prevlabel += prevpos;
        }
        return prevlabel;
    }
}