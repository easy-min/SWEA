package SW문제해결기본4일차_거듭제곱;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution2 {
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
	static int[] memo = new int[100];
	static {
		Arrays.fill(memo, -1);
		memo[1] = 1;
	}
	public static int answer(int a, int b) {
		if(memo[b]==1) return a; // 2^1
		else {
			memo[b] = memo[b-1]*a;
			return a*answer(a, b-1);
		}
	}

}
