// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] juice, int[] capacity) {
        // write your code in Java SE 8
        int n = juice.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
          arr[i] = juice[i];
        }
    
        Arrays.sort(arr);
    
        Map<Integer, Integer> map = new HashMap<>();
        int maxleft = -1, maxjuice = capacity[0] - juice[0];
        for (int i = 0; i < n; ++i) {
          int left = capacity[i] - juice[i];
          maxleft = Math.max(maxleft, left);
          if (i > 0) {
            if (capacity[i] > capacity[i - 1] && juice[i] >= juice[i - 1]) {
              maxjuice = capacity[i] - juice[i];
            }
          }
          if (!map.containsKey(left)) {
            map.put(left, juice[i]);
          } else if (map.get(left) < juice[i]) {
            map.put(left, juice[i]);
          }
        }
        
        int max = 1;
        int curjuice = map.get(maxleft);
        boolean flag = false;
        int cur = 1;
        for (int j = 0; j < n; ++j) {
          if (!flag && curjuice == arr[j]) {
            flag = !flag;
            continue;
          }
          if (maxleft < arr[j]) {
            break;
          } else {
            cur++;
            maxleft -= arr[j];
          }
        }
        max = Math.max(max, cur);
    
        curjuice = map.get(maxjuice);
        flag = false;
        cur = 1;
        for (int j = 0; j < n; ++j) {
          if (!flag && curjuice == arr[j]) {
            flag = !flag;
            continue;
          }
          if (maxjuice < arr[j]) {
            break;
          } else {
            cur++;
            maxjuice -= arr[j];
          }
        }
        max = Math.max(max, cur);
    
        return max;
    }
}