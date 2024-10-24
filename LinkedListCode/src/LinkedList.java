
public class LinkedList
{
    private Node head;
    private Node tail;
    private int count;
    
    private static class Node {
        int data;
        Node next;
        
        public Node(int i, Node n) {
            next = n;
            data = i;
        }
    }
    public LinkedList() {
    	createList();
    }
    
    public void createList() {
    	head = new Node(1, null);
        Node follow = head;
        Node p = null;
        for(int i = 2; i <= 10; ++i) {
        	if(i == 4) continue;
            p = new Node(i, null);
            follow.next = p;
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
        Node follow = null;
        Node n = new Node(toAdd, null);
        for(Node p = head; p != null; follow = p, p = p.next) {
            if(p.data >= toAdd) {
                if(p == head) {
                    n.next = head;
                    head = n;
                }
                if(p == tail) {
                    tail.next = n;
                    tail = n;
                }
                else {
                    follow.next = n;
                    n.next = p;
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
		   if(p != tail && p.next == null) return false;
		   ++counter;
	   }
	   return true;
   }
}
