class Solution {
    /*
        Backtracking
    */
    int count = 0;
    int[] array;
    public int numTeams(int[] rating) {
        array = rating;
        List<Integer> list = new ArrayList<>();
        helper(0, 0, list);
        return count;
    }
    
    private void helper(int number, int start, List<Integer> list) {
        if (number == 3) {
            //System.out.println(list);
            if (list.get(0) < list.get(1) && list.get(1) < list.get(2)) count++;
            else if (list.get(0) > list.get(1) && list.get(1) > list.get(2)) count++;
        } else {
            for (int i = start; i < array.length; i++) {
                list.add(array[i]);
                helper(number + 1, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}