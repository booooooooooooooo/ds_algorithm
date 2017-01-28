public class Solution {
    public int numIslands(char[][] grid) {
      //exclude corner case
      if(grid.length == 0 || grid[0].length == 0) return 0;
      //normal case
      int m = grid.length;
      int n = grid[0].length;
      // System.out.printf("m : %d, n : %d\n", m, n);
      int[][] disJointSet = new int[m][n];
      for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
          int location = i * n + j;
          disJointSet[i][j] = location;
        }
        // System.out.println(Arrays.toString(disJointSet[i]) );
      }


      for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
          if(i - 1 >= 0 && grid[i][j] == '1' && grid[i - 1][j] == '1') union((i - 1) * n + j, i * n + j, disJointSet);
          if(j - 1 >= 0 && grid[i][j] == '1' && grid[i][j - 1] == '1') union( i * n + j - 1, i * n + j, disJointSet);
        }
        // System.out.println(Arrays.toString(disJointSet[i]) );
      }
      Set<Integer> roots = new HashSet<Integer>();
      for(int i = 0; i < m; i++){
        // System.out.println(Arrays.toString(disJointSet[i]) );
        for(int j = 0; j < n; j++){
          if(grid[i][j] == '1') roots.add(getRoot(i * n + j, disJointSet));
        }
      }
      return roots.size();
    }

    public int getRoot(int location, int[][] disJointSet){
      // int m = disJointSet.length;
      int n = disJointSet[0].length;
      int x = location / n;
      int y = location % n;
      while(disJointSet[x][y] != x * n + y){
        location = disJointSet[x][y];
        x = location / n;
        y = location % n;
      }
      return location;
    }

    public void union(int location1, int location2, int[][] disJointSet){
      int n = disJointSet[0].length;
      int root1 = getRoot(location1, disJointSet);
      int root2 = getRoot(location2, disJointSet);
      int x1 = root1 / n;
      int y1 = root1 % n;
      disJointSet[x1][y1] = root2;
    }
}
