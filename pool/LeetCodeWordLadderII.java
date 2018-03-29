import java.util.*;


public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
      //exclude corner case
      //TODO in practical usage. So far no need in this question.

      //initialize result
      List<List<String>> result = new ArrayList<List<String>>();

      //initialize vairables needed to find all SHORTEST paths
      int SHORTEST = -1;//update when first SHORTEST path is found. once updated, stopping add new word to wordQueue
      boolean STOP_ADD = false;
      LinkedList<String> wordQueue = new LinkedList<String>();
      HashMap<String, Integer> lenTable = new HashMap<String, Integer>();
      HashMap<String, Set<String> > pathTable = new HashMap<String, Set<String>>();//<curWord, prevWordList>

      //find all SHORTEST paths
      wordQueue.add(beginWord);
      lenTable.put(beginWord, 2);
      pathTable.put(beginWord, null);
      wordList.remove(beginWord);//Caution: to make sure DAG
      wordList.remove(endWord);//Caution: to make sure DAG
      while( !wordQueue.isEmpty()){
        String word = wordQueue.remove();
        int len = lenTable.get(word);
        if(isMatch(word, endWord)){
          if(! STOP_ADD){
            updateResult(endWord, word, pathTable, result);
            SHORTEST = len;
            STOP_ADD = true;
          }else{
            if(len == SHORTEST) updateResult(endWord, word, pathTable, result);
            else break;
          }
        }else{
          if(! STOP_ADD){
            for(int j = 0; j < word.length(); j++){
                char[] charArr = word.toCharArray();
                for(char ch = 'a'; ch < 'z'; ch++){
                    charArr[j] = ch;
                    String check = new String(charArr);
                    if(!check.equals(word) && wordList.contains(check)){
                        wordQueue.add(check);
                        lenTable.put(check, len + 1);
                        Set<String> prevWordList = new HashSet<String>();
                        prevWordList.add(word);
                        pathTable.put(check, prevWordList);
                        wordList.remove(check);//dynamically shrink size of wordList set
                    }
                    if(!check.equals(word) && !wordList.contains(check) && lenTable.containsKey(check) && lenTable.get(check) == len + 1){
                      pathTable.get(check).add(word);
                    }
                }
            }
          }
        }
      }

      //return result;
      return result;
    }


    public void updateResult(String endWord, String word, HashMap<String, Set<String>> pathTable, List<List<String>> result){
        List<String> cur = new ArrayList<String>();
        cur.add(endWord);
        cur.add(word);
        update(cur, pathTable, result);
    }
    public void update(List<String> cur, HashMap<String, Set<String>> pathTable, List<List<String>> result){
      String word = cur.get(cur.size() - 1);
      List<String> prevList = pathTable.get(word) == null ? null : new ArrayList<String>(pathTable.get(word));
      // System.out.println(cur);
      // System.out.println();
      // System.out.println();

      // System.out.println(prevList);
      // System.out.println();
      // System.out.println();
      if(prevList == null){
        List<String> solution = new ArrayList<String>();
        for(int i = 0; i < cur.size(); i++){
          solution.add(cur.get(i));
        }
        Collections.reverse(solution);
        result.add(solution);
      }
      else{
        for(int i = 0; i < prevList.size(); i++){
          cur.add(prevList.get(i));
          update(cur, pathTable, result);
          cur.remove(cur.size() - 1);
        }
      }
    }

    public boolean isMatch(String word1, String word2){
      int count = 0;
      for(int i = 0; i < word1.length(); i++){
        if(word1.charAt(i) != word2.charAt(i)) count++;
      }
      if(count == 1) return true;
      else return false;

    }
}

/**
Use Graph (Code is written by Digiter)
*/
import java.util.*;

public class Solution {

  public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    // Initialize graph.
    Map<String, List<String>> graph = new HashMap<>();
    for (String word : wordList) {
      graph.put(word, new ArrayList<>());
    }
    // Add edges.
    for (String word : wordList) {
      for (int i = 0; i < word.length(); i++) {
        char[] chars = word.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
          if (c != chars[i]) {
            chars[i] = c;
            String other = new String(chars);
            if (wordList.contains(other)) {
              graph.get(word).add(other);
            }
          }
        }
      }
    }

    // Initialize dist.
    Map<String, Integer> dist = new HashMap<>();
    final int INFINITY = 0x3F3F3F3F;
    for (String word : wordList) {
      dist.put(word, INFINITY);
    }
    dist.put(beginWord, 0);
    // Initialize queue.
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    // BFS.
    while (!queue.isEmpty()) {
      String from = queue.poll();
      for (String to : graph.get(from)) {
        if (dist.get(from) + 1 < dist.get(to)) {
          dist.put(to, dist.get(from) + 1);
          queue.add(to);
        }
      }
    }

    // Initialize reversed graph.
    Map<String, List<String>> revGraph = new HashMap<>();
    for (String word : wordList) {
      revGraph.put(word, new ArrayList<>());
    }
    for (String from : graph.keySet()) {
      for (String to : graph.get(from)) {
        revGraph.get(to).add(from);
      }
    }
    // Output solutions.
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> path = new ArrayList<>();
    outputSolutions(revGraph, dist, beginWord, endWord, path, ans);
    return ans;
  }

  void outputSolutions(Map<String, List<String>> revGraph,
    Map<String, Integer> dist, String beginWord, String current,
    List<String> path, List<List<String>> ans) {

    path.add(current);
    if (current.equals(beginWord)) {
      List<String> pathCopy = new ArrayList(path);
      Collections.reverse(pathCopy);
      ans.add(pathCopy);
      path.remove(path.size() - 1);
      return;
    }
    for (String next : revGraph.get(current)) {
      if (dist.get(next) == dist.get(current) - 1) {
        outputSolutions(revGraph, dist, beginWord, next, path, ans);
      }
    }
    path.remove(path.size() - 1);
  }
}
