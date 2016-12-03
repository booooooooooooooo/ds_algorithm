//TODO: rewrite to make variables more understandable.

import java.util.*;
import java.lang.Math.*;
public class Poj3009{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    int width, depth;
    while(( width = cin.nextInt()) != 0 && (depth = cin.nextInt()) != 0){
      int[][] panel = new int[width][depth];//Make the coordinate human friendly
      int startX = 888, startY = 888, goalX = 888, goalY = 888;
      for(int j = depth - 1; j >=0; j--){
        for(int i = 0; i < width; i++){
          panel[i][j] = cin.nextInt();
          if(panel[i][j] == 2){
            startX = i;
            startY = j;
          }
          if(panel[i][j] == 3){
            goalX = i;
            goalY = j;
          }
        }
      }
      int minStep = solve(panel, depth, width, goalX, goalY, startX, startY, "still", 0);
      if(minStep > 10) minStep = -1;
      System.out.println(minStep);
    }
  }

  public static int solve(int[][] panel, int depth, int width, int goalX, int goalY, int x, int y, String status, int step){
    // System.out.printf("width:%d  depth:%d  x:%d  y:%d  step:%d\n", width, depth, x, y, step);
    if(status.equals("still")){
      step++;
      return Math.min(Math.min(solve(panel, depth, width, goalX, goalY, x, y, "left", step),
                               solve(panel, depth, width, goalX, goalY, x, y, "right", step) ),
                      Math.min(solve(panel, depth, width, goalX, goalY, x, y, "up", step),
                               solve(panel, depth, width, goalX, goalY, x, y, "down", step) ) );
    }else if(status.equals("left")){
      if(step > 10 || x == 0 || panel[x - 1][y] == 1) return 100;//step exceeds 10 or the next position of the start point is block

      for(int i = x; i >= 0; i--){
        if(panel[i][y] == 3) return step;//Reach goal
        else if(panel[i][y] == 1){//Meet block in moving
          panel[i][y] = 0;
          int result =  solve(panel, depth, width, goalX, goalY, i + 1, y, "still", step);
          panel[i][y] = 1;//Recover panel
          return result;
        }
      }
      return 100;//Goes out of board
    }else if(status.equals("right")){
      if(step > 10 || x == width - 1 || panel[x + 1][y] == 1) return 100;
      for(int i = x; i < width; i++){
        if(panel[i][y] == 3) return step;
        else if(panel[i][y] == 1){
          panel[i][y] = 0;
          int result = solve(panel, depth, width, goalX, goalY, i - 1, y, "still", step);
          panel[i][y] = 1;
          return result;
        }
      }
      return 100;
    }else if(status.equals("down")){
      if(step > 10 || y == 0 || panel[x][y - 1] == 1) return 100;
      for(int j = y; j >= 0; j--){
        if(panel[x][j] == 3) return step;
        else if(panel[x][j] == 1){
          panel[x][j] = 0;
          int result = solve(panel, depth, width, goalX, goalY, x, j + 1, "still", step);
          panel[x][j] = 1;
          return result;
        }
      }
      return 100;
    }else if(status.equals("up")){
      if(step > 10 || y == depth - 1 || panel[x][y + 1] == 1) return 100;
      for(int j = y; j < depth; j++){
        if(panel[x][j] == 3) return step;
        else if(panel[x][j] == 1){
          panel[x][j] = 0;
          int result = solve(panel, depth, width, goalX, goalY, x, j - 1, "still", step);
          panel[x][j] = 1;
          return result;
        }
      }
      return 100;
    }else{
      return 100;
    }
  }

}
