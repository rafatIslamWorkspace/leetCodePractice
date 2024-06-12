package random;

import java.util.*;

class LRUCache {

//    class DLinkedList{
//        int key;
//        int value;
//        
//        DLinkedList next;
//        DLinkedList prev;
//    }
//    
//    private void addNode( DLinkedList node){
//        node.prev = head;
//        node.next = head.next;
//        
//        head.next.prev = node;
//        head.next = node;
//    }
//    
//    private void removeNode ( DLinkedList node){
//        DLinkedList prev = node.prev;
//        DLinkedList next = node.next;
//        
//        prev.next = next;
//        next.prev = prev;
//        
//    }
//    
//    private DLinkedList popTail(){
//        DLinkedList res = tail.prev;
//        removeNode(res);
//        return res;
//    }
//    
//    private void moveToHead ( DLinkedList node ){
//        removeNode(node);
//        addNode(node);
//    }
//    
//    private static Map<Integer, DLinkedList> cache = new HashMap<>();
//    private int size;
//    private static int capacity;
//    private DLinkedList head;
//    private DLinkedList tail;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        this.size = 0;
//        
//        head = new DLinkedList();
//        tail = new DLinkedList();
//        
//        head.next = tail;
//        tail.prev = head;
//    }
//    
//    public int get(int key) {
//        DLinkedList node = cache.get(key);
//        
//        if ( node == null){
//            
//            return -1;
//        }
//        
//        moveToHead(node);
//        return node.value;
//    }
//    
//    public void put(int key, int value) {
//        
//        DLinkedList node = cache.get(key);
//        
//        if ( node == null){
//            DLinkedList newNode = new DLinkedList();
//            newNode.key = key;
//            newNode.value = value;
//            
//            cache.put( key , newNode);
//            addNode( newNode );
//            
//            size++;
//            
//            if( size > capacity){
//                DLinkedList tail = popTail();
//                cache.remove(tail.key);
//                size--;
//            }
//        } else{
//            node.value = value;
//            moveToHead ( node );
//        }
//        
//    }
//    

	class DLinkedNode {
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;
	}

	private void addNode(DLinkedNode node) {
		/**
		 * Always add the new node right after head.
		 */
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	private void removeNode(DLinkedNode node) {
		/**
		 * Remove an existing node from the linked list.
		 */
		DLinkedNode prev = node.prev;
		DLinkedNode next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	private void moveToHead(DLinkedNode node) {
		/**
		 * Move certain node in between to the head.
		 */
		removeNode(node);
		addNode(node);
	}

	private DLinkedNode popTail() {
		/**
		 * Pop the current tail.
		 */
		DLinkedNode res = tail.prev;
		removeNode(res);
		return res;
	}

	private static Map<Integer, DLinkedNode> cache = new HashMap<>();
	private int size;
	private static int capacity;
	private DLinkedNode head, tail;

	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;

		head = new DLinkedNode();
		// head.prev = null;

		tail = new DLinkedNode();
		// tail.next = null;

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null)
			return -1;

		// move the accessed node to the head;
		moveToHead(node);

		return node.value;
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);

		if (node == null) {
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;

			cache.put(key, newNode);
			addNode(newNode);

			++size;

			if (size > capacity) {
				// pop the tail
				DLinkedNode tail = popTail();
				cache.remove(tail.key);
				--size;
			}
		} else {
			// update the value.
			node.value = value;
			moveToHead(node);
		}
	}
	
    private static void printCache () {
    	
    	for ( int i = 1; i <= capacity ; i++) {
    		DLinkedNode node = cache.get(i);
    		if ( node != null)
    			System.out.println( i + " , " + node.value);
    	}
    }

	public static void main(String[] args) throws Exception {

		int capacity = 5;

		LRUCache obj = new LRUCache(capacity);

		obj.put(1, 2);
		obj.put(2, 3);
		obj.put(3, 4);
		obj.put(4, 5);
		obj.put(5, 6);
		obj.put(6, 7);

		printCache();

		int param_1 = obj.get(4);
//    	
		System.out.println(param_1);
//    	//obj.put(4,5);
		printCache();

	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
