import java.util.*;
public class LeetCodeGreyCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>((int)Math.pow(2, n));
        result.add(new Integer(0));
        for(int i = 0; i < n; i++){
          for(int j = result.size() - 1; j >= 0; j--){
            result.add(result.get(j) + (int)Math.pow(2, i));
          }
        }
        return result;
    }
}
