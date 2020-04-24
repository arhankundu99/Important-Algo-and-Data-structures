/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
                  it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.
*/

class LRUCache {

    Map<Integer,node>map;
    linkedList list;
    int count;
    int capacity;
    public LRUCache(int capacity) {
        
        map = new HashMap<>();
        list = new linkedList();
        this.count = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key))return -1;
        node node = map.get(key);
        int result = node.data;
        list.deleteNode(node);
        list.addFirst(node);
        return result;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            node node = map.get(key);
            node.data = value;
            list.deleteNode(node);
            list.addFirst(node);
        }
        else
        {
            if(count == capacity)
            {
                map.remove(list.tail.key);
                list.deleteNode(list.tail);
            }
            else count++;
            node node = new node(key, value);
            map.put(key, node);
            list.addFirst(node);
        }
    }
}
class linkedList
{
    node head,tail;
    public linkedList()
    {
        this.head = null;
        this.tail = null;
    }
    public void addFirst(node node)
    {
        if(head == null)
        {
            head = node;
            tail = node;
        }
        else 
        {
            head.prev = node;
            head.prev.next = head;
            head = node;
        }
    }
    public void deleteNode(node node)
    {
        if(tail == head)
        {
            head = null;
            tail = null;
            return;
        }
        if(node == tail)
        {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
            return;
        }
        else if(node == head)
        {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
            return;
        }
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
class node
{
    int key,data;
    node prev,next;
    public node(int key, int data)
    {
        this.key = key;
        this.data = data;
        prev = null;
        next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
