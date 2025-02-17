package SW문제해결기본4일차_거듭제곱;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/SW문제해결기본4일차_거듭제곱.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int test = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int answer = answer(a, b);
			System.out.println("#" + test + " " + answer);
		}
	}

	public static int answer(int a, int b) {
		if(b<=1) return a; // 2^1
		else {
			return a*answer(a, b-1);
		}
	}

}
