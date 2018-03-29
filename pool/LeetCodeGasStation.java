public class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0;
    for (int i = 0; i < gas.length; i++)
      total += gas[i] - cost[i];
    if (total < 0)
      return -1;

    int accu = 0;
    int result = 0;
    for(int i = 0; i < gas.length; i++){
      if(gas[i] + accu - cost[i] < 0){
        result = i + 1;
        accu = 0;
      }else
        accu += gas[i] - cost[i];
    }
    return result;
  }
}
