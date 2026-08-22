class Solution {

    public void solveSudoku(char[][] board) {

        solve(board);
    }


    boolean solve(char[][] board) {

        // -----------------------------------------
        // Empty cell find karo
        // -----------------------------------------

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                // Agar empty cell mil gaya
                if (board[row][col] == '.') {


                    // ---------------------------------
                    // 1 to 9 try karo
                    // ---------------------------------

                    for (char num = '1'; num <= '9'; num++) {


                        // Check karo number safely
                        // place ho sakta hai ya nahi
                        if (isValid(
                            board,
                            row,
                            col,
                            num
                        )) {


                            // -------------------------
                            // CHOOSE
                            // -------------------------

                            board[row][col] = num;


                            // -------------------------
                            // EXPLORE
                            // -------------------------

                            if (solve(board)) {

                                return true;
                            }


                            // -------------------------
                            // UNDO / BACKTRACK
                            // -------------------------

                            board[row][col] = '.';
                        }
                    }


                    // Agar 1-9 me se koi bhi number
                    // kaam nahi kiya
                    return false;
                }
            }
        }


        // Koi empty cell nahi bacha.
        // Sudoku successfully solved.
        return true;
    }


    // ---------------------------------------------
    // CHECK WHETHER NUMBER IS VALID
    // ---------------------------------------------

    boolean isValid(
        char[][] board,
        int row,
        int col,
        char num
    ) {


        // -----------------------------------------
        // Check ROW
        // -----------------------------------------

        for (int j = 0; j < 9; j++) {

            if (board[row][j] == num) {
                return false;
            }
        }


        // -----------------------------------------
        // Check COLUMN
        // -----------------------------------------

        for (int i = 0; i < 9; i++) {

            if (board[i][col] == num) {
                return false;
            }
        }

        // Check 3 x 3 BOX
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;


        for (int i = startRow; i < startRow + 3; i++) {

            for (int j = startCol; j < startCol + 3; j++) {

                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}