package 문제1954달팽이숫자;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 달팽이 숫자의 length
			System.out.println("#"+test_case);
			snail(N);
		}
	}

	public static void snail(int N) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int[][] nums = new int[N][N];
		boolean changeDir = false;
		int k = N; // 출력할 수 있는 수
		int x = 0;
		int y = -1; // 지금 현재 위치
		int count = 1;
		while (k>0) {
			for (int i = 0; i < k; i++) { // 가로 -> 세로
				x = x + dr[3];
				y = y + dc[3];
				nums[x][y] = count++;
			}
			k--;
			for (int i = 0; i < k; i++) { // 세로 -> 가로
				x = x + dr[1];
				y = y + dc[1];
				nums[x][y] = count++;
			}
			for (int i =0; i<k; i++) {
				x = x + dr[2];
				y = y + dc[2];
				nums[x][y] = count++;
			}
			k--;
			for (int i = 0; i < k; i++) {
				x = x + dr[0];
				y = y + dc[0];
				nums[x][y] = count++;
			}
		}
		for (int i = 0; i<N; i++){
			for (int j = 0; j<N; j++) {
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}

	}
}
