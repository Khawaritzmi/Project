package s;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SingleLinkedList sll = new SingleLinkedList();

		int n = input.nextInt();

		for (int i = 0; i < n; i++) {
			
			int data = input.nextInt();
			sll.insertBeginning(data);
		}

		
	// 	sll.insertBeginning(23);
	// 	sll.insertBeginning(33);
	// 	sll.insertBeginning(23);
	// 	sll.insertBeginning(11);
	// 	sll.insertBeginning(11);
	// 	sll.insertBeginning(9);
	// 	sll.printAllNode();
	// 	sll.countNode();
	// 	sll.printMid();

	}
	
	// private static final Scanner scanner = new Scanner(System.in);
	// private static SingleLinkedList sll;
	// public static void main(String[] args) {
		
	// 	sll = new SingleLinkedList();
	// 	int choice = -1;
	// 	while(choice != 0) {
	// 		printMenu();
	// 		choice = scanner.nextInt();
	// 		switch (choice) {
	// 			case 1:
	// 				int data = scanner.nextInt();
	// 				sll.insertBeginning(data);
	// 				break;
	// 			case 2:
	// 				data = scanner.nextInt();
	// 				int position = scanner.nextInt();
	// 				sll.insertMiddle(data, position);
	// 				break;
	// 			case 3:
	// 				data = scanner.nextInt();
	// 				sll.insertLast(data);
	// 				break;
	// 			case 4:
	// 				sll.deleteBeginning();
	// 				break;
	// 			case 5:
	// 				position = scanner.nextInt();
	// 				sll.deleteMiddle(position);
	// 				break;
	// 			case 6:
	// 				sll.deleteLast();
	// 				break;
	// 			case 7:
	// 				sll.deleteduplicate();
	// 				break;
	// 		}	
	// 	}
		
		
	// }
	
	// private static void printMenu() {
	// 	System.out.println("Current List: ");
	// 	sll.printAllNode();
	// 	System.out.println("1. Insert Beginning");
	// 	System.out.println("2. Insert Middle");
	// 	System.out.println("3. Insert Last");
	// 	System.out.println("4. Delete Beginning");
	// 	System.out.println("5. Delete Middle");
	// 	System.out.println("6. Delete Last");
	// 	System.out.println("7. Delete Duplicate");
	// 	System.out.println("0. Exit");
	// 	System.out.print(">> ");
	// }
}
class SingleLinkedList {
	private Node head;
	
	void insertBeginning(int data) {
		if(head == null)
			head = new Node(data);
		else {
			Node node = new Node(data);
			node.next = head;
			head = node;
		}
			
	}
	
	void insertMiddle(int data, int position) {
		if(position < 0) {
			return;
		}
		if(position == 0) {
			insertBeginning(data);
		} else if(position == getLength() - 1) {
			insertLast(data);
		} else {
			if(position >= getLength())
				return;
			int index = 0;
			Node node = head;
			while(node != null && index != position - 1) {
				node = node.next;
				index++;
			}
			Node temp = node.next;
			node.next = new Node(data);
			node.next.next = temp;
		}
	}
	
	void insertLast(int data) {
		Node node = head;
		if(node == null) {
			head = new Node(data);
			return;
		}
		while(node.next != null) {
			node = node.next;
		}
		node.next = new Node(data);
	}
	
	void deleteBeginning() {
		if(head != null)
			head = head.next;
	}
	
	void deleteMiddle(int position) {
		if(position < 0 || position >= getLength()) {
			return;
		}
		if(position == 0) {
			deleteBeginning();
		} else if(position == getLength() - 1) {
			deleteLast();
		} else {
			int index = 0;
			Node node = head;
			while(node != null && index != position - 1) {
				node = node.next;
				index++;
			}
			node.next = node.next.next;
		}
	}
	
	void deleteLast() {
		Node node = head;
		if(node == null)
			return;
		if(node.next == null) {
			head = null;
			return;
		}
		while(node.next.next != null)
			node = node.next;
		node.next = null;
		
	}

	// void deleteData(int data){
	// 	Node curr = head;
	// 	while (curr.next != null) {
	// 		if(curr.next.data == data){
	// 			curr.next = curr.next.next;

	// 		}
	// 		curr = curr.next;
	// 	}
	// }

	// void deleteduplicate(){
	// 	Node curr = head;
	// 	Node temp = head;
	// 	while (temp != null) {
	// 		while (curr != null) {
	// 			if (curr.data == temp.data) {
	// 				deleteData(temp.data);
	// 			}
	// 			curr = curr.next;
	// 		}
	// 		temp = temp.next;
	// 	}
	// }

	int countNode(){
		Node curr = head;
		int jumlah = 1;
		while (curr != null){
			if(curr.next == null){
				break;
			}
			jumlah++;
			curr = curr.next;
		}
		// System.out.println(jumlah);
		return jumlah;
	}

	void printMid(){
		Node curr = head;
			if (curr.next == null){
				System.out.println(curr.data);
			}
			int x = countNode();
			int bagi = x/2;
			for (int i = 0; i < bagi; i++) {
				curr = curr.next;
			}
			System.out.println(curr.data);

		
	}
	
	void printAllNode() {
		Node node = head;
		while(node != null) {
			System.out.print(node.data + " --> ");
			node = node.next;
		}
		System.out.println("null");
	}

	int getLength() {
		int length = 0;
		Node node = head;
		while(node != null) {
			length++;
			node = node.next;
		}
		return length;
	}
}


class Node {
	Node next;
	int data;
	Node(int data) {
		this.data = data;
	}
}



