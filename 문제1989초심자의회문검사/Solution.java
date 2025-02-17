package 문제1989초심자의회문검사;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제1989초심자의회문검사.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			String text = sc.nextLine();
			int answer = findPalindrome(text);
			System.out.println("#" + test_case + " " + answer);
		}
	}
	public static int findPalindrome(String text) {
		int N = text.length(); // 3<=N<=10;
		char[] t = text.toCharArray();
		for (int i = 0; i<N/2; i++) {
			if (t[i]!=t[N-1-i]) return 0;
		}
		return 1;
	}
}
