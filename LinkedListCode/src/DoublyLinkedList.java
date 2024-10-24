
public class DoublyLinkedList {
	private Node head;
    private Node tail;
    private int count;
    
    private static class Node {
        int data;
        Node next;
        Node prev;
        
        public Node(int i, Node n, Node p) {
            next = n;
            prev = p;
            data = i;
        }
    }
    public DoublyLinkedList() {
    	createList();
    }
    
    public void createList() {
    	
    	head = new Node(1, null, null);
        Node follow = head;
        Node p = null;
        for(int i = 2; i <= 10; ++i) {
        	if(i == 4) continue;
            p = new Node(i, null, null);
            follow.next = p;
            p.prev = follow;
            follow = p;
            ++count;
        }
        tail = p;
    }
    
    /** This method adds the element into the correct place.
     * @param toAdd the element to be added (must not be null)
     * @return true if node was added, false if it wasn't
    */
    public boolean add(int toAdd) {
    	//get rid of follow and just use our prev pointers
        Node n = new Node(toAdd, null, null);
        for(Node p = head; p != null; p = p.next) {
            if(p.data >= toAdd) {
                if(p == head) {
                    n.next = head;
                    head.prev = n;
                    head = n;
                }
                if(p == tail) {
                    tail.next = n;
                    n.prev = tail;
                    tail = n;
                }
                else {
                	Node before = p.prev; //for simplifying the operation 
                    before.next = n; //this could be just p.prev.next
                    n.prev = before;
                    n.next = p;
                    p.prev = n;
                }
                ++count;
                return verify();
            }
        }
        return false;
    }
    
   public int getCount() {
	   return count;
   }
   
   public boolean verify() {
	   int counter = 1;
	   for(Node p = head; p != null; p = p.next) {
		   if(p.data != counter) return false;
		   if(p != head && p != tail) {
			   if(p.next == null || p.prev == null) return false;
			   if(p != p.prev.next || p != p.next.prev) return false;
		   }
		   ++counter;
	   }
	   return true;
   }
}
