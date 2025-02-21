package SW문제해결기본9일차_Heap;
// 연산1. 자연수 X를 삽입
// 연산2. 최대 힙의 루트 노드의 키 값을 출력하고 해당 노드를 삭제

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	static int[] heap;
	static int heapSize;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/SW문제해결기본9일차_Heap.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 1<=N<=10^5 수행해야 하는 연산의 수
			// 연산 1 : 2개의 자연수 1 x, x(1<=X<=10^9)을 최대 힙에 추가하느 ㄴ연산
			// 연산 2 : 1개의 자연수 2, 현재 최대 힙의 루트 노드의 키 값을 출력하고 해당 노드 삭제
			heap = new int[N+1]; // 최대 N개의 자연수 삽입 가능
			heapSize=0;
			System.out.print("#" + test_case+" ");
			for (int i = 0; i<N; i++) { // 연산을 수행하는 과정
				StringTokenizer st = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(st.nextToken());
				if (order == 1) {
					int x = Integer.parseInt(st.nextToken());
					addHeap(x);
				} else {
					System.out.print(popHeap()+" ");
				}
			}
			System.out.println();
		}
	}
	public static void addHeap(int x) {
		heap[++heapSize] = x; // 가장 마지막에 넣기
		sortHeap(heapSize); // 정렬 수행
	}
	public static int popHeap() {
		if (heapSize==0) return -1; // 없으면 -1로 
		int item = heap[1];
		heap[1] = heap[heapSize--];  /////////// 이 조건 빼먹었음
		sortHeap2(1);
		return item;
	}
	public static void sortHeap(int index) {
		if (index==1 || heap[index] < heap[index/2]) return; // 조건문에서 현재 나의 조건 X 내 부모나 자식 조건 보기
		if (heap[index] > heap[index/2]) { // 자식 < 부모일 때 swap
			int tmp = heap[index/2];
			heap[index/2] = heap[index];
			heap[index] = tmp;
			sortHeap(index/2); //부모로
		}
	}
	public static void sortHeap2(int index) {
		if (index*2>heapSize) return;
		int ch = index*2; // 왼쪽 자식
		if (index*2+1 <=heapSize && heap[index*2] < heap[index*2+1]) {
			ch = index*2+1;
		}
		if (heap[ch] > heap[index]) { // 자식 > 부모일 때 swap
			int tmp = heap[index];
			heap[index] = heap[ch];
			heap[ch] = tmp;
		}
		sortHeap2(ch); // 자식으로
	}

}
