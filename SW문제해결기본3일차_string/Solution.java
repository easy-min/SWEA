package SW문제해결기본3일차_string;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/SW문제해결기본3일차_string.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int test = sc.nextInt();
			sc.nextLine();
			int N = 100;
			char[][] arr = new char[N][N];

			for (int i = 0; i < N; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j);
				}
			} // 문자 입력받기
			// 각 줄(또는 열)마다 회문 검색하기 vs 각 [][] 포인트마다 회문 검색하기
			int answer = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					answer = Math.max(answer, count(arr, i, j));
				}
			}
			System.out.println("#" + test + " " + answer);
		}
	}

	public static int count(char[][] arr, int column, int row) { // 열과 행에서 회문 검색 (대각선 제외)
		int maxColumn = 1;
		int maxRow = 1;
		for (int i = 1; i < arr.length - column + 1; i++) {  // len < N - 현재위치 + 1;
		    if (isPalindromeColumn(arr, column, row, i)) maxColumn = i; // 열에서 최대 회문 길이
		}
		for (int i = 1; i < arr.length - row + 1; i++) { 
		    if (isPalindromeRow(arr, column, row, i)) maxRow = i; // 행에서 최대 회문 길이
		}
		return Math.max(maxColumn, maxRow); // 최대 회문의 길이 
	}

	public static boolean isPalindromeRow(char[][] arr, int column, int row, int len) {
		for (int i = 0; i < len / 2; i++) { // 0부터 최대 회문의 길이까지 회문이 성립하는지 return
			if (arr[column][row + i] != arr[column][row + len - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindromeColumn(char[][] arr, int column, int row, int len) {
		for (int i = 0; i < len / 2; i++) {
			if (arr[column + i][row] != arr[column + len - 1 - i][row]) {
				return false;
			}
		}
		return true;
	}
}
