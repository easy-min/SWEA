package 문제1966숫자를정렬하자;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	static final int INF = -1000000;

	static public class Node {
		private int data;
		private Node prev;
		private Node next;

		public Node(int item) {
			this.data = item; // prev, next는 null로 생성
		}
	}

	static public class SingleLinkedList {
		private int size;
		private Node head;

		public SingleLinkedList() { // 전부 0 또는 null로 초기화
		}

		// 찾기
		public Node get(int idx) {
			// idx가 0보다 작은 부분 뿐만 아니라 범위를 초과할 때도 예외처리!!!!!!!!
			if (size == 0 || idx >= size)
				return null;
			Node curr = head;
			for (int i = 0; i < idx; i++)
				curr = curr.next;
			return curr;
		}

		// 추가
		public void addFirst(int item) {
			Node node = new Node(item);
			node.next = head;
			head = node;
			size++;
		}

		public void addLast(int item) {
			if (size == 0)
				addFirst(item); // 아무것도 없다면 첫번째에 삽입하는 것과 다르지 않음
			else {
				Node node = new Node(item);
				Node prevNode = get(size - 1);
				prevNode.next = node;
				size++;
			}
		}

		public void add(int idx, int item) {
			if (idx < 0 || idx > size)
				return;
			if (idx == 0) {
				addFirst(item);
			} else if (idx == size) {
				addLast(item);
			} else {
				Node node = new Node(item);
				Node prevNode = get(idx - 1);
				Node nextNode = prevNode.next;
				node.next = nextNode;
				prevNode.next = node;
				size++; // 이미 addFirst()와 addLast()에서 size가 증가할 것이기 때문에 여기에만 더하기
			}
		}
		
		public void findLocation(int item) {
			// 들어올 때부터 정렬하면 되잖앙
			if (size==0) addFirst(item); // 아무것도 없다면 첫 번째에 넣어요
			else {
				int i;
				for (i = size-1; i>=0; i--) {
					// get(size)을 호출하면 null을 반환하면서 NullPointerException이 발생
					Node currNode = get(i); // 가장 뒤의 노드부터 차례로..
					if (currNode.data < item) break;
				}
				add(i+1, item);
			}
			
		}

		public int removeFirst() {
			if (size == 0)
				return INF;
			int data = head.data; // 현재 head가 가리키고 있는 데이터
			head = head.next; // head는 그 다음 항목으로 이동하기
			size--;
			return data;
		}

		public int remove(int idx) {
			if (size == 0 || idx > size - 1)
				return INF;
			if (idx == 0)
				return removeFirst(); // 이 부분 처리 까먹음!!
			Node prevNode = get(idx - 1);
			int data = prevNode.next.data;
			prevNode.next = prevNode.next.next;
			size--;
			return data;
		}

		public void printArray() {
			Node currNode = head;
			while (currNode != null) {
				System.out.print(currNode.data + " ");
				currNode = currNode.next;
			}
		}
	}

	static public class DoubleLinkedList {
		private int size;
		private Node head;
		private Node tail;

		public DoubleLinkedList() { // 알아서 초기화
		}

		public Node get(int idx) {
			if (size == 0) return null;
			// head와 tail을 동시에 쓰기 때문에 생각해보자
			Node currNode;
			if (idx < size / 2) { // 절반보다 앞에 있다면 head를 쓰자
				currNode = head;
				for (int i = 0; i < idx; i++)
					currNode = currNode.next;

			} else {
				currNode = tail;
				for (int j = size - 1; j > idx; j--) 
					/*
					 * j >= idx 가 아니라 j>idx이다. =포함하면 한 번 더 뒤로 감
					 */
					currNode = currNode.prev;
			}
			return currNode;
		}

		public void addFirst(int item) {
			Node node = new Node(item);
			if (size == 0) {
				head = node;
				tail = node;
			} else {
				node.next = head;
				head.prev = node;
				head = node;
			}
			size++;
		}

		public void addLast(int item) {
			if (size==0) {
				addFirst(item);
				return;
			}
			Node node = new Node(item);
			node.prev = tail;
			tail.next = node;
			tail = node;
			size++;
		}
		public void add(int idx, int item) {
			if (idx<0 || idx > size) return;
			else if (idx==0) addFirst(item);
			else if (idx==size) addLast(item);
			else {
				Node prevNode = get(idx-1);
				Node nextNode = prevNode.next;
				Node node = new Node(item);
				node.next = nextNode;
				nextNode.prev = node;
				node.prev = prevNode;
				prevNode.next = node;
				size++;	
			}
		}
		
		public void findLocation(int item) {
			if (size==0) addFirst(item);
			else {
				int i;
				for (i = size-1; i>=0; i--) {
					Node currNode = get(i);
					if (currNode.data < item) break;
				}
				add(i+1, item);
			}
		}
		
		public int removeFirst() {
			if (size==0) return INF;
			int data = head.data;
			head = head.next;
			if (head != null) head.prev = null; // 여기 빼먹음!!
			size--;
			if (size==0) tail = null; //리스트가 비었다면 tail도 null로 설정
			return data;
		}
		public int removeLast() {
			if (size==0) return INF;
			if (size==1) return removeFirst();
			int data = tail.data;
			tail.prev.next = null;
			tail = tail.prev;
			size--;
			return data;
		}
		
		public int remove(int idx) {
			if (size==0) return INF;
			if (idx == 0) return removeFirst();
			if (idx == size-1) return removeLast();
			Node prevNode = get(idx-1);
			Node nextNode = prevNode.next.next; // 이제 중간에 있는건 빠질 거니깐
			// 그렇지만 nextNode가 null일 때도 생각을 해야 함
			int data = prevNode.next.data;
			nextNode.prev = prevNode;
			prevNode.next = nextNode;
			size--;
			return data;
		}
		public void printArray() {
			Node currNode = head;
			while (currNode != null) {
				System.out.print(currNode.data + " ");
				currNode = currNode.next;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제1966숫자를정렬하자.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			SingleLinkedList arr1 = new SingleLinkedList();
			DoubleLinkedList arr2 = new DoubleLinkedList();
			
			int N = sc.nextInt(); // 5<=N<=50
			for (int i = 0; i<N; i++) {
//				arr1.findLocation(sc.nextInt());
				arr2.findLocation(sc.nextInt());
			}
			System.out.print("#" + test_case+" ");
//			arr1.printArray();
			arr2.printArray();
			System.out.println();

			
			
			
			
			
		}
	}


}
