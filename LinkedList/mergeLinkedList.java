import java.util.*;

class mergeLinkedList{
	int size;
	Node head;
	class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
		}
	}

	void addLast(int d){
		Node n = new Node(d);
		n.next = null;
		
		if(head == null){
			head = n;
		}
		else{
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = n;
		}
		size++;
	}

	void addFirst(int d){
		Node n = new Node(d);
		n.next = null;
		
		if(head == null){
			head = n;
		}
		else{
			Node temp = head;
			n.next = temp;
			head = n;
		}
		size++;
	}

	void addAt(int idx, int d){
		Node temp = head;
		Node n = new Node(d);
		n.next = null;
		try{
			if(idx > size){
				throw new ArrayIndexOutOfBoundsException();
			}
			else if(idx == 0){
				n.next = temp;
				head = n;
				size++;
			}
			else{
				Node t = head;
				for(int i=0;i<idx;i++){
					if(i == idx - 1){
						t = temp;
					}
					temp = temp.next;
				}
				n.next = temp;
				t.next = n;
				size++;
			}
			
		}
		catch(Exception e){
			System.out.println("Index out of bound, Size of array is: "+size);
		}
	}

	void removeLast(){
		Node temp = head;
		if(size == 1){
			head = null;
			size--;
		}
		else if(size == 0){
			System.out.println("List is Empty");
		}
		else{
			for(int i=0;i<=size-2;i++){
				if(i == size-2){
					temp.next = null;
					size--;
					break;
				}
				temp = temp.next;
			}
		}
	}

	void removeFirst(){
		if(head == null){
			System.out.println("List is Empty");
		}
		else if(size == 1){
			head = null;
			size--;
		}
		else{
			Node temp = head;
			head = temp.next;
			size--;
		}
	}

	void removeAt(int idx){
		if(idx > size){
			System.out.println("Index out of Bound");
		}
		else if(idx == 0){
			Node temp = head;
			head = temp.next;
			size--;
		}
		else{
			Node temp = head;
			Node t = head;
			for(int i=0;i<idx;i++){
				if(i == idx-1){
					t = temp;
				}
				temp = temp.next;		
			}
			t.next = temp.next;
			size--;
		}
	}

	void reverse(){
		Node current = head;
		Node prev = null;
		Node next;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	int size(){
		return size;
	}

	void sort(){
		for(int i=0;i<size-1;i++){
			Node temp = head;
			Node curr = head.next;
			for(int j=0;j<size-1;j++){	
				if(temp.data > curr.data){
					int val = temp.data;
					temp.data = curr.data;
					curr.data = val;
				}
				temp = temp.next;
				curr = curr.next;
			}
		}
	}

	int sizeRecursive(){
		int count = sizeRecursive(head,0);
		return count;
	}

	int sizeRecursive(Node head,int count){
		if(head == null){
			return count;
		}
		
		return sizeRecursive(head.next,count+1);
		
	}

	boolean search(int n){
		return search(head,n);
	}

	boolean search(Node head, int n){
		if(head == null){
			return false;
		}
		if(head.data == n){
			return true;
		}
		
		return search(head.next,n);
		
	}

	void mergeTwoList(mergeLinkedList lst1, mergeLinkedList lst2){
			Node temp1 = lst1.head;
			Node temp2 = lst2.head;

			while(temp1 != null && temp2 != null){
				if(temp1.data < temp2.data){
					addLast(temp1.data);
					temp1 = temp1.next;
				}
				else{
					addLast(temp2.data);
					temp2 = temp2.next;
				}
			}
			
			while(temp1 != null){
				addLast(temp1.data);
				temp1 = temp1.next;
			}
			
			while(temp2 != null){
				addLast(temp2.data);
				temp2 = temp2.next;
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
		mergeLinkedList lst = new mergeLinkedList();
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter size of List 1");
		int n = scn.nextInt();

		System.out.println("Enter elements of 1st list");

		mergeLinkedList lst1 = new mergeLinkedList();
		for(int i=0;i<n;i++){
			int val = scn.nextInt();
			lst1.addLast(val);
		}

		System.out.println("Enter size of 2nd List");
		n = scn.nextInt();

		System.out.println("Enter elements of 2nd list");

		mergeLinkedList lst2 = new mergeLinkedList();
		for(int i=0;i<n;i++){
			int val = scn.nextInt();
			lst2.addLast(val);
		}
		lst.mergeTwoList(lst1,lst2);
		lst.display();
		System.out.println(lst.sizeRecursive());
		System.out.println(lst.search(4));
	}

}