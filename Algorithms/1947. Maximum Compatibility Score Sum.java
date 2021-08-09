class Solution {
    // backtracking
    int max = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        Set<Integer> visited = new HashSet<>();
        
        helper(students, mentors, visited, 0, 0);
        return max;
    }
    
    private void helper(int[][] students, int[][] mentors, Set<Integer> visited, int index, int sum) {
        if (visited.size() == mentors.length) {
            if (sum > max) {
                max = sum;
            }
        } else {
            for (int i = 0; i < mentors.length; ++i) {
                if (visited.contains(i)) continue;
                visited.add(i);
                helper(students, mentors, visited, index + 1, sum + helpersum(students[index], mentors[i]));
                visited.remove(i);
            }
        }
    }
    
    private int helpersum(int[] student, int[] mentor) {
        int result = 0;
        for (int i = 0; i < student.length; ++i) {
            if (student[i] == mentor[i]) result++;
        }
        return result;
    }
}