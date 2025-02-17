package 문제5653줄기세포배양;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 세로 크기
			int M = sc.nextInt(); // 가로 크기
			int K = sc.nextInt(); //배양시간 : 300 이하
			int[][] arr = new int[N+400][M+400];
			for (int i = 150; i<N; i++) {
				for (int j = 150; j<M; j++) { // 2시간 마다 한 번씩 번식함
					arr[i][j] = sc.nextInt();
				}
			}
			int answer = 0;
			System.out.println("#" + test_case + " " + answer);
		}
	}
	public static void aliveBlock(int[][] arr) {
		
		
	}

}
