import java.util.*;

class LinkedList{
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

	int getAt(int idx){
		try{
			if(idx > size){
				throw new ArrayIndexOutOfBoundsException();
			}
			else{
				return getAt(head,idx,0);
			}
		}
		catch(Exception e){
			System.out.println("Index not found");
		}
		return Integer.MIN_VALUE;
	}

	int getAt(Node head, int idx,int cIdx){
		if(idx == cIdx){
			return head.data;
		}
	
		return getAt(head.next,idx,cIdx+1);
	}

	int nthFromLast(int n){
		if(n > size){
			System.out.println("Value is greater than size");
			return Integer.MIN_VALUE;
		}
		else{
			Node temp = head;
			for(int i=0;i<size-n;i++){
				temp = temp.next;
			}
			return temp.data;
		}
	}

	int middleElement(){
		Node slow = head;
		Node fast = head;
		if(head == null){
			System.out.println("List is Empty");
			return Integer.MIN_VALUE;
		}
		else{
			while(fast!=null && fast.next!=null){
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow.data;
		}
		
	}

	int countOfNumber(int n){
		return countOfNumber(head,n,0);
	}

	int countOfNumber(Node head, int n, int count){
		if(head == null){
			return count;
		}
		
		if(head.data == n){
			return countOfNumber(head.next,n,count+1);
		}
		else{
			return countOfNumber(head.next,n,count);
		}
	}

	boolean detectLoop(){
		Node slow = head;
		Node fast = head;
		while(slow != null && fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}

	boolean detectLoopList(){
		return detectLoopList(head);
	}

	boolean detectLoopList(Node head){
		LinkedList l = new LinkedList();
		for(int i=0;i<size;i++){
			l.addLast(0);
		}
		Node temp = head;
		Node temp2 = l.head;
		while(temp != null){
			if(temp2.data == 1){
				return true;
			}
			temp2.data = 1;
			temp = temp.next;
			temp2 = temp2.next;
		}
		
		return false;
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
	
	int size(){
		return size;
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

	void display(){
		Node temp = head;
		for(int i=0;i<size;i++){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}	
	
	public static void main(String[] args){
		LinkedList lst = new LinkedList();
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		while(n!=0){
			System.out.println("1: Add Last                  9: Sort");
			System.out.println("2: Add First                 10: N'th element from last");
			System.out.println("3: Add At                    11: Middle element of list");
			System.out.println("4: Remove Last               12: Frequency of a Number");    
			System.out.println("5: Remove First              13: Search");
			System.out.println("6: Remove At                 14: Detect Loop");
			System.out.println("7: Get At                    15: Size");
			System.out.println("8: Reverse                   16: Display");

			int c = scn.nextInt();
			switch(c){
				case 1: 
					System.out.println("Enter Value");
					int num = scn.nextInt();
					lst.addLast(num);
					break;
				case 2:
					System.out.println("Enter Value");
					int num1 = scn.nextInt();
					lst.addFirst(num1);
					break;
				case 3:
					System.out.println("Enter Index");
					int idx = scn.nextInt();
					System.out.println("Enter Value");
					int num3 = scn.nextInt();
					lst.addAt(idx,num3);
					break;
				case 4:
					lst.removeLast();
					break;
				case 5:
					lst.removeFirst();
					break;
				case 6:
					System.out.println("Enter Index");
					int idx1 = scn.nextInt();
					lst.removeAt(idx1);
					break;
				case 7:
					System.out.println("Enter Index");
					int idx2 = scn.nextInt();
					System.out.println(lst.getAt(idx2));	
					break;
				case 8:
					lst.reverse();
					break;
				case 9:
					lst.sort();
					break;
				case 10:
					System.out.println("Input the value of n");
					int no = scn.nextInt();
					System.out.println(lst.nthFromLast(no));
					break;
				case 11:
					System.out.println(lst.middleElement());
					break;
				case 12:
					System.out.println("Enter the Number");
					System.out.println(lst.countOfNumber(scn.nextInt()));
					break;
				case 13:
					System.out.println("Enter number to be searched");
					int number = scn.nextInt();
					boolean ans = lst.search(number);
					System.out.println(ans);
					break;
				case 14:
					//lst.head.next.next.next.next = lst.head;
					System.out.println(lst.detectLoop());
					break;
				case 15:
					int count = lst.sizeRecursive();
					System.out.println(count);
					break;
				case 16:
					lst.display();
					break;
				default: 
					System.out.println("Invalid");
			}
			System.out.println("Enter 0 to quit and 1 to continue");
			int no = scn.nextInt();
			n = no;
		}
	}

}