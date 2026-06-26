public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void insert(Node node) {
        Node next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        next.prev = node;
        node.next = next;
    }

    private void remove(Node node) {
       Node prev = node.prev;
       Node next = node.next;
       prev.next = next;
       next.prev = prev;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        } 

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size()>cap) {
            Node lru = this.tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
