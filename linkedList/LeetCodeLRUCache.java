import java.util.*;

public class LRUCache {
	Node dummyHead;
	Node dummyTail;
	Hashtable<Integer, Node> cache;
	int capacity;
	int count;

    public LRUCache(int capacity) {
			this.dummyHead = new Node(0, 0);
			this.dummyTail = new Node(0, 0);
			dummyHead.prev = null;
			dummyHead.next = dummyTail;
			dummyTail.prev = dummyHead;
			dummyTail.next = null;
			this.cache = new Hashtable<Integer, Node>();
			this.capacity = capacity;
			this.count = 0;
    }
		//Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    public int get(int key) {
			Node node = cache.get(key);
			if(node == null){
				return -1;
			}else{
				cutOff(node);
				insertAsHead(node);
				return node.value;
			}
    }
		//Set or insert the value if the key is not already present. When the cache reached its capacity,
		//it should invalidate the least recently used item before inserting a new item.
    public void set(int key, int value) {
			Node node = cache.get(key);
			if(node == null){
				Node newNode = new Node(key, value);
				insertAsHead(newNode);
				count++;
				cache.put(key, newNode);
				if(count > capacity){
					Node tail = trimTailOff();
					count--;
					cache.remove(tail.key);
				}
			}else{
				node.value = value;
				cutOff(node);
				insertAsHead(node);
			}
    }



		/*Untilities*/
		public void cutOff(Node node){
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		public void insertAsHead(Node node){
			node.next = dummyHead.next;
			node.prev = dummyHead;
			dummyHead.next.prev = node;
			dummyHead.next = node;
		}
		public Node trimTailOff(){
			Node node = dummyTail.prev;
			dummyTail.prev.prev.next = dummyTail;
			dummyTail.prev = dummyTail.prev.prev;
			return node;
		}
}



class Node{
	Node prev;
	Node next;
	int key;
	int value;
	public Node(int key, int value){
		this.key = key;
		this.value = value;
	}
}
