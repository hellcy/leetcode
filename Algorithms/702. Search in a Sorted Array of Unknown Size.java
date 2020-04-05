/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        /*
            Bianry Search
                when we don't know the length of the array, 
                we can double the index everytime and check if target is smaller than it
                so we use O(logn) to find the length that has to contain target
                can another O(logn) to find the index
                Total running time is still O(logn)
                
                In CS, we create ArrayList in this way (Dynamic array)
        */
        int end = 1;
        while (reader.get(end) < target) {
            end = end * 2;
        }
        
        
        int start = end / 2;
        
        while (start +  1 < end) {
            int mid = (end - start) / 2 + start;
            //System.out.println(start + " " + end + " " + mid);
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                end = mid;
            } else start = mid;
        }
        
        if (reader.get(start) == target) return start;
        if (reader.get(end) == target) return end;
        
        return -1;
    }
}