public class Solution {
  private int[] dx = new int[]{1, 0, -1, 0};
  private int[] dy = new int[]{0, 1, 0, -1};
    public void solve(char[][] board) {
      //corner: None
      for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
          if(board[i][j] == 'O'){
            boolean isSurrounded = checkAndMark(board, 'O', 'X', '#', i, j);
            if(isSurrounded) changeToMark(board, '#', 'X', i, j);
          }
        }
      }
      for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
          if(board[i][j] == '#') changeToMark(board, '#', 'O', i, j);
        }
      }
    }

    //Change all connected target to mark
    //return true is these targets are surrounded by surronder; false otherwise
    private boolean checkAndMark(char[][] board, char target, char surronder, char mark, int i, int j){
      boolean isSurrounded = true;
      Queue<Point> que = new LinkedList<Point>();
      que.add(new Point(i, j));

      while(!que.isEmpty()){
        Point p = que.poll();
        if(p.x < 0 || p.x  >= board.length || p.y  < 0 || p.y  >= board[0].length)
          isSurrounded = false;
        else if(board[p.x][p.y] == target){
          board[p.x][p.y] = mark;
          for(int k = 0; k < 4; k++)
            que.add(new Point(p.x + dx[k], p.y + dy[k]));
        }else
          ;
      }
      return isSurrounded;
    }

    //Change all target char that connected to (i, j) to mark
    private void changeToMark(char[][] board, char target, char mark, int i, int j){
      Queue<Point> que = new LinkedList<Point>();
      que.add(new Point(i, j));

      while(!que.isEmpty()){
        Point p = que.poll();
        if(p.x < 0 || p.x  >= board.length || p.y  < 0 || p.y  >= board[0].length)
          ;
        else if(board[p.x][p.y] == target ){
          board[p.x][p.y] = mark;
          for(int k = 0; k < 4; k++)
            que.add(new Point(p.x + dx[k], p.y + dy[k]));
        }else
          ;
      }
    }
    class Point{
      int x;
      int y;
      public Point(int x, int y){
        this.x = x;
        this.y = y;
      }
    }
}


//stack over flow
public class Solution {
    public void solve(char[][] board) {
      //corner: None
      for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
          if(board[i][j] == 'O'){
            boolean isSurrounded = checkAndMark(board, 'O', 'X', '#', i, j);
            if(isSurrounded) changeToMark(board, '#', 'X', i, j);
          }
        }
      }
      for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
          if(board[i][j] == '#') changeToMark(board, '#', 'O', i, j);
        }
      }
    }

    //Change all connected target to mark
    //return true is these targets are surrounded by surronder; false otherwise
    private boolean checkAndMark(char[][] board, char target, char surronder, char mark, int i, int j){
      if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
        return false;
      else if(board[i][j] != target)
        return true;
      else{
        board[i][j] = mark;
        return checkAndMark(board, target, surronder, mark, i, j + 1)
                && checkAndMark(board, target, surronder, mark, i, j - 1)
                && checkAndMark(board, target, surronder, mark, i + 1, j)
                && checkAndMark(board, target, surronder, mark, i - 1, j);
      }

    }

    //Change all target char that connected to (i, j) to mark
    private void changeToMark(char[][] board, char target, char mark, int i, int j){
      if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
        return ;
      else if(board[i][j] != target)
        return;
      else{
        board[i][j] = mark;
        changeToMark(board, target, mark, i, j + 1);
        changeToMark(board, target, mark, i, j - 1);
        changeToMark(board, target, mark, i + 1, j);
        changeToMark(board, target, mark, i - 1, j);
      }
    }

}
