import java.util.*;

public class Main{
  public static void main(String args[]){

    Scanner cin = new Scanner(System.in);
    while(cin.hasNext()){
      int n = cin.nextInt();
      int m = cin.nextInt();
      cin.nextLine();//eat '\n'
      char[][] field = new char[n][m];
      for(int i = 0; i < n; i++){
        String line = cin.nextLine();
        for(int j = 0; j < m; j++){
          field[i][j] = line.charAt(j);
        }
      }
      System.out.println(solve(field));
    }
  }
  public static int solve(char[][] field){
    int n = field.length;
    int m = field[0].length;
    int count = 0;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        if(field[i][j] == 'W'){
          dfs(field, i, j);
          count++;
        }
      }
    }
    return count;
  }
  public static void dfs(char[][] field, int i, int j){
    field[i][j] = '.';
    int[][] move = {{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
    int n = field.length;
    int m = field[0].length;
    for(int k = 0; k < move.length; k++){
      int x = i + move[k][0];
      int y = j + move[k][1];
      if( x >= 0 && x < n && y >= 0 && y < m && field[x][y] == 'W'){
        dfs(field, x, y);
      }
    }

  }
}
