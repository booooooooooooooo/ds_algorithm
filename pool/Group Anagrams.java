public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<Integer, List<String>> res = new HashMap<Integer, List<String>>();

      int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
      for(int i = 0; i < strs.length; i++){
        String s = strs[i];
        int key = 1;
        for(int j = 0; j < s.length(); j++ ){
          key *= prime[(s.charAt(j) - 'a')];
        }
        if(! res.containsKey(key)) res.put(key, new ArrayList<String>());
        res.get(key).add(s);
      }

      List<List<String>> resFinal = new ArrayList<List<String>>();
      for(Integer key: res.keySet()){
        resFinal.add(res.get(key));
      }
      return resFinal;
    }
}
