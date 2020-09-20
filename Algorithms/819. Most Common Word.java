class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ");
        //System.out.println(paragraph);
        
        String[] list = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String str : list) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        String ans = "";
        int max = 0;
        Set<String> set = new HashSet<>();
        for (String str : banned) {
            set.add(str);
        }
        
        for (String str : map.keySet()) {
            int current = map.get(str);
            if (set.contains(str) || str.length() == 0) {
                continue;
            }
            if (current > max) {
                max = current;
                ans = str;
            }
        }
        return ans;
    }
}