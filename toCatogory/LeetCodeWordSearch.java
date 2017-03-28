
/*
79. Word Search   QuestionEditorial Solution  My Submissions
Total Accepted: 98068
Total Submissions: 394525
Difficulty: Medium
Contributors: Admin
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class LeetCodeWordSearch {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0 || word.length() == 0) return false;

        boolean[][] record = new boolean[board.length][board[0].length];
        for(int i = 0; i < record.length; i++){
            for(int j = 0; j < record[0].length; j++){
                record[i][j] = false;
            }
        }

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                if(backTrack(board, record, word, x, y, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, boolean[][] record, String word, int x, int y, int tail){
        if(x >= board.length || x < 0 || y >= board[0].length || y < 0){
            return false;
        }else if(record[x][y] == true){
            return false;
        }else if(tail == word.length()){
            return false;
        }else if(board[x][y] != word.charAt(tail)){
            return false;
        }else if(tail == word.length() - 1){
            return true;
        }
        else{
            record[x][y] = true;
            boolean ok = false;
            for(int i = 0; i < 4; i++){
                ok = ok || backTrack(board, record, word, x + dx[i], y + dy[i], tail + 1);
            }
            record[x][y] = false;
            return ok;
        }
    }


}
