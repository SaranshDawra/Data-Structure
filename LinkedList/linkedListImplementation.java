import java.util.*;

class linkedListImplementation{
	Node head;
	int size;
	class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
		}
	}

	void addLast(int d){
	
		if(head == null){
			Node n = new Node(d);
			n.next = null;
			head = n;
			size++;
		}

                else{
			Node temp = head;
			for(int i=0;i<size;i++){
				if(temp.next == null){
					Node n = new Node(d);
					n.next = null;
					temp.next = n;
					size++;
				}
				else{
					temp = temp.next;
				}
			}
		}
	}

	void addFirst(int d){
		if(head == null){
			Node n = new Node(d);
			n.next = null;
			head = n;
			size++;
		}
		else{
			Node temp = head;
			Node n = new Node(d);
			n.next = temp;
			head = n;
			size++;
		}
	}

	void addAt(int idx,int d){
		if(size < idx){
			System.out.println("Array Index Out of Bound, Size of array is: "+size);
			return;
		}
		else if(idx == 0){
			Node temp = head;
			Node n = new Node(d);
			n.next = temp;
			head = n;
			size++;
		}
		else{
			Node temp = head;
			for(int i=0;i<size;i++){
				if(i == idx){
					Node n = new Node(d);
					Node t = temp;
					n.next = temp.next;
					temp.next = n;
					size++;
				}
				temp = temp.next; 
			}
		}
	}

	void display(){
		Node temp = head;
		for(int i=0;i<size;i++){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args){
		linkedListImplementation lst = new linkedListImplementation();
		Scanner scn = new Scanner(System.in);
		lst.addLast(100);
		lst.addFirst(10);
		lst.addAt(1,20);
		lst.addLast(200);
		lst.display();
	}
}
