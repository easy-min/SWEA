package 문제7102준홍이의카드놀이;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution3 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제7102준홍이의카드놀이.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 카드 1번덱
			int M = sc.nextInt(); // 카드 2번덱
			Queue<Integer> answer = preventNum(test_case, N, M);
			System.out.print("#"+test_case+" ");
			for (int num : answer) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}
	public static Queue<Integer> preventNum(int test_case, int N, int M) {
		int[] arr = new int[N+M];
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<M; j++) {
				arr[i+j+1]++;
			}
		}
		int maxCount = -1;
		for (int i = 0; i<arr.length; i++) {
			maxCount = Math.max(maxCount, arr[i]);
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i<arr.length; i++) {
			if (maxCount == arr[i]) queue.add(i+1);
		}
		return queue;
		
	}

}
