class Solution {
    public String simplifyPath(String path) {
        /*
            String
        */
        int level = 0;
        String simplepath = "";
        List<String> list = new ArrayList<>();
        String[] array = path.split("/");
        for (int i = 0; i < array.length; ++i) {
            //System.out.println(array[i]);
            if (array[i].length() == 0) continue;
            if (array[i].charAt(0) == '.') {
                if (array[i].length() == 2) {
                    if (list.size() >= 1) {
                        list.remove(list.size() - 1);
                    }
                } else if (array[i].length() > 2) {
                    list.add(array[i]);
                }
            } else {
                list.add(array[i]);
            }
            
        }
        
        for (String i : list) {
            simplepath += "/" + i;
        }
        return (simplepath.length() == 0) ? "/" : simplepath;
    }
}