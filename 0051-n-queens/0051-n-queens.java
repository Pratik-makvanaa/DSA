class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int[] row = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];

        solve(0, n, board, ans, row, lowerDiagonal, upperDiagonal);

        return ans;
    }

    private void solve(
            int col,
            int n,
            char[][] board,
            List<List<String>> ans,
            int[] row,
            int[] lowerDiagonal,
            int[] upperDiagonal) {

        // All columns completed
        if (col == n) {

            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // Try every row in current column
        for (int r = 0; r < n; r++) {

            // Check if queen can be placed
            if (row[r] == 0 &&
                lowerDiagonal[r + col] == 0 &&
                upperDiagonal[n - 1 + col - r] == 0) {

                // Place queen
                board[r][col] = 'Q';

                row[r] = 1;
                lowerDiagonal[r + col] = 1;
                upperDiagonal[n - 1 + col - r] = 1;

                // Move to next column
                solve(
                    col + 1,
                    n,
                    board,
                    ans,
                    row,
                    lowerDiagonal,
                    upperDiagonal
                );

                // Backtrack
                board[r][col] = '.';

                row[r] = 0;
                lowerDiagonal[r + col] = 0;
                upperDiagonal[n - 1 + col - r] = 0;
            }
        }
    }
}