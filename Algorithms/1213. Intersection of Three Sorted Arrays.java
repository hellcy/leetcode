class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        /*
            Two Pointers
        */
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;
        int point1 = 0, point2 = 0, point3 = 0;
        int max = Math.max(arr1[n1 - 1], Math.max(arr2[n2 - 1], arr3[n3 - 1]));
        
        int current = 1;
        
        List<Integer> list = new ArrayList<>();
        while (point1 < n1 && point2 < n2 && point3 < n3 && current <= max) {
            if (arr1[point1] == current && arr2[point2] == current && arr3[point3] == current) {
                list.add(arr1[point1]);
                point1++;
                point2++;
                point3++;
            } else if (arr1[point1] >= current && arr2[point2] >= current && arr3[point3] >= current) {
                current++;
            } else {
                if (arr1[point1] < current) point1++;
                if (arr2[point2] < current) point2++;
                if (arr3[point3] < current) point3++;
            }
        }
        
        return list;
    }
}