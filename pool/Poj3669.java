/**
BFS!
*/

//!!!Only use methods of Queue interface!!!!!!!!!!!!!!

//TODO: rewrite to eliminate unnecessary checking such as ruin[0][0] <0

import java.util.*;

public class Main{
  static int[] dx = {-1, 0, 1, 0, 0};
  static int[] dy = {0, -1, 0, 1, 0};

  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    int[][] ruin = new int[310][310];
    int[][] reach = new int[310][310];
    for(int i = 0; i < 310; i++){
      for(int j = 0; j < 310; j++){
        ruin[i][j] = 1001;
        reach[i][j] = 0;
      }
    }
    int n = cin.nextInt() ;
    while(n-- > 0){
      int x = cin.nextInt();
      int y = cin.nextInt();
      int t = cin.nextInt();
      for(int i = 0; i < 5; i++){
        if(x + dx[i] >= 0 && y + dy[i] >= 0){
          ruin[x + dx[i]][y + dy[i]] = Math.min(t, ruin[x + dx[i]][y + dy[i]]);
        }
      }
    }

    if(ruin[0][0] == 1001) {
      System.out.println(0);
      return;
    }else if(ruin[0][0] <= 0) {
      System.out.println(-1);
      return;
    }

    Queue<Situation> queue = new LinkedList<Situation>();
    reach[0][0] = 1;
    queue.add(new Situation(0, 0, 0));
    while(!queue.isEmpty()){
      Situation cur = queue.poll();
      for(int i = 0; i < 4; i++){
        int x = cur.x + dx[i];
        int y = cur.y + dy[i];
        int t = cur.t + 1;

        if(x >= 0 && y >= 0 && reach[x][y] == 0 &&ruin[x][y] == 1001){
          System.out.println(t);
          return;
        }else if(x >= 0 && y >= 0 && reach[x][y] == 0 && ruin[x][y] > t){
          reach[x][y] = 1;
          queue.add(new Situation(x, y, t));
        }
      }
    }
    System.out.println(-1);
  }

}

class Situation{
  int x, y, t;
  Situation(int x_, int y_, int t_){
    x = x_;
    y = y_;
    t = t_;
  }
}
