
public class Driver {
	public static void main(String[] args) {
		LinkedList linky = new LinkedList();
		if(!linky.add(4))
			System.out.println("linky add failed");
		DoublyLinkedList dLinky = new DoublyLinkedList();
		if(!dLinky.add(4))
			System.out.println("dLinky add failed");
		System.out.println("Both added correctly!");
	}
}
