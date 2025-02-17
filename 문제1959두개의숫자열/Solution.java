package 문제1959두개의숫자열;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제1959두개의숫자열.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 3 <= N <= 30
			int M = sc.nextInt(); // 3 <= M <= 30
			int[] A = new int[N];
			int[] B = new int[M];
			for (int i = 0; i<N; i++) {				A[i] = sc.nextInt();			}
			for (int i = 0; i<M; i++) {				B[i] = sc.nextInt();			}
			int answer = 0;
			if (N - M > 0) { // N이 더 김
				for (int i = 0; i < N - M + 1; i++) {
					int ans = sumofNums(A, B, i);
					answer = (ans > answer ? ans : answer);
				}
			} else if (N - M == 0) { // 선택지 X
				answer = sumofNums(A, B, 0);
			} else {
				for (int i = 0; i < M - N + 1; i++) {
					int ans = sumofNums(B, A, i);
					answer = (ans > answer ? ans : answer);
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}

	public static int sumofNums(int[] first, int[] second, int index) {
		int answer = 0;
		for (int i = 0; i < second.length; i++) { // 작은 것을 기준으로 돌기
			answer += first[i+index] * second[i];
		}
		return answer;
	}
}
