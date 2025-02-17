package 문제1954달팽이숫자;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution3 {
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
		int[][] arr = new int[N][N];
		int[] dx = {0, -1, 0, 1}; // 우 하 좌 상
		int[] dy = {1, 0, -1, 0};
		int dir = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i<N*N; i++) {
			arr[x][y] = i;
			int nextX = x+dx[dir];
			int nextY = y+dy[dir];
			if (nextX<0 || nextX > N-1 || nextY <0 || nextY> N-1 || arr[nextX][nextY] !=0) {
				dir = (dir+1)%4;
			}
			x = x+dx[dir];
			y = y+dy[dir];
		}
		
	}
}
