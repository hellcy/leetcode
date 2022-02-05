class Solution {
    public String[] divideString(String s, int k, char fill) {
        int length = s.length();
        List<String> list = new ArrayList<>();
        int index = 0;
        
        while (index + k <= length) {
            list.add(s.substring(index, index + k));
            index += k;
        }
        
        
        if (index == length) {
            String[] ans = new String[list.size()];
            for (int i = 0; i < ans.length; ++i) {
                ans[i] = list.get(i);
            }
            
            return ans;
        }
        
        StringBuilder left = new StringBuilder(s.substring(index, length));
        
        for (int i = length - index; i < k; ++i) {
            left.append(fill);
        }
        
        list.add(left.toString());
        String[] ans = new String[list.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}\