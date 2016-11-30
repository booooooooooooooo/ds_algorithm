public class Solution {
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
      //exclude boundary case TODO
      if(word == "") return true;
      //initialize
      boolean[][] visited = new boolean[board.length][board[0].length];
      for(int i = 0; i < board.length; i++){
        Arrays.fill(visited[i], false);
      }
      //scan and return result.
      for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length; j++){
          if(dfs(board, visited, i, j, word, "")) return true;
        }
      }
      return false;
    }

    public boolean dfs(char[][] board,  boolean[][] visited, int row, int col, String word, String result){
      //update before check base case
      visited[row][col] = true;
      result += board[row][col];
      //prunning
      if(! matchable(result, word)){
        visited[row][col] = false;
        return false;
      }
      //base case. Also, dfs terminates in this case.
      if( result.equals(word) ) return true;
      //if base case does not fullfil, check this node's subtrees.
      for(int i = 0; i < dx.length; i++){
        int newRow = row + dx[i];
        int newCol = col + dy[i];
        if(0 <= newRow && newRow < board.length && 0 <= newCol && newCol < board[0].length && visited[newRow][newCol] == false && dfs(board, visited, newRow, newCol, word, result))
          return true;
      }
      //fails to find result. recover paremeter and return false. recursion goes back to parent node's next subtree or parent of parent's...or....
      visited[row][col] = false;//not necessary to recover result, since String is immutable so result is local variable.
      return false;
    }

    public boolean matchable(String result, String word){
      for(int i = 0; i < Math.min(result.length(), word.length() ); i++){
        if(result.charAt(i) != word.charAt(i)) return false;
      }
      return true;
    }
}
