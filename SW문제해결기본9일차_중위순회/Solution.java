package SW문제해결기본9일차_중위순회;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
	static String[] parent;
	static int[] leftChild;
	static int[] rightChild;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/SW문제해결기본9일차_중위순회.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 이진 트리로 주어짐 (마지막 노드를 제외하고 전부 꽉 차 있음.)
			int N = Integer.parseInt(br.readLine());
			parent = new String[N+1];
			leftChild = new int[N+1];
			rightChild = new int[N+1];
			for (int i = 0; i<N; i++) { // n줄에 걸쳐서 입력이 주어짐
				String s = br.readLine();
				String[] arr = s.split(" ");
				int index = Integer.parseInt(arr[0]);
				parent[index] = arr[1];
				if (arr.length == 4) { // 왼쪽, 오른쪽 자식 존재
					leftChild[index] = Integer.parseInt(arr[2]);
					rightChild[index] = Integer.parseInt(arr[3]);
				} else if (arr.length == 3) { // 왼쪽 자식만 존재
					leftChild[index] = Integer.parseInt(arr[2]);
				}// leaf 노드는 기본 생성 값이 0이기 때문에 건너 뜀
			} // 입력

			System.out.print("#" + test_case + " ");
			inOrder(1); // 1번 루트 노드부터 시작
			System.out.println();
		}
	}
	public static void inOrder(int index) {
		if (index==0) return; // 자식이 없는 경우 종료
		inOrder(leftChild[index]);
		System.out.print(parent[index]);
		inOrder(rightChild[index]);
	}

}
