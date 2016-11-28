import java.util.*;

public class Poj3050{
  static Set<String> res = new LinkedHashSet<String>();
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    int[][] panel = new int[5][5];
    for(int i = 0; i < 5; i++){
      if(cin.hasNext()){
        String line = cin.nextLine();
        String[] str = line.split(" ");
        for(int j = 0; j < 5; j++){
          panel[i][j] = str[j].charAt(0) - '0';
        }
      }
    }
    int[] result = {};
    solve(panel, result, -1, -1 );
    System.out.println(res.size());
  }

  static void solve(int[][] panel, int[] result, int x, int y){
    if( result.length == 0 ){
      for(int i = 0; i < 5; i++){
        for(int j = 0; j < 5; j++){
          int[] newResult = new int[1];
          newResult[0] = panel[i][j];
          solve(panel,newResult , i, j);
        }
      }
    }else if(result.length > 0 && result.length < 6){
      for(int i = 0; i < 4; i++){
        int newX = x + dx[i];
        int newY = y + dy[i];
        if(newX >= 0 && newX < 5 && newY >= 0 && newY < 5){
          int[] newResult = new int[result.length + 1];
          System.arraycopy( result, 0, newResult, 0, result.length );
          newResult[result.length] = panel[newX][newY];
          solve(panel, newResult, newX, newY);
        }
      }
    }else if(result.length == 6){
      String str = Arrays.toString(result);//!!!Must use String instead of int[]
      res.add(str);
    }else{
      System.out.println("Error!");
    }
  }
}
