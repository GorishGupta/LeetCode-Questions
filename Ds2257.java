class Solution {
    public void markUnguarded(int row, int col, int[][] grid) {
        for (int r = row - 1; r >= 0; r--) {
            if (grid[r][col] == 3 || grid[r][col] == 2) break;
            grid[r][col] = 1;
        }
        for (int r = row + 1; r < grid.length; r++) {
            if (grid[r][col] == 3 || grid[r][col] == 2) break;
            grid[r][col] = 1;
        }
        for (int c = col - 1; c >= 0; c--) {
            if (grid[row][c] == 3 || grid[row][c] == 2) break;
            grid[row][c] = 1;
        }
        for (int c = col + 1; c < grid[0].length; c++) {
            if (grid[row][c] == 3 || grid[row][c] == 2) break;
            grid[row][c] = 1;
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3;
        }
        for (int[] guard : guards) {
            markUnguarded(guard[0], guard[1], grid);
        }
        int count = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 0) count++;
            }
        }
        return count;
    }
}