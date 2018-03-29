/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      //exclude corner cases
      if(node == null) return null;
      //create and initialize hashMap
      HashMap<UndirectedGraphNode, UndirectedGraphNode> pair = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
      pair.put(node, new UndirectedGraphNode(node.label));
      //call dfs
      dfs(node, pair);
      //return result
      return pair.get(node);
    }

    public void dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> pair){
      UndirectedGraphNode copyNode = pair.get(node);
      List<UndirectedGraphNode> neighbors = node.neighbors;
      for(UndirectedGraphNode neighbour : neighbors){
        if(pair.containsKey(neighbour)){
          copyNode.neighbors.add(pair.get(neighbour));//maybe self cycle
        }else{
          UndirectedGraphNode copyNeighbour = new UndirectedGraphNode(neighbour.label);
          pair.put(neighbour, copyNeighbour);
          copyNode.neighbors.add(copyNeighbour);
          dfs(neighbour, pair);
        }
      }
    }
}
