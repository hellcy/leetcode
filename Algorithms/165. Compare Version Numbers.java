class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        
        int length = Math.min(arr1.length, arr2.length);
        //System.out.println(length);
        for (int i = 0; i < length; ++i) {
            int v1 = Integer.valueOf(arr1[i]);
            int v2 = Integer.valueOf(arr2[i]);
            //System.out.println(v1 + " " + v2);
            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
        }
        
        if (arr2.length > length) {
            for (int i = length; i < arr2.length; ++i) {
                int v = Integer.valueOf(arr2[i]);
                if (v > 0) return -1;
            }
        }
                
        if (arr1.length > length) {
            for (int i = length; i < arr1.length; ++i) {
                int v = Integer.valueOf(arr1[i]);
                if (v > 0) return 1;
            }
        }
        
        return 0;
    }
}