package 문제1954달팽이숫자;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution2 {
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
		int[][] arr = new int[N][N]; // 정사각형 모양을 만들기
		int[] dr = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
		int[] dc = {1, 0, -1, 0};
		int r = 0; int c = 0; int d = 0; // (r,c) d는 방향
		for (int i = 1; i<=N*N; i++) {
			arr[r][c] = i;
			int nextR = r + dr[d];
			int nextC = c + dc[d];
			if (nextR<0 || nextR > N-1 || nextC<0 || nextC > N-1 || arr[nextR][nextC]!=0) {
				d = (d+1)%4;
				nextR = r + dr[d];
				nextC = c + dc[d];
			}
			r = nextR;
			c = nextC;
		}
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
