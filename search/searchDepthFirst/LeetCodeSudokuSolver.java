/**
TODO: try another method.
*/
public class Solution {
    public void solveSudoku(char[][] board) {
      solve(board);
    }
    public boolean solve(char[][] board){
      for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
          if(board[i][j] == '.'){
            for(int k = 1; k <= 9; k++){
              board[i][j] = (char)('0' + k);
              if(isValid(board, i, j) && solve(board)) return true;
              board[i][j] = '.';
            }
            return false;
          }
        }
      }
      return true;//base case
    }
    public boolean isValid(char[][] board, int i, int j){
      for(int y = 0; y < 9; y++){
        if(y != j && board[i][y] == board[i][j]) return false;
      }
      for(int x = 0; x < 9; x++){
        if(x != i && board[x][j] == board[i][j]) return false;
      }
      for(int x = (i / 3) * 3; x < (i / 3 + 1) * 3; x++){
        for(int y = (j / 3) * 3; y < (j / 3 + 1) * 3; y++){
          if( !(x == i && y == j) && board[x][y] == board[i][j]) return false;
        }
      }
      return true;
    }
}
