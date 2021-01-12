class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int zero = 0, one = 0;
        for (int i : students) {
        	if (i == 1) one++;
        	else zero++;
        }

        for (int i : sandwiches) {
        	if (i == 1) {
        		if (one == 0) break;
        		one--;
        	}
        	else {
        		if (zero == 0) break;
        		zero--;
        	}
        }

        return one + zero;
    }
}