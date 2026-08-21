class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        // Board create karo
        char[][] board = new char[n][n];

        // Initially saare cells empty hain
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Row 0 se queen place karna start karo
        solve(0, board, ans, n);

        return ans;
    }


    void solve(
        int row,
        char[][] board,
        List<List<String>> ans,
        int n
    ) {
        // BASE CASE
        // Agar n rows me queen successfully place ho gayi hain, ek valid solution mil gaya.
        if (row == n) {

            List<String> current = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            ans.add(current);

            return;
        }
        // Current row me har column try karo

        for (int col = 0; col < n; col++) {

            // Check karo ki yahan queen safely place ho sakti hai ya nahi.
            if (isSafe(row, col, board, n)) {

                // CHOOSE
                board[row][col] = 'Q';
                // EXPLORE
                // Next row par queen place karo.
                solve(
                    row + 1,
                    board,
                    ans,
                    n
                );

                // UNDO / BACKTRACK
                board[row][col] = '.';
            }
        }
    }


    // CHECK WHETHER QUEEN CAN BE PLACED
    boolean isSafe(
        int row,
        int col,
        char[][] board,
        int n
    ) {
        // Check same column

        for (int i = 0; i < row; i++) {

            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check upper-left diagonal

        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {

            if (board[i][j] == 'Q') {
                return false;
            }

            i--;
            j--;
        }

        // Check upper-right diagonal

        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {

            if (board[i][j] == 'Q') {
                return false;
            }

            i--;
            j++;
        }


        // Koi queen attack nahi kar rahi
        return true;
    }
}