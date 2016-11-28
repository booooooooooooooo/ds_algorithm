import java.util.*;
public class Poj1979_secondTry{
  //Initilize number of black tiles which he can reach
  public static int N_REACH = 0;

  //main function handles input, calling solve() and output.
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNextInt()){
      int col = cin.nextInt();
      int row = cin.nextInt();
      if(col == 0 && row == 0){
        break;
      }
      int panal[][] = new int[row][col];
      int startX = 30, startY = 30;
      for(int i = 0; i < row; i++){
        String line = cin.next();
        for(int j = 0; j < col; j++){
          panal[i][j] = line.charAt(j);
          //TODO: char compare function
          if( panal[i][j] == '@'){
            startX = i;
            startY = j;
            panal[i][j] = '.';
          }
        }
      }
      solve(panal, row, col, startX, startY);
      System.out.println(N_REACH);
      N_REACH = 0;
    }
  }

  public static void solve(int[][] panal, int row, int col, int x, int y){
    //If the position is out of panal, stop.
    if(x < 0 || x >= row || y < 0 || y >= col){
      return;
    }else if(panal[x][y] == '#'){
      return;
    }else{
      N_REACH++;
      panal[x][y] = '#';
      solve(panal, row, col, x - 1, y);
      solve(panal, row, col, x + 1, y);
      solve(panal, row, col, x, y - 1);
      solve(panal, row, col, x, y + 1);
    }
  }
}
