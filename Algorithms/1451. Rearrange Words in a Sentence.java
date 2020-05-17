class Solution {
    public String arrangeWords(String text) {
        /*
            HashMap
        */
        Map<Integer, List<String>> map = new HashMap<>();
        text = Character.toString(Character.toLowerCase(text.charAt(0))) + text.substring(1);
        
        String[] array = text.split(" ");
        for (String str : array) {
            int length = str.length();
            if (!map.containsKey(length)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(length, list);
            } else {
                map.get(length).add(str);
            }
        }
        
        //System.out.println(map);
        String ans = "";
        
        for (int length : map.keySet()) {
            for (String str : map.get(length)) {
                ans += str + " ";
            }
        }
        ans = Character.toString(Character.toUpperCase(ans.charAt(0))) + ans.substring(1);

        return ans.substring(0, ans.length() - 1);
    }
}