/**
DFS1
*/

import java.util.*;
public class Main{
  public static int N_REACH = 0;

  public static void main(String[] args){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNextInt()){
      int col = cin.nextInt();
      int row = cin.nextInt();
      if(col == 0 && row == 0){
        break;
      }

      char[][] panal = new char[row][col];
      int startX = -1, startY = -1;
      for(int i = 0; i < row; i++){
        String line = cin.next();
        for(int j = 0; j < col; j++){
          panal[i][j] = line.charAt(j);
          if( panal[i][j] == '@'){
            startX = i;
            startY = j;
          }
        }
      }
      N_REACH = 0;
      dfs(panal, row, col, startX, startY);
      System.out.println(N_REACH);
    }
  }

  public static void dfs(char[][] panal, int row, int col, int x, int y){
    N_REACH++;
    panal[x][y] = '#';
    int[][] move = { {1,0}, {-1, 0}, {0, 1}, {0, -1}};
    for(int i = 0; i < move.length; i++){
      int x_next = x + move[i][0];
      int y_next = y + move[i][1];
      if(x_next >= 0 && x_next < row && y_next >= 0 && y_next < col && panal[x_next][y_next] != '#'){
        dfs(panal, row, col, x_next, y_next);
      }
    }
  }
}











/**
DFS2
*/


import java.util.*;
public class Main{

  public static void main(String[] args){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNextInt()){
      int col = cin.nextInt();
      int row = cin.nextInt();
      if(col == 0 && row == 0){
        break;
      }

      char[][] panal = new char[row][col];
      char[][] panal_dup = new char[row][col];
      int startX = -1, startY = -1;
      for(int i = 0; i < row; i++){
        String line = cin.next();
        for(int j = 0; j < col; j++){
          panal_dup[i][j] = panal[i][j] = line.charAt(j);
          if( panal[i][j] == '@'){
            startX = i;
            startY = j;
          }
        }
      }
      dfs(panal, row, col, startX, startY);
      System.out.println(count_dif(panal, panal_dup));
    }
  }

  public static void dfs(char[][] panal, int row, int col, int x, int y){
    panal[x][y] = '#';
    int[][] move = { {1,0}, {-1, 0}, {0, 1}, {0, -1}};
    for(int i = 0; i < move.length; i++){
      int x_next = x + move[i][0];
      int y_next = y + move[i][1];
      if(x_next >= 0 && x_next < row && y_next >= 0 && y_next < col && panal[x_next][y_next] != '#'){
        dfs(panal, row, col, x_next, y_next);
      }
    }
  }
  public static int count_dif(char[][] panal, char[][] panal_dup){
    int count = 0;
    for(int i = 0; i < panal.length; i++){
      for(int j = 0; j < panal[0].length; j++){
        if(panal[i][j] != panal_dup[i][j]){
          count++;
        }
      }
    }
    return count;
  }
}
