class Solution {
    int rows;
    int cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        boolean visited[][] = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(board, word, i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, String word,int row,int col,
            int index,boolean[][] visited){ 
                if(index == word.length()){
                    return true;
                }
                if(row < 0 || row >= rows ||
                    col < 0 || col >= cols){
                        return false;
                }
                if(visited[row][col]){
                    return false;
                }
                if(board[row][col] != word.charAt(index)){
                    return false;
                }

                visited[row][col] = true;
                //explore all directions
                // UP
        boolean found =
            dfs(
                board,
                word,
                row - 1,
                col,
                index + 1,
                visited
            );


        // DOWN
        if (!found) {

            found =
                dfs(
                    board,
                    word,
                    row + 1,
                    col,
                    index + 1,
                    visited
                );
        }


        // LEFT
        if (!found) {

            found =
                dfs(
                    board,
                    word,
                    row,
                    col - 1,
                    index + 1,
                    visited
                );
        }


        // RIGHT
        if (!found) {

            found =
                dfs(
                    board,
                    word,
                    row,
                    col + 1,
                    index + 1,
                    visited
                );
        }

        // UNDO / BACKTRACK
        visited[row][col] = false;
        return found;
    }
}