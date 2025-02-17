package 모의SW역량테스트5650핀볼게임;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // N*N
			int[][] arr = new int[N][N];
			int x = -1, y = -1; // 블랙홀의 위치
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j]==-1) x = i; y = j;
				}
			}
			int up = countScore(arr, x, y, 0);
			// 시작 위치는 랜덤으로 설정가능
			// 블랙홀의 위치는 기억해둬야 함
			
			
			int answer = 0;
			System.out.println("#" + test_case + " " + answer);
		}
	}

	public static int countScore(int[][] arr, int x, int y, int dir) {
		int currentX = x;
		int currentY = y;
		int nextX = -1;
		int nextY = -1;
		int[] dirX = {-1, 0, 1, 0}; // 상좌하우
		int[] dirY = {0, -1, 0, 1};
		int score = 0;
		nextX = currentX+dirX[dir]; nextY = currentY+dirY[dir]; // 시작 위치 초기화
		while (currentX!=x && currentX!=y) { // 다시 돌아올 때 끝남
			if (currentX > arr.length-1 || currentX < 0 || currentX > arr.length-1 || currentX < 0 ) { // 범위 벗어남
				score++; // 벽에 부딪힘
				dir = (dir+2)%4; // 반대 방향으로
			}
			if (arr[currentX][currentX]!=0) { // 빈 공간이 아닐 때!
				dir = changeDir(arr[nextX][nextY], currentX, currentY, nextX, nextY, dir);
			}
		}
		return 0;
	}
	public static int changeDir(int block, int x, int y, int nextX, int nextY, int dir) {
		switch(block) {
		case 1 :
			break;
		case 2 :
			break;
		case 3 :
			break;
		case 4 :
			break;
		case 5 :
			dir = (dir+2)%4;
			break;
		}
		return dir;
	}

}
