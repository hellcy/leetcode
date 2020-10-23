class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] pos = new int[2];
        int max = 0;
        
        for (int i = 0; i <= 50; ++i) {
            for (int j = 0; j <= 50; ++j) {
                int quality = 0;
                for (int[] tower : towers) {
                    int x = tower[0];
                    int y = tower[1];
                    int q = tower[2];
                    
                    double d = Math.sqrt(Math.abs(x - i) * Math.abs(x - i) + Math.abs(y - j) * Math.abs(y - j));
                    if (d > radius) continue;
                    quality += Math.floor(q / (1 + d));
                }
                //System.out.println(i + " " + j + " " + quality);

                if (max < quality) {
                    pos = new int[] {i, j};
                    max = quality;
                } else if (max == quality) {
                    if (i < pos[0] || (i == pos[0] && j < pos[1])) {
                        pos = new int[] {i, j};
                    }
                }
            }
        }
        
        return pos;
    }
}