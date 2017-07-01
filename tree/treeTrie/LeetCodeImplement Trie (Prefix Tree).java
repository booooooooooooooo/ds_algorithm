public class Trie {
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
