package 문제23005회문만들기;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/문제23005회문만들기.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			for (String abc : s.split(" ")) {
				sb.append(abc);
			}
			int answer = 0;
			if (!isPalindrome(sb)) {
				answer = howToChange2(sb);
			}
			System.out.println(answer);
		}
	}
	public static boolean isPalindrome(StringBuilder sb) {
		for (int i = 0; i<sb.length()/2; i++) {
			if (sb.charAt(i)!=sb.charAt(sb.length()-1-i)) return false;
		}
		return true;
	}

	public static int howToChange2(StringBuilder sb) { // 반례...
		// XAXBXA -> X 하나만 필요하지만 3개 필요하다고 나오는 경우..
		int count = 0;
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i<sb.length(); i++) {
			if (sb.charAt(i)!='x') {
				sb2.append(sb.charAt(i));
			} else count++;
		}
		if (!isPalindrome(sb2)) count = -1;
		return count;
	}
	
}
