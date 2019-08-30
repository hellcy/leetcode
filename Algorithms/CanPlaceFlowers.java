class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*
            Algorithm explained:
                if the position is zero
                    the previous and next position is also zero
                    count++
                return true when available count is greater than demand n
        */
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if(count>=n)
                return true;
            i++;
        }
        return false;
    }
}