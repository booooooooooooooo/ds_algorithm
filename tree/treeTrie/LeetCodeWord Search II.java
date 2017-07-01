public class Solution {
    Set<String> result;
    private char[][] board;
    private StringBuilder sb;
    public List<String> findWords(char[][] board, String[] words) {
      //corner
      if(board.length == 0) return new ArrayList<String>();

      //buld trie, Initialize result, board, sb
      Trie trie = new Trie();
      for(int i = 0; i < words.length; i++) trie.insert(words[i]);
      Node root = trie.getRoot();
      this.result = new HashSet<String>();
      this.board = board;
      this.sb = new StringBuilder();
      //update result
      if(root.isEnd()) result.add("");
      for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
            dfs(root, i, j);
        }
      }
      //return ArrayList form of result
      return new ArrayList<String>(result);
    }
    private void dfs(Node node, int i, int j){
      //base case : !node.containsKey()
      if(!node.containsKey(String.valueOf( board[i][j]) ) ) return;
      //recursion case: node.containsKey()
      else{
        sb.append(board[i][j]);
        if(node.get(String.valueOf(board[i][j])).isEnd()) result.add(sb.toString());//NOT basecase

        char c = board[i][j];
        board[i][j] = '#';
        if(i > 0 && board[i-1][j] != '#') dfs(node.get(String.valueOf(c)), i - 1, j);
        if(i < board.length - 1 && board[i + 1][j] != '#') dfs(node.get(String.valueOf(c)), i + 1, j);
        if(j > 0 && board[i][j-1] != '#') dfs(node.get(String.valueOf(c)), i, j - 1);
        if(j < board[0].length - 1 && board[i][j + 1] != '#') dfs(node.get(String.valueOf(c)), i, j + 1);
        board[i][j] = c;

        sb.deleteCharAt(sb.length() - 1);
      }
    }
}

class Trie {
    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
      this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      // if(search(word)) return;

      Node node = root;
      for(int i = 0; i < word.length(); i++){
        String key = String.valueOf(word.charAt(i));
        if(!node.containsKey(key)){
          node.add(key, new Node());
        }
        node = node.get(key);
      }
      node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      Node node = root;
      for(int i = 0; i < word.length(); i++){
        String key = String.valueOf(word.charAt(i));
        if(!node.containsKey(key)){
          return false;
        }
        node = node.get(key);
      }
      return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      Node node = root;
      for(int i = 0; i < prefix.length(); i++){
        String key = String.valueOf(prefix.charAt(i));
        if(!node.containsKey(key)){
          return false;
        }
        node = node.get(key);
      }
      return true;
    }

    public Node getRoot(){return this.root;};
}

class Node{
  private Map<String, Node> nexts;
  private boolean end;
  public Node(){
    nexts = new HashMap<String, Node>();
    end = false;
  }
  public boolean containsKey(String key){
    return nexts.containsKey(key);
  }
  public Node get(String key){
    return nexts.get(key);
  }
  public void add(String key, Node node){
    nexts.put(key, node);
  }
  public void setEnd(boolean b){
    this.end = b;
  }
  public boolean isEnd(){
    return this.end;
  }

}
