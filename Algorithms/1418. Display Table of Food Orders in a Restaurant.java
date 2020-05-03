class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        /*
            HashMap
        */
        List<String> header = new ArrayList<>();
        List<Integer> table = new ArrayList<>();
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        
        for (int i = 0; i < orders.size(); ++i) {
            String food = orders.get(i).get(2);
            int tableNumber = Integer.valueOf(orders.get(i).get(1));
            if (!header.contains(food)) {
                header.add(food);
            }
            if (map.containsKey(tableNumber)) {
                Map<String, Integer> tempMap = map.get(tableNumber);
                tempMap.put(food, tempMap.getOrDefault(food, 0) + 1);
            } else {
                table.add(tableNumber);
                Map<String, Integer> newmap = new HashMap<>();
                newmap.put(food, 1);
                map.put(tableNumber, newmap);
            }
        }
        
        Collections.sort(header);
        header.add(0, "Table");
        //System.out.println(header);
        
        Collections.sort(table);
        
        List<List<String>> ans = new ArrayList<>();
        ans.add(header);
        
        for (int i = 0; i < table.size(); ++i) {
            String tableNumber = String.valueOf(table.get(i));
            Map<String, Integer> tempmap = map.get(Integer.valueOf(tableNumber));
            //System.out.println(tempmap);
            List<String> row = new ArrayList<>();
            row.add(tableNumber);
            for (int j = 1; j < header.size(); ++j) {
                //System.out.println(header.get(j));
                if (!tempmap.containsKey(header.get(j))) row.add("0");
                else row.add(String.valueOf(tempmap.get(header.get(j))));
            }
            ans.add(row);
        }
        return ans;
    }
}