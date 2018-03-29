/**
BFS
*/
import java.util.*;
public class Poj1979{
  static int[] di = {1, 0, -1, 0};
  static int[] dj = {0, 1, 0, -1};

  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    while (cin.hasNext()) {
      int column = cin.nextInt();
      int row = cin.nextInt();
      if (row == 0 && column == 0) {
        break;
      }
      int[][] panel = new int[row][column];
      int startI = -1;
      int startJ = -1;
      for (int i = 0; i < row; i++) {
        String line = cin.next();
        for (int j = 0; j < column; j++) {
          panel[i][j] = line.charAt(j);
          if(panel[i][j] == '@'){
            startI = i;
            startJ = j;
          }
        }
      }
      System.out.println(bfs(panel, startI, startJ));
    }
  }

  public static int bfs(int[][] panel, int startI, int startJ){
    int count = 0;
    LinkedList<Point> queue = new LinkedList<Point>();

    queue.add(new Point(startI, startJ));
    panel[startI][startJ] = '#';
    count++;
    while( !queue.isEmpty() ){
      Point p = queue.remove();
      int i = p.i;
      int j = p.j;
      for(int k = 0; k < 4; k++){
        if( 0 <= i + di[k] && i + di[k] < panel.length && 0 <= j + dj[k] && j + dj[k] < panel[0].length &&  panel[i + di[k]][j + dj[k]] == '.'){
          queue.add(new Point(i + di[k], j + dj[k]) );
          panel[i + di[k]][j + dj[k]] = '#';
          count++;
        }
      }
    }
    return count;
  }
}

class Point{
  public int i;
  public int j;
  public Point(int i, int j){
    this.i = i;
    this.j = j;
  }
}










/**
DFS1
*/

// import java.util.*;
// public class Main{
//   //Initilize number of black tiles which he can reach
//   public static int N_REACH = 0;
//
//   //main function handles input, calling solve() and output.
//   public static void main(String args[]){
//     Scanner cin = new Scanner(System.in);
//     while(cin.hasNextInt()){
//       int col = cin.nextInt();
//       int row = cin.nextInt();
//       if(col == 0 && row == 0){
//         break;
//       }
//       int panal[][] = new int[row][col];
//       int startX = 30, startY = 30;
//       for(int i = 0; i < row; i++){
//         String line = cin.next();
//         for(int j = 0; j < col; j++){
//           panal[i][j] = line.charAt(j);
//           if( panal[i][j] == '@'){
//             startX = i;
//             startY = j;
//             panal[i][j] = '.';
//           }
//         }
//       }
//       solve(panal, row, col, startX, startY);
//       System.out.println(N_REACH);
//       N_REACH = 0;
//     }
//   }
//
//   public static void solve(int[][] panal, int row, int col, int x, int y){
//     //If the position is out of panal, stop.
//     if(x < 0 || x >= row || y < 0 || y >= col){
//       return;
//     }else if(panal[x][y] == '#'){
//       return;
//     }else{
//       N_REACH++;
//       panal[x][y] = '#';
//       solve(panal, row, col, x - 1, y);
//       solve(panal, row, col, x + 1, y);
//       solve(panal, row, col, x, y - 1);
//       solve(panal, row, col, x, y + 1);
//     }
//   }
// }











/**
DFS2
*/

// import java.util.*;
// public class Main {
//   static int[] dx = {1, 0, -1, 0};
//   static int[] dy = {0, 1, 0, -1};
//
//   public static void main(String args[]) {
//     Scanner cin = new Scanner(System.in);
//     while (cin.hasNext()) {
//       int w = cin.nextInt();
//       int h = cin.nextInt();
//       if (w == 0 && h == 0) {
//         break;
//       }
//       int[][] floor = new int[h][w];
//       for (int y = 0; y < h; y++) {
//         String temp = cin.next();
//         for (int x = 0; x < w; x++) {
//           floor[y][x] = temp.charAt(x);
//         }
//       }
//       System.out.println(solve(floor, h, w));
//     }
//   }
//
//   private static int solve(int[][] floor, int h, int w) {
//     boolean[][] walk = new boolean[h][w];
//     int startY = 30;
//     int startX = 30;
//     for (int y = 0; y < h; y++) {
//       for (int x = 0; x < w; x++) {
//         walk[y][x] = false;
//         if (floor[y][x] == '@') {
//           startY = y;
//           startX = x;
//         }
//       }
//     }
//     dfs(walk, floor, startY, startX);
//     int count = 0;
//     for (int y = 0; y < h; y++) {
//       for (int x = 0; x < w; x++) {
//         if (walk[y][x] == true) {
//           count++;
//         }
//       }
//     }
//     return count;
//   }
//
//   private static void dfs(boolean[][] walk, int[][] floor, int y, int x) {
//     if (y >= 0 && y < floor.length && x >= 0 && x < floor[0].length
//         && (floor[y][x] == '.' || floor[y][x] == '@') && walk[y][x] == false) {
//       walk[y][x] = true;
//       for (int i = 0; i < dx.length; i++) {
//         dfs(walk, floor, y + dy[i], x + dx[i]);
//       }
//     }
//   }
// }
