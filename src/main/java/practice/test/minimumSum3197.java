package practice.test;

public class minimumSum3197 {
    private int[][] grid;
    private int rows, cols;
    private int totalOnes;
    private int minAreaSum = Integer.MAX_VALUE;



    private int countOnes() {
        int count = 0;
        for (int[] row : grid) {
            for (int val : row) {
                if (val == 1) count++;
            }
        }
        return count;
    }

    public int minArea() {
        boolean[][] covered = new boolean[rows][cols];
        backtrack(0, 0, 0, covered, 0);
        return minAreaSum;
    }

    private void backtrack(int x, int y, int rectCount, boolean[][] covered, int currentArea) {
        if (rectCount == 3) {
            if (isAllOnesCovered(covered)) {
                minAreaSum = Math.min(minAreaSum, currentArea);
            }
            return;
        }

        // Try to place a rectangle starting from (x, y)
        for (int i = x; i < rows; i++) {
            for (int j = y; j < cols; j++) {
                if (canPlaceRectangle(i, j, covered)) {
                    int rectArea = placeRectangle(i, j, covered);
                    backtrack(x, j + 1, rectCount + 1, covered, currentArea + rectArea);
                    removeRectangle(i, j, covered);
                }
            }
            y = 0; // Reset y to start a new row after finishing a row
        }
    }

    private boolean canPlaceRectangle(int x1, int y1, boolean[][] covered) {
        int x2 = findX2(x1, y1);
        int y2 = findY2(x1, y1);
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (covered[i][j]) return false;
            }
        }
        return true;
    }

    private int findX2(int x1, int y1) {
        int x2 = x1;
        while (x2 < rows && grid[x2][y1] == 1) x2++;
        return x2 - 1;
    }

    private int findY2(int x1, int y1) {
        int y2 = y1;
        while (y2 < cols && grid[x1][y2] == 1) y2++;
        return y2 - 1;
    }

    private int placeRectangle(int x1, int y1, boolean[][] covered) {
        int x2 = findX2(x1, y1);
        int y2 = findY2(x1, y1);
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                covered[i][j] = true;
            }
        }
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }

    private void removeRectangle(int x1, int y1, boolean[][] covered) {
        int x2 = findX2(x1, y1);
        int y2 = findY2(x1, y1);
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                covered[i][j] = false;
            }
        }
    }

    private boolean isAllOnesCovered(boolean[][] covered) {
        int coveredOnes = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (!covered[i][j]) return false;
                    coveredOnes++;
                }
            }
        }
        return coveredOnes == totalOnes;
    }
    public int minimumSum(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.totalOnes = countOnes();
        return minArea();
    }
}
