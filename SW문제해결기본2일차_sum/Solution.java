package SW문제해결기본2일차_sum;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/SW문제해결기본2일차_sum.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int test = sc.nextInt();
			int[][] nums = new int[100][100]; // 100x100으로 동일
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					nums[i][j] = sc.nextInt();
				}
			}
			int answer = maxNum(nums, 100);

			System.out.println("#" + test_case + " " + answer);
		}
	}

	public static int maxNum(int[][] nums, int N) {
		// (0,0) 좌표기준 대각선 확인
		int answer = -1;
		int count = 0;
		for (int i = 0; i < N; i++) {
			count += nums[i][i];
		}
		answer = (count > answer ? count : answer);
		count = 0;
		// (99, 0) 좌표 기준 대각선 확인
		for (int i = N - 1; i >= 0; i--) {
			count += nums[N-i-1][i];
		}
		answer = (count > answer ? count : answer);
		
		
		
		// (0,0) (99,0) 행 확인
		// (0,0) (0,99) 열 확인
		for (int i = 0; i < N; i++) {
			int rowCount = 0;
			int columnCount = 0;
			for (int j = 0; j < N; j++) { // 열 증가
				rowCount += nums[i][j];
				columnCount += nums[j][i];
			}
			answer = Math.max(answer, Math.max(rowCount, columnCount));
		}


		return answer;
	}
}
