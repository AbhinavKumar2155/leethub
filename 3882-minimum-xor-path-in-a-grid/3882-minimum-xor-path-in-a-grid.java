class Solution {
    public int minCost(int[][] grid) {
       int r = grid.length;
       int c = grid[0].length;
       boolean[][][] seen = new boolean[r][c][1024];
       seen[0][0][grid[0][0]] = true;
       for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            int cell = grid[i][j];
            if (i == 0 && j == 0) 
            {
                continue;
            }
            for (int v = 0; v < 1024; v++) {
                int prev = v ^ cell;
                if (i > 0 && seen[i - 1][j][prev]) {
                    seen[i][j][v] = true;
                } 
                else if (j > 0 && seen[i][j - 1][prev]) {
                    seen[i][j][v] = true;

                }

            }
        }
      }
      for (int v = 0; v < 1024; v++) {
           if (seen[r - 1][c - 1][v]) {
               return v;
            }
        }
        return -1;  

    }
}
                        
                    