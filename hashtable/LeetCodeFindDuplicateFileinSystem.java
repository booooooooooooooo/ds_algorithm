public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
      //make a hashtable to store mid-result
      Map<String, ArrayList<String>> mr = new HashMap<String, ArrayList<String>>();
      //process each path in paths.
      for(int i = 0; i < paths.length; i++){
        String[] elements = paths[i].split(" ");
        for(int j = 1; j < elements.length; j++ ){
          int l = elements[j].indexOf('(');
          int r = elements[j].indexOf(')');
          String filename = elements[j].substring(0, l);
          String content = elements[j].substring(l + 1, r);
          if(!mr.containsKey(content)){
            mr.put(content, new ArrayList<String>());
          }
          mr.get(content).add(elements[0] + "/" + filename);
        }
      }
      //convert mid-result to result
      List<List<String>> result = new ArrayList<List<String>>();
      for(String key : mr.keySet()){
        if(mr.get(key).size() > 1)
          result.add(mr.get(key));
      }

      return result;
    }
}
