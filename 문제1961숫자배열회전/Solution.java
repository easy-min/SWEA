package 문제1961숫자배열회전;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제1961숫자배열회전.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // nxn
			int[][] arr = new int[N][N];
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println("#"+test_case);
			clock(arr, 0);
		}
	}
	public static void clock(int[][] arr, int dir) {
		int N = arr.length;
		for (int i = 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				System.out.print(arr[arr.length-j-1][i]);
			}
			System.out.print(" ");
			for (int j = 0; j<N; j++) {
				System.out.print(arr[arr.length-i-1][arr.length-j-1]);
			}
			System.out.print(" ");
			for (int j = 0; j<N; j++) {
				System.out.print(arr[j][arr.length-i-1]);
			}
			System.out.println();
		}
	}

}
