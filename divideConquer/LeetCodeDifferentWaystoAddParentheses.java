public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
      Map<String, List<Integer>> memory = new HashMap<String, List<Integer>>();
      return solve(input, memory);
    }
    private List<Integer> solve(String input, Map<String, List<Integer>> memory){
      if(memory.containsKey(input)) return memory.get(input);

      List<Integer> result = new ArrayList<Integer>();
      for(int i = 0; i < input.length(); i++){
        if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' ){
          List<Integer> left = solve(input.substring(0, i), memory);
          List<Integer> right = solve(input.substring(i+1, input.length()), memory);
          result.addAll( doOperation(left, right, input.charAt(i)) );
        }
      }
      if(result.isEmpty()){//no operater at alls!!!!!!!!
        result.add(Integer.parseInt(input));
      }
      memory.put(input, result);
      return result;
    }
    private List<Integer> doOperation(List<Integer> left, List<Integer> right, char op){
      List<Integer> result = new ArrayList<Integer>();
      for(int i = 0; i < left.size(); i++){
        for(int j = 0; j < right.size(); j++){
          int part1 = left.get(i);
          int part2 = right.get(j);
          switch(op){
            case '+': result.add(part1 + part2); break;
            case '-': result.add(part1 - part2); break;
            case '*': result.add(part1 * part2); break;
          }
        }
      }
      return result;
    }
}
