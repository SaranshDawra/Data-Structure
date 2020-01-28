import java.util.*;

class circularLL{
	Node head;
	Node tail;
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
			head = n;
			tail = n;
			n.next = head;
		}
		else{
			Node n = new Node(d);
			tail.next = n;
			tail = n;
			n.next = head;
		}
		size++;
	}

	void addFirst(int d){
		if(head == null){
			Node n = new Node(d);
			head = n;
			tail = n;
			n.next = head;
		}
		else{
			Node n = new Node(d);
			n.next = head;
			head = n;
			tail.next = head;
		}
		size++;
	}

	void addAt(int idx,int d){
		try{
			if(idx > size){
				throw new ArrayIndexOutOfBoundsException();
			}
			else if(idx == 0){
				if(size == 0){
					Node n = new Node(d);
					head = n;
					tail = n;
					n.next = head;	
					size++;
				}
				else{
					Node n = new Node(d);
					//Node next = head;
					n.next = head;
					head = n;
					tail.next = n;
					size++;
				}
			}
			else if(idx == size-1){
				Node n = new Node(d);
				tail.next = n;
				tail = n;
				n.next = head;
				size++;
			}
			else{
				Node temp = head;
				for(int i=0;i<size;i++){
					if(i == idx-1){
						Node n = new Node(d);
						Node t = temp;
						n.next = t.next;
						temp.next = n;
						size++;
						break;
					}
					temp = temp.next;
				}
			}
		}
		catch(Exception e){
			System.out.println("Index Not Found");
		}
	}

	void removeFirst(){
		try{
			if(head == null){
				throw new ArrayIndexOutOfBoundsException();
			}
			else if(size == 1){
				head = null;
				tail = null;
				size--;
			}
			else{
				Node temp = head.next;
				tail.next = temp;
				head = temp;
				size--;
			}
		}
		catch(Exception e){
			System.out.println("List is Empty");
		}
	}

	void removeLast(){
		try{
			if(head == null){
				throw new ArrayIndexOutOfBoundsException();
			}
			else if(size == 1){
				head = null;
				tail = null;
				size--;
			}
			else{
				Node temp = head;
				for(int i=0;i<size-2;i++){
					temp = temp.next;
				}
				temp.next = head;
				tail = temp;
				size--;
			}
		}
		catch(Exception e){
			System.out.println("List is Empty");
		}
	}

	void removeAt(int idx){
		try{
			if(idx >= size){
				throw new ArrayIndexOutOfBoundsException();
			}
			else if(idx == 0){
				if(size == 1){
					head = null;
					tail = null;
					size--;
				}
				else{
					Node temp = head.next;
					tail.next = temp;
					head = temp;
					size--;
				}
			}
			else if(idx == size - 1){
				if(size == 1){
					head = null;
					tail = null;
					size--;
				}
				else{
					Node temp = head;
					for(int i=0;i<size-2;i++){
						temp = temp.next;
					}
					temp.next = head;
					tail = temp;
					size--;
				}
			}
			else{
				Node temp = head;
				for(int i=0;i<size;i++){
					if(i == idx-1){
						temp.next = temp.next.next;
						break;
					}
					temp = temp.next;
				}
				size--;
			}
		}
		catch(Exception e){
			System.out.println("Index Out of Bounds");
		}
	}

	void display(){
		Node temp = head;
		for(int i=0;i<size;i++){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args){
		circularLL lst = new circularLL();
//		lst.addFirst(20);
//		lst.addFirst(10);
//		lst.addLast(30);
//		lst.addLast(40);
//		lst.addAt(0,1);
//		lst.addAt(4,100);
//		lst.addAt(2,50);
//		lst.display();
//		lst.removeFirst();
//		lst.removeFirst();
//		lst.removeFirst();
//		lst.display();
//		lst.removeFirst();
//		lst.display();
//		lst.addLast(10);
//		lst.display();
//		lst.removeLast();
//		lst.display();
//		lst.removeAt(1);
//		lst.display();
		lst.addAt(0, 10);
		lst.addAt(1, 20);
		lst.addAt(2, 30);
		lst.addAt(3, 40);
		lst.display();
		lst.removeFirst();
		lst.display();
		lst.addFirst(10);
		lst.display();
		lst.addLast(50);
		lst.display();
	}
	
}