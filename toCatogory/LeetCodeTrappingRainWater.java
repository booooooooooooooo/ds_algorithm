public class LeetCodeTrappingRainWater {
    public int trap(int[] height) {
        int div = -1;
        int maxHeight = 0;
        for(int i = 0; i < height.length; i++){
          if(height[i] > maxHeight){
            div = i;
            maxHeight = height[i];
          }
        }
        // System.out.println(div);
        return div == -1 ? 0 : leftTrap(height, div) + rightTrap(height, div);
    }
    private int leftTrap(int[] height, int div){
      int trappedWater = 0;
      int rightMax = height[div];
      int leftMax = 0;
      for(int i = 0; i < div; i++){
        trappedWater += Math.min(leftMax, rightMax) > height[i] ? Math.min(leftMax, rightMax) - height[i] : 0;
        leftMax = Math.max(leftMax, height[i]);
        // System.out.println(trappedWater);
      }
      return trappedWater;
    }
    private int rightTrap(int[] height, int div){
      int trappedWater = 0;
      int leftMax = height[div];
      int rightMax = 0;
      for(int i = height.length - 1; i > div; i--){
        trappedWater += Math.min(leftMax, rightMax) > height[i] ? Math.min(leftMax, rightMax) - height[i] : 0;
        rightMax = Math.max(rightMax, height[i]);
      }
      return trappedWater;
    }
}
